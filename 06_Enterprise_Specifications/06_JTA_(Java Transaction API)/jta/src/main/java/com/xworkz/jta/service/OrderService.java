package com.xworkz.jta.service;

import com.xworkz.jta.entity.OrderEntity;
import javax.transaction.Transactional;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Service class demonstrating JTA (Java Transaction API).
 * Focus: Atomicity - The "All or Nothing" principle.
 */
public class OrderService {

    @Inject
    private EntityManager em;

    /**
     * @Transactional: Automatically starts a transaction before the method runs
     * and commits it after the method finishes successfully.
     */
    @Transactional
    public void placeOrder(int productId, int quantity) {
        System.out.println("OrderService: Starting transaction for Product ID: " + productId);

        OrderEntity order = new OrderEntity();
        order.setProductId(productId);
        order.setQuantity(quantity);

        // Even though we persist here, it isn't "Final" in the DB yet.
        em.persist(order);
        System.out.println("Step 1: Order details staged in Persistence Context.");

        // SIMULATION: Testing the Rollback logic
        // If quantity is > 50, a RuntimeException is thrown.
        // JTA catches this and triggers an automatic ROLLBACK.
        if (quantity > 50) {
            System.err.println("CRITICAL: Stock limit exceeded! Triggering JTA Rollback...");
            throw new RuntimeException("ROLLBACK: Quantity " + quantity + " is too high for current stock!");
        }

        // If no exception occurs, the transaction is committed here.
        System.out.println("Step 2: Business logic passed. Transaction Committed to MySQL!");
    }
}
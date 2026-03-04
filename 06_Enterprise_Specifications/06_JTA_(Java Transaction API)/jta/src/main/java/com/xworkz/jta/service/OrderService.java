package com.xworkz.jta.service;

import com.xworkz.jta.entity.OrderEntity;
import javax.transaction.Transactional;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class OrderService {

    @Inject
    private EntityManager em;

    @Transactional
    public void placeOrder(int productId, int quantity) {
        OrderEntity order = new OrderEntity();
        order.setProductId(productId);
        order.setQuantity(quantity);

        em.persist(order);
        System.out.println("Step 1: Order saved for " + productId);

        // Fail simulation for Topic 6
        if (quantity > 50) {
            throw new RuntimeException("ROLLBACK: Quantity too high for stock!");
        }

        System.out.println("Step 2: Transaction complete!");
    }
}
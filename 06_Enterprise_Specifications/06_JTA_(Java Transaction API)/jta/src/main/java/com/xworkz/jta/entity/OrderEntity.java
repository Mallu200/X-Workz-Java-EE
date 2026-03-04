package com.xworkz.jta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// "orders" is used because 'ORDER' is a reserved keyword in SQL
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    private int quantity;

    /**
     * Helper for logging transaction attempts in the JTA module.
     */
    public void traceOrder() {
        System.out.println("--- Order Entity State ---");
        System.out.println("Product ID: " + productId + " | Qty: " + quantity);
        System.out.println("--------------------------");
    }
}
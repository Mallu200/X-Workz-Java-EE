package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok's annotation to generate Getters, Setters, toString, and EqualsAndHashCode
@Data
// Generates a constructor with no arguments
@NoArgsConstructor
// Generates a constructor with all arguments (orderId, productName, price)
@AllArgsConstructor
public class OrderDTO implements Serializable {

    // Unique identifier for the order
    private String orderId;

    // Name of the product being ordered
    private String productName;

    // Price of the product
    private double price;

    /* * Manually overriding toString to add a log statement whenever the
     * DTO data is printed or logged in the console.
     */
    @Override
    public String toString() {
        System.out.println("Accessing OrderDTO data for Order ID: " + orderId);
        return "OrderDTO(orderId=" + orderId + ", productName=" + productName + ", price=" + price + ")";
    }
}
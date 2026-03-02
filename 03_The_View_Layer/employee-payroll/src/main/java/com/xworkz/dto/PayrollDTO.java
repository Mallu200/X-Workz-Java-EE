package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Bundles @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
@Data
// Provides a default constructor required for many frameworks like Hibernate/Spring
@NoArgsConstructor
// Generates a constructor to initialize all fields (name, salary, paid)
@AllArgsConstructor
public class PayrollDTO implements Serializable {

    // Name of the employee or partner
    private String name;

    // Monthly or per-task salary amount
    private double salary;

    // Status flag to track if the payment has been processed
    private boolean paid;

    /**
     * Overriding toString to log data access to the console for debugging.
     */
    @Override
    public String toString() {
        System.out.println("Accessing PayrollDTO for: " + name + " | Status: " + (paid ? "Paid" : "Pending"));
        return "PayrollDTO(name=" + name + ", salary=" + salary + ", paid=" + paid + ")";
    }
}
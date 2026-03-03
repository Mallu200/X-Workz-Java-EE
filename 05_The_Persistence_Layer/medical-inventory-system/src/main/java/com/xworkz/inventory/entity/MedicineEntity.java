package com.xworkz.inventory.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
// Mapping the entity to the pharmacy inventory table
@Table(name = "medicine_table")
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Ensuring every medicine record has a name before saving
    @Column(name = "medicine_name", nullable = false)
    private String name;

    private String manufacturer;

    // Explicitly mapping to a specific column name for clarity in SQL
    @Column(name = "stock_count")
    private int stockQuantity;

    private double price;

    /**
     * Helper to log stock status.
     * Great for debugging inventory modules in the Clinic Management app.
     */
    public void logStockStatus() {
        System.out.println("--- Medicine Stock Check ---");
        System.out.println("Medicine: " + name + " | Manufacturer: " + manufacturer);
        System.out.println("Available Stock: " + stockQuantity + " | Price: ₹" + price);

        if (stockQuantity < 10) {
            System.err.println("WARNING: Low stock detected for " + name);
        }
        System.out.println("----------------------------");
    }
}
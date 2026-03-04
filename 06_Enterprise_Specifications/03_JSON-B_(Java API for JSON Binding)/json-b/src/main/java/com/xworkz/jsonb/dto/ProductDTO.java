package com.xworkz.jsonb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    // Renames the JSON key to 'product_id' instead of just 'id'
    @JsonbProperty("product_id")
    private int id;

    // Renames the JSON key to 'item_name'
    @JsonbProperty("item_name")
    private String name;

    private double price;

    // Completely hides this field from the JSON output (Security)
    @JsonbTransient
    private String internalSecretCode;

    // Formats the date to a readable string format in the JSON
    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate expiryDate;

    /**
     * Helper to verify DTO state before serialization.
     */
    public void traceDTO() {
        System.out.println("--- ProductDTO State ---");
        System.out.println("ID: " + id + " | Name: " + name);
        System.out.println("Expiry: " + expiryDate + " | Secret: " + internalSecretCode);
        System.out.println("-------------------------");
    }
}
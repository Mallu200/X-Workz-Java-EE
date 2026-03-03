package com.xworkz.property.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "property_listings")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Setting a maximum length of 100 characters for the title
    @Column(nullable = false, length = 100)
    private String title;

    // Unique constraint ensures data integrity for government-issued IDs
    @Column(unique = true)
    private String reraId;

    private String location;

    private double price;

    /**
     * @CreationTimestamp: A Hibernate-specific annotation that
     * automatically captures the system date/time during the INSERT.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP) // Formats as YYYY-MM-DD HH:MM:SS in MySQL
    private Date listedDate;

    /**
     * Helper to verify listing details in the console.
     */
    public void traceProperty() {
        System.out.println("--- Property Listing ---");
        System.out.println("Title: " + title + " | Location: " + location);
        System.out.println("RERA ID: " + reraId + " | Price: ₹" + price);
        System.out.println("Listed on: " + listedDate);
        System.out.println("-------------------------");
    }
}
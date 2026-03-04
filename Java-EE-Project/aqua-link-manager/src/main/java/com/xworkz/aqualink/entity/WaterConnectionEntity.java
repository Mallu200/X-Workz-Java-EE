package com.xworkz.aqualink.entity;

import com.xworkz.aqualink.enums.ConnectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Entity representing the 'water_connections' table in MySQL.
 * This class handles the actual storage of AquaLink data.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "water_connections")
public class WaterConnectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "consumer_name", nullable = false)
    private String consumerName;

    // unique = true ensures no two connections share the same meter number
    @Column(name = "meter_number", unique = true, nullable = false)
    private String meterNumber;

    @Column(name = "current_reading")
    private double currentReading;

    /**
     * EnumType.STRING: Stores the name of the enum constant in the DB.
     * This is safer for long-term maintenance than EnumType.ORDINAL.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "connection_type")
    private ConnectionType type;

    @Column(name = "is_active")
    private boolean active;

    /**
     * JPA Lifecycle Callback: Ensures a default status before saving.
     */
    @PrePersist
    public void onPrePersist() {
        System.out.println("JPA Lifecycle: Preparing to save connection for " + consumerName);
    }
}
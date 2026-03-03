package com.xworkz.vehicle.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
// Mapping to a custom table name suitable for an ERP or Logistics module
@Table(name = "transport_fleet_registry")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Ensuring data integrity: Unique registration numbers that cannot be null
    @Column(name = "reg_number", unique = true, nullable = false)
    private String registrationNumber;

    @Column(name = "vehicle_model")
    private String model;

    private String ownerName;

    /**
     * @Transient fields are used for real-time calculations.
     * Hibernate will ignore these during save/update operations.
     */
    @Transient
    private double currentFuelLevel;

    @Transient
    private String liveStatus;

    // Total mileage stored in the database
    private double totalDistanceTravelled;

    /**
     * Helper method to verify the object state in the console.
     */
    public void traceVehicleState() {
        System.out.println("--- Vehicle Trace ---");
        System.out.println("Reg No: " + registrationNumber + " | Model: " + model);
        System.out.println("Fuel (Transient): " + currentFuelLevel + "% | Status: " + liveStatus);
        System.out.println("---------------------");
    }
}
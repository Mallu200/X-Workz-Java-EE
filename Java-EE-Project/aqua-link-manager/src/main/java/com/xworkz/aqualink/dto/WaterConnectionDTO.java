package com.xworkz.aqualink.dto;

import com.xworkz.aqualink.enums.ConnectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * DTO for the AquaLink Water Management System.
 * Ensures data integrity from the UI to the Service layer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterConnectionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @NotNull(message = "Consumer name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String consumerName;

    @NotBlank(message = "Meter number is required")
    // Enforces strict formatting: "AQ-" followed by exactly 5 digits
    @Pattern(regexp = "^AQ-[0-9]{5}$", message = "Meter number must follow format AQ-12345")
    private String meterNumber;

    @PositiveOrZero(message = "Reading cannot be negative")
    private double currentReading;

    // Forces the user to select from your ConnectionType Enum (Residential, Commercial, Industrial)
    @NotNull(message = "Please select a connection type")
    private ConnectionType type;

    private boolean active;

    /**
     * Helper to trace DTO state during validation audits.
     */
    public void traceConnection() {
        System.out.println("--- AquaLink DTO Audit ---");
        System.out.println("Consumer: " + consumerName + " | Meter: " + meterNumber);
        System.out.println("Type: " + (type != null ? type.getValue() : "NOT_SELECTED"));
        System.out.println("--------------------------");
    }
}
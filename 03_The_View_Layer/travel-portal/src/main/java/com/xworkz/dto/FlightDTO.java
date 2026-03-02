package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Generates getters, setters, toString, and other boilerplate code
@Data
// Required for object initialization by frameworks and custom logic
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO implements Serializable {

    // The name of the airline company
    private String airline;

    // The arrival city for the flight
    private String destination;

    // Formatted ticket price (e.g., ₹4,200)
    private String ticketPrice;

    /**
     * Overriding toString to log flight details to the console.
     * Useful for verifying that the ArrayList in your FlightController is populated correctly.
     */
    @Override
    public String toString() {
        System.out.println("Processing FlightDTO: " + airline + " to " + destination);
        return "FlightDTO(airline=" + airline + ", destination=" + destination + ", ticketPrice=" + ticketPrice + ")";
    }
}
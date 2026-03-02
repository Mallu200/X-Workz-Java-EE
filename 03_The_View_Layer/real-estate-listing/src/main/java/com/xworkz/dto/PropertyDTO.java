package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok annotation to automatically create getters, setters, and other boilerplate
@Data
// Generates a no-argument constructor required for serialization/frameworks
@NoArgsConstructor
// Generates a constructor that initializes all fields (title, location, price)
@AllArgsConstructor
public class PropertyDTO implements Serializable {

    // The name or headline of the property listing
    private String title;

    // The geographic area where the property is situated
    private String location;

    // The listed cost of the property
    private String price;

    /**
     * Manually overriding toString to add a log statement for debugging purposes.
     * This will help you see when property data is being accessed in the console.
     */
    @Override
    public String toString() {
        System.out.println("Accessing PropertyDTO: " + title + " located at " + location);
        return "PropertyDTO(title=" + title + ", location=" + location + ", price=" + price + ")";
    }
}
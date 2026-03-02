package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok annotation to generate getters, setters, and core object methods
@Data
// Generates a constructor for all fields (name, membershipType, loyaltyPoints)
@AllArgsConstructor
// Required for frameworks like Hibernate to instantiate the object via reflection
@NoArgsConstructor
public class MemberDTO implements Serializable {

    // The full name of the registered member
    private String name;

    // Category of membership (e.g., Gold, Silver, Platinum)
    private String membershipType;

    // Accumulated points based on user activity or purchases
    private int loyaltyPoints;

    /**
     * Overriding toString to provide a console trace when the DTO is processed.
     */
    @Override
    public String toString() {
        System.out.println("Processing MemberDTO for: " + name + " [" + membershipType + "]");
        return "MemberDTO(name=" + name + ", membershipType=" + membershipType + ", loyaltyPoints=" + loyaltyPoints + ")";
    }
}
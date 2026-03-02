package com.xworkz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok annotation to generate getters, setters, and utility methods
@Data
// Generates a constructor with all fields (accountNumber, accountHolder, balance)
@AllArgsConstructor
// Required for frameworks like Hibernate to instantiate the object
@NoArgsConstructor
public class UserDTO implements Serializable {

    // Unique identification number for the bank account
    private String accountNumber;

    // Legal name of the person owning the account
    private String accountHolder;

    // Current available funds in the account
    private double balance;

    /**
     * Overriding toString to provide a console trace for data debugging.
     */
    @Override
    public String toString() {
        System.out.println("Accessing UserDTO for Account: " + accountNumber);
        return "UserDTO(accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance=" + balance + ")";
    }
}
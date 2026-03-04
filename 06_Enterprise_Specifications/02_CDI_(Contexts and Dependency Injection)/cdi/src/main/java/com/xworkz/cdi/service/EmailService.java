package com.xworkz.cdi.service;

import javax.enterprise.context.Dependent;

/**
 * Service class for handling email logic.
 * @Dependent is the default scope in CDI.
 */
@Dependent
public class EmailService {

    public EmailService() {
        System.out.println("EmailService: Instance created by CDI container.");
    }

    public void send(String message) {
        // Business logic for sending emails
        System.out.println("EmailService Status: Dispatching message -> " + message);
        System.out.println("Result: Email Sent successfully!");
    }
}
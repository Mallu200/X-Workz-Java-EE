package com.xworkz.cdi.controller;

import com.xworkz.cdi.service.EmailService;
import javax.inject.Inject;

/**
 * Controller class demonstrating Dependency Injection.
 * The container will automatically provide an instance of EmailService.
 */
public class NotificationController {

    /**
     * @Inject: Tells the CDI container to find a valid bean of type EmailService
     * and inject it here at runtime. No 'new' keyword needed!
     */
    @Inject
    private EmailService emailService;

    public void processNotification(String msg) {
        System.out.println("NotificationController: Received message: " + msg);

        if (emailService != null) {
            System.out.println("NotificationController: Delegating to injected EmailService...");
            emailService.send(msg);
        } else {
            System.err.println("NotificationController ERROR: EmailService was not injected!");
        }
    }
}
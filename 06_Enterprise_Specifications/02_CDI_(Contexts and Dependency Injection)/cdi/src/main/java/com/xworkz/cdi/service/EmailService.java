package com.xworkz.cdi.service;

import javax.enterprise.context.Dependent;

@Dependent
public class EmailService {
    public void send(String message) {
        System.out.println("Email Sent: " + message);
    }
}

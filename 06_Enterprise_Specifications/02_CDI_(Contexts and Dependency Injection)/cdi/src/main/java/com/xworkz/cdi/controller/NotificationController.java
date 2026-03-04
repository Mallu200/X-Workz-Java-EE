package com.xworkz.cdi.controller;

import com.xworkz.cdi.service.EmailService;

import javax.inject.Inject;

public class NotificationController {

    @Inject
    private EmailService emailService;

    public void processNotification(String msg) {
        emailService.send(msg);
    }
}

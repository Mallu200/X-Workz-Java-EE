package com.xworkz.cdi;

import com.xworkz.cdi.controller.NotificationController;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class CDIRunner {
    public static void main(String[] args) {
        System.out.println("CDIRunner: Initializing Weld Container...");

        // 1. Initialize the CDI Container (Weld SE)
        // This scans your classpath for classes with CDI annotations
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        System.out.println("CDIRunner: Container is ready. Fetching Controller...");

        // 2. Request the bean from the container
        // Instead of 'new NotificationController()', we ask the container
        NotificationController controller = container.select(NotificationController.class).get();

        // 3. Use the bean
        // At this point, the EmailService is already automatically @Injected!
        controller.processNotification("Hello Mallikarjun, CDI is working!");

        // 4. Shutdown
        System.out.println("CDIRunner: Shutting down container...");
        weld.shutdown();
    }
}
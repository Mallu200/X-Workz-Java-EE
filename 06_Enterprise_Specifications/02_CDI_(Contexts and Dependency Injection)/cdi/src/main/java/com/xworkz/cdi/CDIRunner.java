package com.xworkz.cdi;

import com.xworkz.cdi.controller.NotificationController;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class CDIRunner {
    public static void main(String[] args) {
        // 1. Initialize the CDI Container (Weld)
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        // 2. Request the bean from the container
        NotificationController controller = container.select(NotificationController.class).get();

        // 3. Use the bean
        controller.processNotification("Hello Mallikarjun, CDI is working!");

        // 4. Shutdown
        weld.shutdown();
    }
}

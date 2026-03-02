package com.xworkz.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Listener to monitor the lifecycle of HttpSessions.
 * Useful for real-time user tracking in modules like Prodex or MyLocalDoctor.
 */
@WebListener
public class UserActivityListener implements HttpSessionListener {

    // Thread-safe counter for concurrent session management
    private static final AtomicInteger activeUsers = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Increment count when a new session is initialized
        int currentCount = activeUsers.incrementAndGet();

        System.out.println("--- Session Created ---");
        System.out.println("Session ID: " + se.getSession().getId());
        System.out.println("Current Online Users: " + currentCount);
        System.out.println("-----------------------");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Decrement count when session.invalidate() is called or timeout occurs
        int currentCount = activeUsers.decrementAndGet();

        System.out.println("--- Session Destroyed ---");
        System.out.println("Session ID: " + se.getSession().getId());
        System.out.println("Remaining Online Users: " + currentCount);
        System.out.println("--------------------------");
    }

    /**
     * Static utility method to fetch the current count for Servlets or JSPs.
     */
    public static int getActiveUserCount() {
        return activeUsers.get();
    }
}
package com.xworkz.jta.controller;

import com.xworkz.jta.service.OrderService;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet to trigger and test JTA Transactional behavior.
 * URL: http://localhost:8080/your-app-context/test-jta
 */
@WebServlet("/test-jta")
public class JTATestServlet extends HttpServlet {

    // CDI Container provides the managed service with @Transactional support
    @Inject
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");

        System.out.println("JTATestServlet: Received request to place order.");

        try {
            // This call is intercepted by the JTA Transaction Manager
            // Since quantity is 100 (> 50), it will trigger the RuntimeException in OrderService
            orderService.placeOrder(101, 100);

            resp.getWriter().write("Order Processed Successfully!");
            System.out.println("JTATestServlet: Transaction Committed.");

        } catch (Exception e) {
            // JTA detects the RuntimeException and performs an automatic ROLLBACK
            System.err.println("JTATestServlet: Exception caught - " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Transaction Status: ROLLED BACK\n");
            resp.getWriter().write("Reason: " + e.getMessage());
        }
    }
}
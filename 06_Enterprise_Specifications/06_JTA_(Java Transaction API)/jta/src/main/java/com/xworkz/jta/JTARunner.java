package com.xworkz.jta;

import com.xworkz.jta.service.OrderService;
import javax.inject.Inject;

public class JTARunner {

    // CDI Container injects the transactional service
    @Inject
    private OrderService orderService;

    public void runTest() {
        System.out.println("JTARunner: Starting Transactional Test Suite...");

        try {
            // Case 1: SUCCESS SCENARIO
            // Quantity is within limits, so the transaction will COMMIT.
            System.out.println("\n--- Case 1: Processing Standard Order ---");
            orderService.placeOrder(101, 5);
            System.out.println("Result: Data is now permanent in MySQL.");

            // Case 2: FAILURE SCENARIO
            // Quantity > 50 triggers a RuntimeException in OrderService.
            // JTA intercepts this and performs a ROLLBACK.
            System.out.println("\n--- Case 2: Processing Excessive Quantity ---");
            orderService.placeOrder(102, 100);

        } catch (Exception e) {
            System.err.println("\nCaught Expected Error: " + e.getMessage());
            System.out.println("Result: Database state is safe. Order 102 was NOT saved.");
        }

        System.out.println("\nJTARunner: Test Suite Execution Completed.");
    }
}
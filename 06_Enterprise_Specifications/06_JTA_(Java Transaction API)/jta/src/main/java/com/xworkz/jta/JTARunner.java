package com.xworkz.jta;

import com.xworkz.jta.service.OrderService;
import javax.inject.Inject;

public class JTARunner {

    @Inject
    private OrderService orderService;

    public void runTest() {
        try {
            // Case 1: This will succeed
            orderService.placeOrder(101, 5);

            // Case 2: This will fail and trigger a ROLLBACK
            orderService.placeOrder(102, 100);
        } catch (Exception e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
            System.out.println("Result: Database state is safe due to JTA Rollback.");
        }
    }
}
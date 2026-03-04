package com.xworkz.jta.controller;

import com.xworkz.jta.service.OrderService;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/test-jta")
public class JTATestServlet extends HttpServlet {
    @Inject
    private OrderService orderService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            orderService.placeOrder(101, 100); // This will trigger a Rollback
            resp.getWriter().write("Order Success!");
        } catch (Exception e) {
            resp.getWriter().write("Transaction Rolled Back: " + e.getMessage());
        }
    }
}
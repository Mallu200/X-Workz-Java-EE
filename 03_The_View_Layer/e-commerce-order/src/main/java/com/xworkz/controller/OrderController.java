package com.xworkz.controller;

import com.xworkz.dto.OrderDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mapping the servlet to the /process-order URL pattern
@WebServlet("/process-order")
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entering OrderController.doPost method...");

        // Retrieving product details from the request parameters
        String name = request.getParameter("pName");
        double cost = Double.parseDouble(request.getParameter("pPrice"));

        System.out.println("Received Order Request: Product = " + name + ", Price = " + cost);

        // Creating and populating the OrderDTO object
        OrderDTO dto = new OrderDTO();
        dto.setOrderId("ORD-" + System.currentTimeMillis()); // Generating a unique Order ID
        dto.setProductName(name);
        dto.setPrice(cost);

        System.out.println("Generated DTO: " + dto.getOrderId());

        // Storing the DTO in the request scope to pass it to the view
        request.setAttribute("item", dto);

        // Forwarding the request and response to the dashboard.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);

        System.out.println("Order forwarded to dashboard.jsp successfully.");
    }
}
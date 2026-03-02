package com.xworkz.controller;

import com.xworkz.dto.PropertyDTO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to the /view-property URL endpoint
@WebServlet("/view-property")
public class PropertyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entering PropertyController.doGet...");

        // Simulating data retrieval for a specific property listing
        PropertyDTO prop = new PropertyDTO("Luxury 3BHK Apartment", "Indiranagar, Bengaluru", "₹2.8 Crores");

        System.out.println("Property Object Created: " + prop.getTitle());

        // Passing the DTO object into the Request Scope for the JSP to access
        req.setAttribute("property", prop);

        System.out.println("Forwarding request to dashboard.jsp...");

        // Forwarding the request and response to the view layer
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

        System.out.println("Property details successfully dispatched.");
    }
}
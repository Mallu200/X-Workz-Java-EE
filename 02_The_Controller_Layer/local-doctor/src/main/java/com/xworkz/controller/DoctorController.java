package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mapping the servlet to the /confirm-appointment URL pattern
@WebServlet("/confirm-appointment")
public class DoctorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("Entering DoctorController.doPost method...");

        // Retrieving patient name and appointment date from the request parameters
        String name = request.getParameter("pName");
        String date = request.getParameter("appDate");

        System.out.println("Processing appointment: Patient Name = " + name + ", Date = " + date);

        // Setting the response type as HTML for proper browser rendering
        response.setContentType("text/html");

        // Sending the confirmation message back to the client
        response.getWriter().print("<h1>Appointment for " + name + " confirmed for " + date + ".</h1>");

        System.out.println("Appointment confirmation sent successfully.");
    }
}
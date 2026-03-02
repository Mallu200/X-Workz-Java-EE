package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Mapping the servlet to the /submit-registration URL pattern
@WebServlet("/submit-registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("Entering RegistrationController.doPost method...");

        // Retrieving the student's name and technology preference from the form
        String name = request.getParameter("fullName");
        String tech = request.getParameter("tech");

        System.out.println("Processing registration for: " + name + " (Technology: " + tech + ")");

        // Setting the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Building the success UI message with basic styling
        out.println("<div style='text-align:center; margin-top:50px; font-family:sans-serif;'>");
        out.println("<h1 style='color:green;'>Success!</h1>");
        out.println("<p>Welcome, <b>" + name + "</b> to " + tech + ".</p>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</div>");

        System.out.println("Registration response rendered and sent successfully.");
    }
}
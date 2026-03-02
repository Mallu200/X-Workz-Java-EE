package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mapping the servlet to the /send-message URL pattern
@WebServlet("/send-message")
public class ContactController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("Entering doPost method in ContactController...");

        // Retrieving form data from the recruitment contact form
        String email = request.getParameter("recruiterEmail");
        String company = request.getParameter("company");

        System.out.println("Received contact request from Email: " + email + " for Company: " + company);

        // Setting the response type to HTML for the browser
        response.setContentType("text/html");

        // Sending the confirmation message back to the UI
        response.getWriter().print("<h1>Thank you! Mallikarjun will reply to " + email + " regarding " + company + " soon.</h1>");

        System.out.println("Response successfully sent to the client.");
    }
}
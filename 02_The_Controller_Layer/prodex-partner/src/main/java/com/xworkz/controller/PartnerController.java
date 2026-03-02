package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Mapping the servlet to the /save-partner URL pattern
@WebServlet("/save-partner")
public class PartnerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("Entering PartnerController.doPost method...");

        // Retrieving partner details from the request parameters
        String name = request.getParameter("partnerName");
        String type = request.getParameter("type");

        System.out.println("Processing data: Partner Name = " + name + ", Type = " + type);

        // Setting the response content type to HTML
        response.setContentType("text/html");

        // Outputting the confirmation message for the Prodex module
        response.getWriter().print("<h1>Prodex: " + type + " [" + name + "] Added Successfully!</h1>");

        System.out.println("Partner data successfully processed and response sent.");
    }
}
package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mapping the servlet to the /submit-script endpoint
@WebServlet("/submit-script")
public class ScriptController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("Initiating ScriptController.doPost...");

        // Retrieving the character name parameter from the request
        String character = request.getParameter("charName");

        System.out.println("Processing script for character: " + character);

        // Setting the response content type to HTML
        response.setContentType("text/html");

        // Outputting the confirmation and voice synthesis status to the browser
        response.getWriter().print("<h1>Script recorded for " + character + ". Processing voice synthesis...</h1>");

        System.out.println("Script submission response successfully rendered.");
    }
}
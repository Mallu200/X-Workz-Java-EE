package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to the /admin-portal URL endpoint
@WebServlet("/admin-portal")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Entering AdminServlet.doGet...");

        // Retrieving the current session
        HttpSession session = req.getSession();

        // Fetching the 'user' attribute stored during the login process
        String userName = (String) session.getAttribute("user");

        System.out.println("Accessing Admin Portal for user: " + userName);

        // Setting response type to plain text/html for the message
        resp.setContentType("text/plain");

        // Sending the welcome message to the browser
        if (userName != null) {
            resp.getWriter().print("Welcome to the Secure Admin Portal, " + userName);
            System.out.println("Welcome message displayed successfully.");
        } else {
            // Fallback in case the session exists but the attribute is missing
            resp.getWriter().print("Access Denied: No user found in session.");
            System.out.println("Warning: Admin access attempted without user attribute.");
        }

        System.out.println("AdminServlet request cycle finished.");
    }
}
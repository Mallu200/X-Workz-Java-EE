package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to the /do-login endpoint
@WebServlet("/do-login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Entering LoginServlet.doPost...");

        // Simulating a successful login by creating a new session or retrieving the current one
        HttpSession session = req.getSession();

        // Storing the username in Session Scope for persistent access across the admin portal
        session.setAttribute("userSession", "Mallikarjun");

        System.out.println("Session created for user: Mallikarjun | Session ID: " + session.getId());

        System.out.println("Redirecting to admin-portal...");

        // Redirecting to the admin portal endpoint
        resp.sendRedirect("admin-portal");

        System.out.println("Login redirection process completed.");
    }
}
package com.xworkz.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Mapping the servlet to the /logout URL endpoint
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Logout request initiated...");

        // Retrieving the existing session without creating a new one
        HttpSession session = req.getSession(false);

        // Checking if a session exists before attempting to invalidate
        if (session != null) {
            System.out.println("Invalidating Session ID: " + session.getId());
            session.invalidate(); // Destroys the session and removes all attributes
            System.out.println("Session invalidated successfully.");
        } else {
            System.out.println("No active session found to invalidate.");
        }

        // Redirecting the user back to the login page
        resp.sendRedirect("login.jsp");

        System.out.println("User redirected to login.jsp.");
    }
}
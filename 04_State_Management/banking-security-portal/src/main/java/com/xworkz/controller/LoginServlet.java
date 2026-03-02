package com.xworkz.controller;

import com.xworkz.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Mapping the servlet to the /bank-login URL endpoint
@WebServlet("/bank-login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Entering LoginServlet.doPost...");

        // Instantiating UserDTO with mock bank account data
        UserDTO user = new UserDTO();
        user.setAccountNumber("ACT-998877");
        user.setAccountHolder(req.getParameter("uName"));
        user.setBalance(50000.0);

        System.out.println("Login success for User: " + user.getAccountHolder());

        // Initializing or retrieving the current session
        HttpSession session = req.getSession();

        // Setting session timeout to 10 minutes (600 seconds)
        session.setMaxInactiveInterval(10 * 60);

        // Storing the user object in the Session Scope for persistence across pages
        session.setAttribute("userSession", user);

        System.out.println("Session ID: " + session.getId() + " - Redirecting to dashboard...");

        // Redirecting the client to the bank dashboard page
        resp.sendRedirect("bank-dashboard.jsp");

        System.out.println("Redirection complete.");
    }
}
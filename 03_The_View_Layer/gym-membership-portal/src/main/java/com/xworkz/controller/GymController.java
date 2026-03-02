package com.xworkz.controller;

import com.xworkz.dto.MemberDTO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to handle member profile retrieval
@WebServlet("/member-profile")
public class GymController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entering GymController.doGet...");

        // Creating a member profile with sample data
        MemberDTO member = new MemberDTO("C Mallikarjun", "Platinum Elite", 1500);

        System.out.println("Member profile generated for: " + member.getName());

        // Storing the member object in Request Scope for the JSP to render
        req.setAttribute("userProfile", member);

        System.out.println("Forwarding member data to dashboard.jsp...");

        // Transferring control to the view layer (JSP)
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

        System.out.println("GymController request cycle completed.");
    }
}
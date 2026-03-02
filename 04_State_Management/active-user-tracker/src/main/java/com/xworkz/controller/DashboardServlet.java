package com.xworkz.controller;

import com.xworkz.listener.UserActivityListener;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to the /view-stats endpoint for monitoring active users
@WebServlet("/view-stats")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Entering DashboardServlet.doGet - Fetching live statistics...");

        // Ensure a session exists; if not, req.getSession() creates one to trigger the listener
        HttpSession session = req.getSession();

        System.out.println("Current Session ID: " + session.getId());

        // Retrieving the static count maintained by the HttpSessionListener
        int onlineCount = UserActivityListener.getActiveUserCount();

        System.out.println("Real-time Active User Count retrieved: " + onlineCount);

        // Binding the count to the Request Scope for the JSP display
        req.setAttribute("onlineNow", onlineCount);

        try {
            System.out.println("Forwarding statistics to stats.jsp...");
            req.getRequestDispatcher("stats.jsp").forward(req, resp);
        } catch (Exception e) {
            System.err.println("Error during navigation to stats.jsp: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Dashboard statistics request completed.");
    }
}
package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Mapping the servlet to the /save-theme endpoint
@WebServlet("/save-theme")
public class ThemeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Entering ThemeServlet.doPost...");

        // Retrieving the theme color or name selected by the user
        String selectedTheme = req.getParameter("userTheme");

        System.out.println("User selected theme: " + selectedTheme);

        // 1. Create a Cookie for the theme preference
        Cookie themeCookie = new Cookie("siteTheme", selectedTheme);

        // 2. Set Cookie Life (Persist for 30 days)
        // Calculation: 30 days * 24 hours * 60 mins * 60 secs
        themeCookie.setMaxAge(30 * 24 * 60 * 60);

        System.out.println("Cookie 'siteTheme' configured for 30-day persistence.");

        // 3. Add the cookie to the response to save it in the browser
        resp.addCookie(themeCookie);

        System.out.println("Theme cookie added to response header. Redirecting...");

        // 4. Redirecting back to the settings page to reflect changes
        resp.sendRedirect("settings.jsp");

        System.out.println("Theme update cycle completed.");
    }
}
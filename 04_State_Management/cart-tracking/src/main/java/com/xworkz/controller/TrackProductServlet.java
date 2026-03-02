package com.xworkz.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

// Mapping the servlet to handle product tracking via cookies
@WebServlet("/track-product")
public class TrackProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("Entering TrackProductServlet.doPost...");

        // Retrieving the product name from the request parameter
        String product = req.getParameter("pName");

        System.out.println("Tracking product: " + product);

        // 1. Create a Cookie (Key-Value pair)
        // Encoding handles spaces or special characters to avoid cookie errors
        Cookie productCookie = new Cookie("lastViewed", URLEncoder.encode(product, "UTF-8"));

        // 2. Set Cookie Life (Persist for 24 hours)
        // Values in seconds: 24 hours * 60 mins * 60 secs
        productCookie.setMaxAge(24 * 60 * 60);

        System.out.println("Cookie 'lastViewed' created with expiry: " + productCookie.getMaxAge() + "s");

        // 3. Add Cookie to the Response header to be sent to the client's browser
        resp.addCookie(productCookie);

        System.out.println("Cookie added to response. Redirecting to view-cart.jsp...");

        // 4. Redirecting to the display page
        resp.sendRedirect("view-cart.jsp");

        System.out.println("Redirection triggered successfully.");
    }
}
package com.xworkz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

// Secure specific URL patterns: Only users with a valid session can access these
@WebFilter(urlPatterns = {"/admin-portal", "/dashboard.jsp"})
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        System.out.println("SessionFilter: Intercepting request for URI: " + uri);

        // 1. Check for existing session (false means don't create a new one)
        HttpSession session = req.getSession(false);

        // 2. Logic: If no session OR no 'userSession' attribute exists, redirect to login
        if (session == null || session.getAttribute("userSession") == null) {
            System.out.println("Unauthorized access attempt detected at: " + uri);
            System.out.println("Redirecting user to login.jsp...");

            // Appending a query parameter to show an error message on the login page
            resp.sendRedirect("login.jsp?error=unauthorized");
        } else {
            // 3. Authorized! The 'userSession' exists.
            System.out.println("User authorized: " + session.getAttribute("userSession"));

            // Pass the request along the filter chain to the target Servlet or JSP
            chain.doFilter(request, response);
        }
    }

    @Override public void init(FilterConfig filterConfig) {
        System.out.println("SessionFilter initialized.");
    }

    @Override public void destroy() {
        System.out.println("SessionFilter destroyed.");
    }
}
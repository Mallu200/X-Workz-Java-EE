package com.xworkz.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

/**
 * Filter to protect sensitive API endpoints using Basic Authentication.
 * Target: Any DELETE operation under /api/secure-med/
 */
@WebFilter("/api/secure-med/delete/*")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("SecurityFilter: Intercepting request to: " + req.getRequestURI());

        // 1. Extract Authorization header
        String authHeader = req.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            try {
                // 2. Decode the Base64 credentials
                String base64Credentials = authHeader.substring(6);
                byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
                String credentials = new String(decodedBytes);

                // Expected format: username:password
                System.out.println("SecurityFilter: Validating credentials...");

                // 3. Validation Logic (mallikarjun/password123)
                if ("mallikarjun:password123".equals(credentials)) {
                    System.out.println("SecurityFilter: Authentication Successful. Proceeding to Resource.");
                    chain.doFilter(request, response); // Passes the request to the next filter or servlet
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("SecurityFilter: Malformed Authorization header.");
            }
        }

        // 4. If validation fails, trigger the browser's login box
        System.out.println("SecurityFilter: Authentication Failed. Sending 401 Unauthorized.");
        res.setHeader("WWW-Authenticate", "Basic realm=\"Medicine-Security-App\"");
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Error
        res.getWriter().write("401 Unauthorized: Access Denied. Please provide valid credentials.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SecurityFilter: Initialized and guarding secure endpoints.");
    }

    @Override
    public void destroy() {
        System.out.println("SecurityFilter: Destroyed.");
    }
}
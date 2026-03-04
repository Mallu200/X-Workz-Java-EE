package com.xworkz.security.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebFilter("/api/secure-med/delete/*")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Extract Authorization header
        String authHeader = req.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring(6);
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);

            // Validate: mallikarjun/password123
            if (credentials.equals("mallikarjun:password123")) {
                chain.doFilter(request, response);
                return;
            }
        }

        // If validation fails, trigger the browser's login box
        res.setHeader("WWW-Authenticate", "Basic realm=\"Medicine-Security-App\"");
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.getWriter().write("401 Unauthorized: Please provide valid credentials.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
package com.xworkz.controller;

import com.xworkz.dto.PayrollDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Mapping the servlet to handle payroll verification requests
@WebServlet("/check-payroll")
public class PayrollController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entering PayrollController.doPost method...");

        // Extracting employee name and salary from the request parameters
        String empName = request.getParameter("empName");
        double amount = Double.parseDouble(request.getParameter("salary"));

        System.out.println("Processing payroll for: " + empName + " | Salary Amount: " + amount);

        // Initializing the DTO and setting values
        PayrollDTO dto = new PayrollDTO();
        dto.setName(empName);
        dto.setSalary(amount);

        // Auto-calculating 'paid' status based on a 50,000 threshold logic
        dto.setPaid(amount < 50000);

        System.out.println("Payroll Data Prepared: " + dto);

        // Binding the DTO to the request scope for use in the JSP
        request.setAttribute("employee", dto);

        // Forwarding the control to dashboard.jsp to display the results
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        System.out.println("Payroll request forwarded to dashboard.jsp.");
    }
}
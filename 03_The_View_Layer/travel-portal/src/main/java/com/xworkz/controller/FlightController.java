package com.xworkz.controller;

import com.xworkz.dto.FlightDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Mapping the servlet to handle flight search requests via /search-flights
@WebServlet("/search-flights")
public class FlightController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Entering FlightController.doGet (Search triggered)...");

        // Creating an ArrayList to hold FlightDTO objects
        List<FlightDTO> flights = new ArrayList<>();

        // Adding mock flight data to the list
        flights.add(new FlightDTO("IndiGo", "Bengaluru", "₹4,200"));
        flights.add(new FlightDTO("Air India", "Mumbai", "₹5,500"));
        flights.add(new FlightDTO("Akasa Air", "Goa", "₹3,800"));

        System.out.println("Flight results count: " + flights.size());

        // Storing the flight list in request scope for the JSP to access
        request.setAttribute("flightList", flights);

        System.out.println("Forwarding control to dashboard.jsp...");

        // Navigating to the view layer using RequestDispatcher
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        System.out.println("Request successfully dispatched to dashboard.jsp.");
    }
}
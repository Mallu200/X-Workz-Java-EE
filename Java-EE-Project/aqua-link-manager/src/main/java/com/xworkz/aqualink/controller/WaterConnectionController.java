package com.xworkz.aqualink.controller;

import com.xworkz.aqualink.dto.WaterConnectionDTO;
import com.xworkz.aqualink.enums.ConnectionType;
import com.xworkz.aqualink.service.WaterConnectionService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {
        "/register",
        "/viewAll",
        "/update",
        "/updateData",
        "/delete",
        "/search",
        "/updateReading"
})
public class WaterConnectionController extends HttpServlet {

    @Inject
    private WaterConnectionService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println("Controller: doPost started for path: " + path);

        try {
            if (path.equals("/register")) {
                System.err.println("!!!!!!!!!!!!!!!! CONTROLLER HIT !!!!!!!!!!!!!!!!");
                System.out.println("Flow: Processing Registration started...");
                WaterConnectionDTO dto = mapRequestToDto(req);
                boolean saved = service.validateAndSave(dto);
                handleResponse(req, resp, saved, "Registered Successfully!", "index.jsp");
                System.out.println("Flow: Processing Registration ended. Status: " + saved);
            }

            else if (path.equals("/updateData")) {
                System.out.println("Flow: Processing Full Update started...");
                WaterConnectionDTO dto = mapRequestToDto(req);
                dto.setId(Integer.parseInt(req.getParameter("id")));
                boolean updated = service.validateAndUpdate(dto);
                if (updated) {
                    System.out.println("Flow: Update success, redirecting to viewAll.");
                    resp.sendRedirect("viewAll");
                } else {
                    System.out.println("Flow: Update failed, returning to update.jsp.");
                    handleResponse(req, resp, false, "Update Failed!", "update.jsp");
                }
                System.out.println("Flow: Processing Full Update ended.");
            }

            else if (path.equals("/updateReading")) {
                System.out.println("Flow: Processing JTA Atomic Reading Update started...");
                int id = Integer.parseInt(req.getParameter("id"));
                double reading = Double.parseDouble(req.getParameter("currentReading"));
                service.updateMeterReading(id, reading);
                resp.sendRedirect("viewAll");
                System.out.println("Flow: Processing Atomic Reading Update ended.");
            }
        } catch (Exception e) {
            System.err.println("Controller Error: Exception in doPost - " + e.getMessage());
            req.setAttribute("msg", "Error: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        System.out.println("Controller: doPost method execution completed.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println("Controller: doGet started for path: " + path);

        if (path.equals("/viewAll")) {
            System.out.println("Flow: Fetching All Connections started...");
            List<WaterConnectionDTO> list = service.getAll();
            req.setAttribute("connections", list);
            req.getRequestDispatcher("viewAll.jsp").forward(req, resp);
            System.out.println("Flow: Fetching All Connections ended. Count: " + list.size());
        }

        else if (path.equals("/update")) {
            System.out.println("Flow: Fetching single record for Edit started...");
            int id = Integer.parseInt(req.getParameter("id"));
            service.getById(id).ifPresent(dto -> req.setAttribute("connection", dto));
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Flow: Fetching single record ended.");
        }

        else if (path.equals("/delete")) {
            System.out.println("Flow: Processing Deletion started for ID: " + req.getParameter("id"));
            int id = Integer.parseInt(req.getParameter("id"));
            service.removeById(id);
            resp.sendRedirect("viewAll");
            System.out.println("Flow: Processing Deletion ended.");
        }

        else if (path.equals("/search")) {
            System.out.println("Flow: Processing Search started...");
            String name = req.getParameter("consumerName");
            List<WaterConnectionDTO> results = service.searchByConsumerName(name);
            req.setAttribute("connections", results);
            req.getRequestDispatcher("viewAll.jsp").forward(req, resp);
            System.out.println("Flow: Processing Search ended. Results found: " + results.size());
        }
        System.out.println("Controller: doGet method execution completed.");
    }

    private WaterConnectionDTO mapRequestToDto(HttpServletRequest req) {
        System.out.println("Helper: mapRequestToDto mapping started...");
        WaterConnectionDTO dto = new WaterConnectionDTO();
        dto.setConsumerName(req.getParameter("consumerName"));
        dto.setMeterNumber(req.getParameter("meterNumber"));
        dto.setCurrentReading(Double.parseDouble(req.getParameter("currentReading")));
        dto.setType(ConnectionType.valueOf(req.getParameter("type")));
        dto.setActive(true);
        System.out.println("Helper: mapRequestToDto mapping ended.");
        return dto;
    }

    private void handleResponse(HttpServletRequest req, HttpServletResponse resp,
                                boolean success, String message, String page) throws ServletException, IOException {
        System.out.println("Helper: handleResponse preparing redirect/forward...");
        req.setAttribute("msg", message);
        req.getRequestDispatcher(page).forward(req, resp);
        System.out.println("Helper: handleResponse forward completed.");
    }
}
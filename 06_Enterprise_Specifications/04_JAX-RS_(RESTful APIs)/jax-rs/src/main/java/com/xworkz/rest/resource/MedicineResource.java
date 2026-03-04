package com.xworkz.rest.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * Resource class for managing Medicine data via REST API.
 * Base URL: http://localhost:8080/jax-rs/api/medicine
 */
@Path("/medicine")
public class MedicineResource {

    /**
     * READ Operation: Fetches a list of medicine names.
     * Triggered by: HTTP GET
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON) // Automatically converts List to JSON array
    public List<String> getMedicines() {
        System.out.println("MedicineResource: getMedicines() called via GET request.");
        return Arrays.asList("Paracetamol", "Amoxicillin", "Ibuprofen");
    }

    /**
     * CREATE Operation: Saves a new medicine name.
     * Triggered by: HTTP POST to /api/medicine/save
     */
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveMedicine(String medName) {
        System.out.println("MedicineResource: Received POST request to save: " + medName);

        // Simulating logic to save to MySQL via DAO
        if (medName != null && !medName.isEmpty()) {
            return Response.status(Response.Status.CREATED) // HTTP 201
                    .entity("Medicine '" + medName + "' Saved Successfully!")
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST) // HTTP 400
                    .entity("Invalid Medicine Name")
                    .build();
        }
    }
}
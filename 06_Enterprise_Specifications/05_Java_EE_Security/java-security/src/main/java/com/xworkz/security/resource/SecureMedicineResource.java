package com.xworkz.security.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Resource to demonstrate protected vs public endpoints.
 * Base Path: http://localhost:8080/jax-rs/api/secure-med
 */
@Path("/secure-med")
public class SecureMedicineResource {

    /**
     * SECURE ENDPOINT: Only accessible if SecurityFilter passes.
     * Triggered by: HTTP DELETE /api/secure-med/delete/10
     */
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String removeMedicine(@PathParam("id") int id) {
        System.out.println("SecureMedicineResource: Access Granted to delete ID: " + id);

        // In a real scenario, you would call MedicineDAO.delete(id) here
        return "SUCCESS: Medicine ID " + id + " has been deleted from the database.";
    }

    /**
     * PUBLIC ENDPOINT: Accessible to everyone (No Filter).
     * Triggered by: HTTP GET /api/secure-med/list
     */
    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPublicList() {
        System.out.println("SecureMedicineResource: Serving public access list.");
        return "PUBLIC DATA: Paracetamol, Aspirin, Vitamin C (Open Access)";
    }
}
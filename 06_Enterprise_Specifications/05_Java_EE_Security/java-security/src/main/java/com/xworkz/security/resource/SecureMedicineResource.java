package com.xworkz.security.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/secure-med")
public class SecureMedicineResource {

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String removeMedicine(@PathParam("id") int id) {
        return "SUCCESS: Medicine ID " + id + " has been deleted from the database.";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPublicList() {
        return "PUBLIC DATA: Paracetamol, Aspirin, Vitamin C (Open Access)";
    }
}
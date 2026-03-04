package com.xworkz.rest.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/medicine") // Access via: /api/medicine
public class MedicineResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getMedicines() {
        return Arrays.asList("Paracetamol", "Amoxicillin", "Ibuprofen");
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveMedicine(String medName) {
        System.out.println("Saving: " + medName);
        return Response.status(201).entity("Medicine Saved Successfully!").build();
    }
}

// to Check go to : http://localhost:8080/jax-rs/api/medicine
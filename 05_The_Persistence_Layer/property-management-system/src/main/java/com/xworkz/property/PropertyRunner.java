package com.xworkz.property;

import com.xworkz.property.dao.PropertyDAO;
import com.xworkz.property.entity.PropertyEntity;

public class PropertyRunner {
    public static void main(String[] args) {

        System.out.println("Property Management System Initialized...");
        PropertyDAO dao = new PropertyDAO();

        // 1. CREATE - Testing Persistence & Automation
        System.out.println("\n--- Step 1: Listing a New Property ---");
        PropertyEntity p1 = new PropertyEntity();
        p1.setTitle("Luxury 3BHK Apartment");
        p1.setReraId("KA-RERA-12345");
        p1.setLocation("Indiranagar, Bengaluru");
        p1.setPrice(15000000.0);

        // We do NOT set the listedDate manually; Hibernate handles it.
        dao.create(p1);

        System.out.println("Persistence check: RERA ID " + p1.getReraId() + " saved.");

        // 2. READ & UPDATE - Testing Retrieval and Dirty Checking
        System.out.println("\n--- Step 2: Retrieving & Updating Listing ---");
        // Assuming ID 1 is the generated Primary Key
        PropertyEntity fetched = dao.getById(1);

        if(fetched != null) {
            System.out.println("Fetched Property: " + fetched.getTitle());
            // Verify that @CreationTimestamp worked
            System.out.println("System Generated Listing Date: " + fetched.getListedDate());

            System.out.println("Initiating price appreciation update...");
            dao.updatePrice(1, 15500000.0);
            System.out.println("Update sequence completed.");
        } else {
            System.out.println("Error: Property record not found in MySQL.");
        }

        System.out.println("\nPropertyRunner execution finished.");
    }
}
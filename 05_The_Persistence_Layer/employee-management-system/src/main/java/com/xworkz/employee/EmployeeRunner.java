package com.xworkz.employee;

import com.xworkz.employee.dao.EmployeeDAO;
import com.xworkz.employee.entity.EmployeeEntity;
import com.xworkz.employee.constant.JobRole;

public class EmployeeRunner {
    public static void main(String[] args) {

        System.out.println("Starting Employee Management System...");
        EmployeeDAO dao = new EmployeeDAO();

        // 1. CREATE - Testing Persistence with Enum and @Lob
        System.out.println("\n--- Step 1: Creating Employee Record ---");
        EmployeeEntity emp = new EmployeeEntity();
        emp.setName("C Mallikarjun");
        emp.setEmail("mallikarjun@example.com");
        emp.setRole(JobRole.DEVELOPER);
        // This large string tests the @Lob / LONGTEXT mapping
        emp.setProfileBio("Aspiring Full Stack Developer with expertise in Java, Spring, and JPA. " +
                "Experienced in building ERP Customer Management modules.");
        emp.setSalary(65000.0);

        dao.save(emp);
        System.out.println("Successfully persisted: " + emp.getName() + " as " + emp.getRole());

        // 2. UPDATE - Testing Dirty Checking and Enum Updates
        System.out.println("\n--- Step 2: Testing Role Promotion ---");
        // Updating ID 1 (Assuming generated ID is 1)
        dao.updateRole(1, JobRole.ARCHITECT);
        System.out.println("Role updated to: " + JobRole.ARCHITECT);

        // 3. READ - Testing Data Retrieval
        System.out.println("\n--- Step 3: Fetching Data from Database ---");
        EmployeeEntity fetched = dao.getById(1);

        if (fetched != null) {
            System.out.println("Name: " + fetched.getName());
            System.out.println("Current Role in DB: " + fetched.getRole());
            System.out.println("Bio retrieved from @Lob: " + fetched.getProfileBio());
        } else {
            System.out.println("Employee record not found. Please check the ID.");
        }

        System.out.println("\nEmployeeRunner process completed.");
    }
}
package com.xworkz.validation;

import com.xworkz.validation.dto.JobDTO;
import com.xworkz.validation.util.ValidationUtil;

public class JobValidationRunner {
    public static void main(String[] args) {

        System.out.println("Initializing Validation Module...");
        ValidationUtil<JobDTO> util = new ValidationUtil<>();

        // Test Case 1: Testing the "Fail-Fast" Logic
        System.out.println("\n--- Test Case 1: Processing Invalid Input ---");
        JobDTO invalidJob = new JobDTO();
        invalidJob.setTitle(""); // Fails @NotBlank
        invalidJob.setContactEmail("mallikarjun.com"); // Fails @Email
        invalidJob.setSalary(-5000); // Fails @Positive
        invalidJob.setJobType("INTERNSHIP"); // Fails @Pattern (Not in whitelist)

        // The utility will print each specific error message
        util.validate(invalidJob);

        System.out.println("\n-------------------------------------------");

        // Test Case 2: Testing Successful Flow
        System.out.println("--- Test Case 2: Processing Valid Input ---");
        JobDTO validJob = new JobDTO();
        validJob.setTitle("Java Developer");
        validJob.setDescription("Expert in Spring and JPA logic for ERP systems.");
        validJob.setContactEmail("mallikarjun@xworkz.com");
        validJob.setSalary(65000);
        validJob.setJobType("FULL_TIME");

        // Using the boolean return type to control application flow
        if (util.validate(validJob)) {
            System.out.println("Action: Validation Passed. Data is safe to persist.");
            System.out.println("Result: Proceeding to save in MySQL via JobDAO...");
        } else {
            System.err.println("Action: Validation Failed. Aborting Database operation.");
        }

        System.out.println("\nJobValidationRunner execution finished.");
    }
}
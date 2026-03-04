package com.xworkz.validation;

import com.xworkz.validation.dto.JobDTO;
import com.xworkz.validation.util.ValidationUtil;

public class JobValidationRunner {
    public static void main(String[] args) {
        ValidationUtil<JobDTO> util = new ValidationUtil<>();

        // Test Case 1: Invalid Data
        JobDTO invalidJob = new JobDTO();
        invalidJob.setTitle(""); // Trigger @NotBlank
        invalidJob.setContactEmail("mallikarjun.com"); // Trigger @Email
        invalidJob.setSalary(-5000); // Trigger @Positive
        invalidJob.setJobType("INTERNSHIP"); // Trigger @Pattern

        util.validate(invalidJob);

        System.out.println("-----------------------------------");

        // Test Case 2: Valid Data
        JobDTO validJob = new JobDTO();
        validJob.setTitle("Java Developer");
        validJob.setDescription("Expert in Spring and JPA logic");
        validJob.setContactEmail("mallikarjun@xworkz.com");
        validJob.setSalary(65000);
        validJob.setJobType("FULL_TIME");

        if (util.validate(validJob)) {
            System.out.println("Proceeding to save in Database...");
        }
    }
}

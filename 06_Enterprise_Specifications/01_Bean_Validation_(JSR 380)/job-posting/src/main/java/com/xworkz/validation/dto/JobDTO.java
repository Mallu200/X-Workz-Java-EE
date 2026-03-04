package com.xworkz.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

    // Ensures the title isn't null and has at least one non-whitespace character
    @NotBlank(message = "Job title cannot be blank")
    private String title;

    // Controls the length of the string—perfect for database column constraints
    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters")
    private String description;

    // Validates the string follows a proper email format (user@domain.com)
    @Email(message = "Contact email must be a valid email address")
    private String contactEmail;

    // Numerical constraints to ensure business logic (no negative salaries!)
    @Positive(message = "Salary must be a positive number")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    private double salary;

    // Using Regular Expressions (Regex) to restrict input to specific values
    @Pattern(regexp = "^(FULL_TIME|PART_TIME|CONTRACT)$", message = "Type must be FULL_TIME, PART_TIME, or CONTRACT")
    private String jobType;

    /**
     * Helper to trace the DTO status during the validation process.
     */
    public void traceJob() {
        System.out.println("--- Validating JobDTO: " + title + " ---");
        System.out.println("Type: " + jobType + " | Salary: ₹" + salary);
        System.out.println("------------------------------------------");
    }
}
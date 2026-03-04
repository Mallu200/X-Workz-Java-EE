package com.xworkz.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class JobDTO {

    @NotBlank(message = "Job title cannot be blank")
    private String title;

    @Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters")
    private String description;

    @Email(message = "Contact email must be a valid email address")
    private String contactEmail;

    @Positive(message = "Salary must be a positive number")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    private double salary;

    @Pattern(regexp = "^(FULL_TIME|PART_TIME|CONTRACT)$", message = "Type must be FULL_TIME, PART_TIME, or CONTRACT")
    private String jobType;
}

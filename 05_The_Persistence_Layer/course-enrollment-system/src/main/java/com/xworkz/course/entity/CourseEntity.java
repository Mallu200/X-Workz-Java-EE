package com.xworkz.course.entity;

import lombok.Data;
import javax.persistence.*;

// Lombok annotation to generate getters, setters, and toString automatically
@Data
// Specifies that this class is a JPA Entity mapped to a database table
@Entity
// Mapping the class to the specific table name in MySQL
@Table(name = "course_details")
public class CourseEntity {

    // Marks this field as the Primary Key
    @Id
    // Configures auto-increment behavior in MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Maps to a column named courseName (by default)
    private String courseName;

    // Maps to a column named trainerName
    private String trainerName;

    // Duration of the course in months
    private int durationMonths;

    // Total cost of the course
    private double fees;

    /**
     * Custom log helper to verify data before saving to the database.
     */
    public void printEntityDetails() {
        System.out.println("--- Course Entity State ---");
        System.out.println("Course: " + courseName + " | Trainer: " + trainerName);
        System.out.println("Fees: ₹" + fees + " | Duration: " + durationMonths + " months");
        System.out.println("---------------------------");
    }
}
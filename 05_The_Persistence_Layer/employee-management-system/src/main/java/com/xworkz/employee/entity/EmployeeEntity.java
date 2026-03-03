package com.xworkz.employee.entity;

import com.xworkz.employee.constant.JobRole;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_details")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Ensuring the name column is never null in the database
    @Column(nullable = false)
    private String name;

    private String email;

    // Mapping the Enum as a String for better database readability
    @Enumerated(EnumType.STRING)
    private JobRole role;

    // Mapping large text fields (like a resume or bio) to LONGTEXT or CLOB
    @Lob
    private String profileBio;

    private double salary;

    /**
     * Helper to trace employee data before database operations.
     */
    public void traceEmployee() {
        System.out.println("--- Employee Record ---");
        System.out.println("Name: " + name + " | Role: " + role);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Bio Length: " + (profileBio != null ? profileBio.length() : 0) + " chars");
        System.out.println("------------------------");
    }
}
package com.xworkz.course;

import com.xworkz.course.dao.CourseDAO;
import com.xworkz.course.entity.CourseEntity;
import java.util.List;

public class CourseRunner {
    public static void main(String[] args) {

        System.out.println("Execution Started: CourseRunner");

        // Initializing the Data Access Object
        CourseDAO dao = new CourseDAO();

        // 1. Create and Save Courses
        System.out.println("\n--- Step 1: Saving New Course Records ---");

        CourseEntity c1 = new CourseEntity();
        c1.setCourseName("Java Full Stack");
        c1.setTrainerName("Omkar");
        c1.setDurationMonths(6);
        c1.setFees(25000.0);
        dao.save(c1); // Triggers em.persist()

        CourseEntity c2 = new CourseEntity();
        c2.setCourseName("Enterprise Java");
        c2.setTrainerName("Omkar");
        c2.setDurationMonths(4);
        c2.setFees(30000.0);
        dao.save(c2);

        // 2. Search using JPQL (Java Persistence Query Language)
        System.out.println("\n--- Step 2: Testing JPQL Search ---");
        System.out.println("Searching for courses managed by trainer: Omkar");

        List<CourseEntity> omkarCourses = dao.findByTrainer("Omkar");

        if(omkarCourses.isEmpty()) {
            System.out.println("No records found in the database.");
        } else {
            omkarCourses.forEach(c -> System.out.println("Found: " + c.getCourseName() + " | Fees: ₹" + c.getFees()));
        }

        // 3. Bulk Update Operation
        System.out.println("\n--- Step 3: Testing Bulk Update Logic ---");
        System.out.println("Executing 10% fee hike for all registered courses...");

        dao.updateAllFees(10.0);

        System.out.println("\nExecution Completed Successfully.");
    }
}
package com.xworkz.course.dao;

import com.xworkz.course.entity.CourseEntity;
import javax.persistence.*;
import java.util.List;

public class CourseDAO {
    // Initializing the factory based on persistence.xml configuration
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory-unit");

    /**
     * Persists a new CourseEntity into the database.
     */
    public void save(CourseEntity entity) {
        System.out.println("CourseDAO: Attempting to save entity: " + entity.getCourseName());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity); // Moves entity from Transient to Persistent state
            tx.commit();
            System.out.println("CourseDAO: Entity saved successfully with ID: " + entity.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback(); // Undo changes on failure
            System.err.println("CourseDAO: Error during save: " + e.getMessage());
        } finally {
            em.close(); // Crucial to prevent connection leaks
        }
    }

    /**
     * Uses JPQL to search for courses based on the trainer's name.
     */
    public List<CourseEntity> findByTrainer(String trainer) {
        System.out.println("CourseDAO: Searching courses for trainer: " + trainer);
        EntityManager em = factory.createEntityManager();
        try {
            // Note: JPQL refers to the Class (CourseEntity), not the table (course_details)
            String jpql = "SELECT c FROM CourseEntity c WHERE c.trainerName = :tName";
            TypedQuery<CourseEntity> query = em.createQuery(jpql, CourseEntity.class);
            query.setParameter("tName", trainer);

            List<CourseEntity> list = query.getResultList();
            System.out.println("CourseDAO: Found " + list.size() + " records.");
            return list;
        } finally {
            em.close();
        }
    }

    /**
     * Performs a bulk update on fees using a percentage increase.
     */
    public void updateAllFees(double percentage) {
        System.out.println("CourseDAO: Initiating bulk fee update by " + percentage + "%");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Bulk update via JPQL
            Query query = em.createQuery("UPDATE CourseEntity c SET c.fees = c.fees + (c.fees * :p / 100)");
            query.setParameter("p", percentage);

            int rowsUpdated = query.executeUpdate();
            tx.commit();
            System.out.println("CourseDAO: Bulk update complete. Total rows affected: " + rowsUpdated);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
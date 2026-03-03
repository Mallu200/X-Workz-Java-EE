package com.xworkz.property.dao;

import com.xworkz.property.entity.PropertyEntity;
import javax.persistence.*;

public class PropertyDAO {
    // Initializing the factory for the property-specific persistence unit
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("property-unit");

    /**
     * CREATE: Persists a new property listing.
     * Triggers @CreationTimestamp automatically.
     */
    public void create(PropertyEntity entity) {
        System.out.println("PropertyDAO: Initiating save for: " + entity.getTitle());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity); // Moves to Managed state
            tx.commit();
            System.out.println("PropertyDAO: Listing saved. Generated ID: " + entity.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("PropertyDAO: Save failed: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * READ: Retrieves a property by its primary key.
     */
    public PropertyEntity getById(int id) {
        System.out.println("PropertyDAO: Fetching property with ID: " + id);
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(PropertyEntity.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * UPDATE: Modifies the price of an existing property.
     */
    public void updatePrice(int id, double newPrice) {
        System.out.println("PropertyDAO: Updating price for ID " + id + " to ₹" + newPrice);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PropertyEntity entity = em.find(PropertyEntity.class, id);
            if(entity != null) {
                entity.setPrice(newPrice);
                em.merge(entity); // Synchronizes the updated price with MySQL
                System.out.println("PropertyDAO: Price update committed.");
            } else {
                System.out.println("PropertyDAO: Update failed. Property ID not found.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    /**
     * DELETE: Removes a property listing from the database.
     */
    public void remove(int id) {
        System.out.println("PropertyDAO: Removing property listing ID: " + id);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            PropertyEntity entity = em.find(PropertyEntity.class, id);
            if(entity != null) {
                em.remove(entity); // Moves to Removed state
                System.out.println("PropertyDAO: Record successfully deleted.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }
}
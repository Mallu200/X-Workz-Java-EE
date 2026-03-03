package com.xworkz.vehicle.dao;

import com.xworkz.vehicle.entity.VehicleEntity;
import javax.persistence.*;

public class VehicleDAO {
    // Creating the factory based on the persistence unit defined in persistence.xml
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory-unit");

    /**
     * CREATE: Persists a new vehicle record.
     */
    public void registerVehicle(VehicleEntity entity) {
        System.out.println("VehicleDAO: Registering vehicle - " + entity.getRegistrationNumber());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity); // Object moves to Managed state
            tx.commit();
            System.out.println("VehicleDAO: Registration successful for ID: " + entity.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("VehicleDAO: Failed to register vehicle: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * READ: Retrieves a vehicle by its Primary Key.
     */
    public VehicleEntity getVehicle(int id) {
        System.out.println("VehicleDAO: Fetching vehicle details for ID: " + id);
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(VehicleEntity.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * UPDATE: Updates the distance traveled for an existing vehicle.
     */
    public void updateDistance(int id, double newDistance) {
        System.out.println("VehicleDAO: Updating distance for ID: " + id + " to " + newDistance + " km");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Finding the entity ensures it is in the 'Managed' state before update
            VehicleEntity v = em.find(VehicleEntity.class, id);
            if (v != null) {
                v.setTotalDistanceTravelled(newDistance);
                em.merge(v); // Synchronizes the updated object with the database
                System.out.println("VehicleDAO: Distance update committed.");
            } else {
                System.out.println("VehicleDAO: Update failed. Vehicle with ID " + id + " not found.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    /**
     * DELETE: Removes a vehicle record from the database.
     */
    public void deleteVehicle(int id) {
        System.out.println("VehicleDAO: Deleting vehicle ID: " + id);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            VehicleEntity v = em.find(VehicleEntity.class, id);
            if (v != null) {
                em.remove(v); // Object moves to Removed state
                System.out.println("VehicleDAO: Record deleted successfully.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }
}
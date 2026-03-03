package com.xworkz.inventory.dao;

import com.xworkz.inventory.entity.MedicineEntity;
import javax.persistence.*;
import java.util.List;

public class MedicineDAO {
    // Factory initialized with the persistence unit defined in your persistence.xml
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory-unit");

    /**
     * CREATE: Adds a new medicine to the pharmacy inventory.
     */
    public void create(MedicineEntity med) {
        System.out.println("MedicineDAO: Initiating save for: " + med.getName());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(med); // Moves entity from Transient to Managed state
            tx.commit();
            System.out.println("MedicineDAO: Record saved with ID: " + med.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("MedicineDAO: Error during persist: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    /**
     * READ: Fetches a single medicine by its Primary Key.
     */
    public MedicineEntity read(int id) {
        System.out.println("MedicineDAO: Fetching record for ID: " + id);
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(MedicineEntity.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * UPDATE: Modifies the pricing of an existing medicine.
     */
    public void updatePrice(int id, double newPrice) {
        System.out.println("MedicineDAO: Updating price for ID " + id + " to ₹" + newPrice);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            MedicineEntity med = em.find(MedicineEntity.class, id);
            if (med != null) {
                med.setPrice(newPrice);
                em.merge(med); // Synchronizes the updated object with the MySQL table
                System.out.println("MedicineDAO: Price updated successfully.");
            } else {
                System.out.println("MedicineDAO: Update failed. Record not found.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    /**
     * DELETE: Removes a medicine record from the database.
     */
    public void delete(int id) {
        System.out.println("MedicineDAO: Deleting medicine record ID: " + id);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            MedicineEntity med = em.find(MedicineEntity.class, id);
            if (med != null) {
                em.remove(med); // Moves entity to the Removed state
                System.out.println("MedicineDAO: Record successfully deleted.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    /**
     * BULK READ: Retrieves the entire inventory list.
     */
    public List<MedicineEntity> getAll() {
        System.out.println("MedicineDAO: Fetching all inventory records...");
        EntityManager em = factory.createEntityManager();
        try {
            // JPQL query targeting the Entity class name
            return em.createQuery("from MedicineEntity", MedicineEntity.class).getResultList();
        } finally {
            em.close();
        }
    }
}
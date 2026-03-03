package com.xworkz.employee.dao;

import com.xworkz.employee.entity.EmployeeEntity;
import com.xworkz.employee.constant.JobRole;
import javax.persistence.*;

public class EmployeeDAO {
    // Initializing factory using the persistence unit from persistence.xml
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory-unit");

    /**
     * CREATE: Saves a new employee record.
     */
    public void save(EmployeeEntity entity) {
        System.out.println("EmployeeDAO: Initiating save for " + entity.getName());
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity); // Moves entity to MANAGED state
            tx.commit();
            System.out.println("EmployeeDAO: Employee saved with generated ID: " + entity.getId());
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.err.println("EmployeeDAO: Error during save operation: " + e.getMessage());
        } finally {
            em.close(); // Entity becomes DETACHED
        }
    }

    /**
     * READ: Retrieves an employee by primary key.
     */
    public EmployeeEntity getById(int id) {
        System.out.println("EmployeeDAO: Fetching record for ID: " + id);
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(EmployeeEntity.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * UPDATE: Changes the JobRole for a specific employee.
     */
    public void updateRole(int id, JobRole newRole) {
        System.out.println("EmployeeDAO: Updating Role for ID " + id + " to " + newRole);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            EmployeeEntity emp = em.find(EmployeeEntity.class, id);
            if (emp != null) {
                emp.setRole(newRole);
                em.merge(emp); // Synchronizes state with MySQL
                System.out.println("EmployeeDAO: Role successfully updated to " + emp.getRole());
            } else {
                System.out.println("EmployeeDAO: Update failed. Employee not found.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    /**
     * DELETE: Removes an employee record from the fleet/registry.
     */
    public void deleteEmployee(int id) {
        System.out.println("EmployeeDAO: Deleting employee with ID: " + id);
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            EmployeeEntity emp = em.find(EmployeeEntity.class, id);
            if (emp != null) {
                em.remove(emp); // Moves entity to REMOVED state
                System.out.println("EmployeeDAO: Record successfully removed from database.");
            }
            tx.commit();
        } finally {
            em.close();
        }
    }
}
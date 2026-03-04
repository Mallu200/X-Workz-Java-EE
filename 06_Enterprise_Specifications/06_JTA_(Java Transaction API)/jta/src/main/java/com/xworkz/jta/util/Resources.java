package com.xworkz.jta.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Producer class to manage the creation of JPA resources.
 * This allows other classes to simply @Inject the EntityManager.
 */
public class Resources {

    /**
     * Produces a managed EntityManager.
     * The container calls this method to satisfy @Inject requirements.
     */
    @Produces
    public EntityManager createEntityManager() {
        System.out.println("Resources: Producing new EntityManager from 'jta-unit'...");

        // Connects to your MySQL persistence unit defined in persistence.xml
        return Persistence
                .createEntityManagerFactory("jta-unit")
                .createEntityManager();
    }
}
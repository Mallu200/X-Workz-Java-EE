package com.xworkz.aqualink.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class Resources {

    // Create the factory once for the entire application life
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("aqualink-unit");

    @Produces
    @RequestScoped // One EntityManager per HTTP request/response cycle
    public EntityManager produceEntityManager() {
        System.out.println("Resources: Producing EntityManager for new Request.");
        return emf.createEntityManager();
    }

    /**
     * The CDI Container calls this automatically when the Request scope ends.
     * This prevents MySQL "Too many connections" errors.
     */
    public void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) {
            System.out.println("Resources: Closing EntityManager (Cleanup).");
            em.close();
        }
    }
}
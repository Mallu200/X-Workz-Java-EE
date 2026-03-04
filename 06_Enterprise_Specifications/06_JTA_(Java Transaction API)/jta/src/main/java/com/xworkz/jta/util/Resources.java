package com.xworkz.jta.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Resources {
    @Produces
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("jta-unit").createEntityManager();
    }
}
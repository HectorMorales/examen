package com.example.examen.manager;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;

public class EntityManagerProducer {

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init(){
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
    }

    @Produces
    @Default
    public EntityManagerFactory createEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Produces
    @Default
    @Dependent
    public EntityManager createEntityManager() {
        return this.entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}

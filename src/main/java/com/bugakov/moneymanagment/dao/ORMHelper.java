package com.bugakov.moneymanagment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ORMHelper {
    private EntityManagerFactory sf;
    private EntityManager em;

    private ORMHelper() {
    }

    private synchronized EntityManagerFactory getEntityManagerFactory() {
        if (sf == null) {
            sf = Persistence.createEntityManagerFactory("money");
        }
        return sf;
    }

    public EntityManager entityManager() {
        return em == null ? em = getEntityManagerFactory().createEntityManager() : em;
    }

}

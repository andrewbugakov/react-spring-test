package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.User;

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

    public static void main(String[] args) {
        ORMHelper ormHelper = new ORMHelper();
        EntityManager entityManager = ormHelper.entityManager();

    }

}

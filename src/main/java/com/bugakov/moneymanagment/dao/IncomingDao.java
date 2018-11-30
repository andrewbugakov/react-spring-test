package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.Incoming;

import javax.persistence.EntityManager;

public class IncomingDao extends AbstractDao<Incoming> {
    public IncomingDao(EntityManager entityManager) {
        super(entityManager, Incoming.class);
    }
}

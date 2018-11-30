package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.IncomingType;

import javax.persistence.EntityManager;

public class IncomingTypeDao extends AbstractDao<IncomingType> {
    public IncomingTypeDao(EntityManager entityManager) {
        super(entityManager, IncomingType.class);
    }
}

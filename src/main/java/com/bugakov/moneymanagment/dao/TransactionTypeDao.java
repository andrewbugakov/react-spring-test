package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.TransactionType;

import javax.persistence.EntityManager;

public class TransactionTypeDao extends AbstractDao<TransactionType> {
    public TransactionTypeDao(EntityManager entityManager) {
        super(entityManager, TransactionType.class);
    }
}

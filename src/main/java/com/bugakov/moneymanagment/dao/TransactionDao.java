package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.Transaction;

import javax.persistence.EntityManager;

public class TransactionDao extends AbstractDao<Transaction> {
    public TransactionDao(EntityManager entityManager) {
        super(entityManager, Transaction.class);
    }
}

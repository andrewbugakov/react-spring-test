package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.Currency;

import javax.persistence.EntityManager;

public class CurrencyDao extends AbstractDao<Currency> {
    public CurrencyDao(EntityManager entityManager) {
        super(entityManager, Currency.class);
    }
}

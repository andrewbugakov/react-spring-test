package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.CurrencyDao;
import com.bugakov.moneymanagment.dao.TransactionDao;
import com.bugakov.moneymanagment.model.Currency;
import com.bugakov.moneymanagment.model.Transaction;

import java.util.List;
import java.util.Optional;

public class TransactionService implements Service<Transaction, TransactionService.Dto> {
    private final TransactionDao dao;

    public TransactionService(TransactionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Transaction> findAll() {
        return dao.findAll();
    }

    @Override
    public Transaction find(Long id) {
        return dao.findById(id);
    }

    @Override
    public Transaction update(Long id, Dto dto) {
        Transaction transaction = dao.findById(id);
        dto.getName().ifPresent(transaction::setName);
        dao.update(transaction);
        return transaction;
    }

    @Override
    public Transaction create(Dto dto) {
        Transaction currency = new Transaction();
        dto.getName().ifPresent(currency::setName);
        dao.create(currency);
        return currency;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    static class Dto implements com.bugakov.moneymanagment.service.Dto {
        private Optional<String> name;

        public Optional<String> getName() {
            return name;
        }

        public void setName(Optional<String> name) {
            this.name = name;
        }
    }
}

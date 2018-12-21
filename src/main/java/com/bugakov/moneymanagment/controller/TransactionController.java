package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.TransactionDto;
import com.bugakov.moneymanagment.dao.CurrencyDao;
import com.bugakov.moneymanagment.dao.TransactionDao;
import com.bugakov.moneymanagment.dao.TransactionTypeDao;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController implements Controller<Transaction, TransactionDto> {
    private final TransactionDao dao;
    private final CurrencyDao currencyDao;
    private final TransactionTypeDao transactionTypeDao;
    private final UserDao userDao;

    public TransactionController(TransactionDao dao, CurrencyDao currencyDao, TransactionTypeDao transactionTypeDao, UserDao userDao) {
        this.dao = dao;
        this.currencyDao = currencyDao;
        this.transactionTypeDao = transactionTypeDao;
        this.userDao = userDao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Transaction> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Transaction> update(@PathVariable("id") Long id, @RequestBody TransactionDto dto) {
        Transaction transaction = dao.findById(id);
        applyDto(dto, transaction);
        dao.update(transaction);
        return ResponseEntity.ok(transaction);
    }

    private void applyDto(@RequestBody TransactionDto dto, Transaction transaction) {
        transaction.setName(dto.getName());
        transaction.setCurrency(currencyDao.findById(dto.getCurrency()));
        transaction.setPayDate(dto.getPayDate());
        transaction.setPrice(dto.getPrice());
        transaction.setTransactionType(transactionTypeDao.findById(dto.getTransactionType()));
        transaction.setUser(userDao.findById(dto.getUserId()));
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<Transaction> create(@RequestBody TransactionDto dto) {
        Transaction transaction = new Transaction();
        applyDto(dto, transaction);
        dao.create(transaction);
        return ResponseEntity.ok(transaction);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }

}

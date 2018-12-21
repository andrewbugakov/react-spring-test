package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.RegularTransactionDto;
import com.bugakov.moneymanagment.dao.RegularTransactionDao;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.RegularTransaction;
import com.bugakov.moneymanagment.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/regular")
public class RegularTransactionController implements Controller<RegularTransaction, RegularTransactionDto> {
    private final RegularTransactionDao dao;
    private final UserDao userDao;

    public RegularTransactionController(RegularTransactionDao dao, UserDao userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<RegularTransaction>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<RegularTransaction> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<RegularTransaction> update(@PathVariable("id") Long id, @RequestBody RegularTransactionDto dto) {
        RegularTransaction transaction = dao.findById(id);
        apply(dto, transaction);
        dao.update(transaction);
        return ResponseEntity.ok(transaction);
    }

    private void apply(RegularTransactionDto dto, RegularTransaction transaction) {
        transaction.setFinalDate(dto.getFinalDate());
        transaction.setPeriod(dto.getPeriod());
        transaction.setStartDate(dto.getStartDate());
        User byId = userDao.findById(dto.getUserId());
        transaction.setUser(byId);
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<RegularTransaction> create(@RequestBody RegularTransactionDto dto) {
        RegularTransaction transaction = new RegularTransaction();
        apply(dto,transaction);
        dao.create(transaction);
        return ResponseEntity.ok(transaction);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }
}

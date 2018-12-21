package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.IncomingDto;
import com.bugakov.moneymanagment.dao.CurrencyDao;
import com.bugakov.moneymanagment.dao.IncomingDao;
import com.bugakov.moneymanagment.dao.IncomingTypeDao;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.Incoming;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/incomings")
public class IncomingController implements Controller<Incoming, IncomingDto> {
    private final IncomingDao dao;
    private final IncomingTypeDao incomingTypeDao;
    private final CurrencyDao currencyDao;
    private final UserDao userDao;


    public IncomingController(IncomingDao dao, IncomingTypeDao incomingTypeDao, CurrencyDao currencyDao, UserDao userDao) {
        this.dao = dao;
        this.incomingTypeDao = incomingTypeDao;
        this.currencyDao = currencyDao;
        this.userDao = userDao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<Incoming>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Incoming> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Incoming> update(@PathVariable("id") Long id, @RequestBody IncomingDto dto) {
        Incoming incoming = dao.findById(id);
        applyDto(dto, incoming);
        dao.update(incoming);
        return ResponseEntity.ok(incoming);
    }

    private void applyDto(@RequestBody IncomingDto dto, Incoming incoming) {
        incoming.setName(incoming.getName());
        incoming.setCurrency(currencyDao.findById(dto.getCurrId()));
        incoming.setDate(new Date());
        incoming.setIncomingType(incomingTypeDao.findById(dto.getIncType()));
        incoming.setUser(userDao.findById(dto.getUserId()));
        incoming.setValue(dto.getValue());
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<Incoming> create(@RequestBody IncomingDto dto) {
        Incoming incoming = new Incoming();
        applyDto(dto, incoming);
        dao.create(incoming);
        return ResponseEntity.ok(incoming);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }

}

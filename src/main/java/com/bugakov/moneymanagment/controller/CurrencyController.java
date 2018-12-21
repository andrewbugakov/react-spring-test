package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.SimpleDto;
import com.bugakov.moneymanagment.dao.CurrencyDao;
import com.bugakov.moneymanagment.model.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController implements Controller<Currency, SimpleDto> {
    private final CurrencyDao dao;

    public CurrencyController(CurrencyDao dao) {
        this.dao = dao;
    }

    @Override
    @RequestMapping
    public @ResponseBody
    ResponseEntity<List<Currency>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Currency> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public @ResponseBody
    ResponseEntity<Currency> update(@PathVariable("id") Long id, @RequestBody SimpleDto dto) {
        Currency cur = dao.findById(id);
        cur.setName(dto.getName());
        dao.update(cur);
        return ResponseEntity.ok(cur);
    }

    @Override
    @RequestMapping(method = POST)
    public @ResponseBody
    ResponseEntity<Currency> create(@RequestBody SimpleDto dto) {
        //todo add Responce Entity if name will null
        Currency currency = new Currency();
        currency.setName(dto.getName());
        dao.create(currency);
        return ResponseEntity.ok(currency);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }
}

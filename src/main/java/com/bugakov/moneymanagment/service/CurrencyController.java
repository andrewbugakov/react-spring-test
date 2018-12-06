package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.CurrencyDao;
import com.bugakov.moneymanagment.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController implements Service<Currency, CurrencyController.Dto> {
    @Autowired
    private CurrencyDao dao;

    public void setDao(CurrencyDao dao) {
        this.dao = dao;
    }

    public CurrencyController() {
    }

    @Override
    @RequestMapping
    public @ResponseBody
    List<Currency> findAll() {
        return dao.findAll();
    }

    @Override
    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Currency find(@PathVariable("id") Long id) {
        return dao.findById(id);
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public @ResponseBody
    Currency update(@PathVariable("id") Long id, @RequestBody Dto dto) {
        Currency cur = dao.findById(id);
        cur.setName(dto.getName());
        dao.update(cur);
        return cur;
    }

    @Override
    @RequestMapping(method = POST)
    public @ResponseBody
    Currency create(@RequestBody Dto dto) {
        //todo add Responce Entity if name will null
        Currency currency = new Currency();
        currency.setName(dto.getName());
        dao.create(currency);
        return currency;
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }

    static class Dto implements com.bugakov.moneymanagment.service.Dto {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

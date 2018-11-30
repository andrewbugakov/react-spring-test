package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.RegularTransactionDao;
import com.bugakov.moneymanagment.dao.UserDao;
import com.bugakov.moneymanagment.model.Period;
import com.bugakov.moneymanagment.model.RegularTransaction;
import com.bugakov.moneymanagment.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RegularTransactionService implements Service<RegularTransaction, RegularTransactionService.Dto> {
    private final RegularTransactionDao dao;
    private final UserDao userDao;

    public RegularTransactionService(RegularTransactionDao dao, UserDao userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }

    @Override
    public List<RegularTransaction> findAll() {
        return dao.findAll();
    }

    @Override
    public RegularTransaction find(Long id) {
        return dao.findById(id);
    }

    @Override
    public RegularTransaction update(Long id, Dto dto) {
        RegularTransaction transaction = dao.findById(id);
        apply(dto, transaction);
        dao.update(transaction);
        return transaction;
    }

    private void apply(Dto dto, RegularTransaction transaction) {
        dto.getFinalDate().ifPresent(transaction::setFinalDate);
        dto.getPeriod().ifPresent(transaction::setPeriod);
        dto.getStartDate().ifPresent(transaction::setStartDate);
        dto.getUserId().ifPresent(e -> {
            User byId = userDao.findById(e);
            transaction.setUser(byId);
        });
    }

    @Override
    public RegularTransaction create(Dto dto) {
        RegularTransaction transaction = new RegularTransaction();
        apply(dto,transaction);
        dao.create(transaction);
        return transaction;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    static class Dto implements com.bugakov.moneymanagment.service.Dto {
        private Optional<Date> startDate;
        private Optional<Date> finalDate;
        private Optional<Long> userId;
        private Optional<Period> period;

        public Optional<Date> getStartDate() {
            return startDate;
        }

        public void setStartDate(Optional<Date> startDate) {
            this.startDate = startDate;
        }

        public Optional<Date> getFinalDate() {
            return finalDate;
        }

        public void setFinalDate(Optional<Date> finalDate) {
            this.finalDate = finalDate;
        }

        public Optional<Long> getUserId() {
            return userId;
        }

        public void setUserId(Optional<Long> userId) {
            this.userId = userId;
        }

        public Optional<Period> getPeriod() {
            return period;
        }

        public void setPeriod(Optional<Period> period) {
            this.period = period;
        }
    }
}

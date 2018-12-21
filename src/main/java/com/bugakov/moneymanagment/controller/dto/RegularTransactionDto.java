package com.bugakov.moneymanagment.controller.dto;

import com.bugakov.moneymanagment.model.Period;

import java.util.Date;

public class RegularTransactionDto implements Dto {
    private Date startDate;
    private Date finalDate;
    private Long userId;
    private Period period;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}

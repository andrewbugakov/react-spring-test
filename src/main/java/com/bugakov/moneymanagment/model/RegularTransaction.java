package com.bugakov.moneymanagment.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class RegularTransaction extends BaseIdEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date startDate;
    private String period;
    private Date nextTimeExecution;
    private Date finalDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period.name();
    }

    public Date getNextTimeExecution() {
        return nextTimeExecution;
    }

    public void setNextTimeExecution(Date nextTimeExecution) {
        this.nextTimeExecution = nextTimeExecution;
    }
}


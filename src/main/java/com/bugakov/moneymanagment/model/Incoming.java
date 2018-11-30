package com.bugakov.moneymanagment.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Incoming extends BaseIdEntity {
    private Date date;
    private BigDecimal value;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    private String name;
    @ManyToOne
    @JoinColumn(name = "incoming_type_id")
    private IncomingType incomingType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IncomingType getIncomingType() {
        return incomingType;
    }

    public void setIncomingType(IncomingType incomingType) {
        this.incomingType = incomingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}

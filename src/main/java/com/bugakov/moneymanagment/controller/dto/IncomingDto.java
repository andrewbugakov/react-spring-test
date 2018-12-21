package com.bugakov.moneymanagment.controller.dto;

import java.math.BigDecimal;

public class IncomingDto implements Dto {
    private String name;
    private Long currId;
    private BigDecimal value;
    private Long incType;
    private Long userId;
    public Long getCurrId() {
        return currId;
    }

    public void setCurrId(Long currId) {
        this.currId = currId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getIncType() {
        return incType;
    }

    public void setIncType(Long incType) {
        this.incType = incType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

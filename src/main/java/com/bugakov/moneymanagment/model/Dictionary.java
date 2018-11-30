package com.bugakov.moneymanagment.model;

import com.bugakov.moneymanagment.model.BaseIdEntity;

import javax.persistence.Column;

public abstract class Dictionary extends BaseIdEntity {
    @Column(name = "name", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

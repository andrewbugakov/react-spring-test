package com.bugakov.moneymanagment.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class IncomingType extends Dictionary {
    @Column(name = "name", nullable = false, insertable = true, unique = true, updatable = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.bugakov.moneymanagment.controller.dto;

public class SimpleDto implements Dto {
    private String name;

    public SimpleDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

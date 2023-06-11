package com.rentathing.models;

public enum ProductType {

    CAR("Personenauto"),
    TRUCK("Vrachtauto"),
    DRILL("Boormachine");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

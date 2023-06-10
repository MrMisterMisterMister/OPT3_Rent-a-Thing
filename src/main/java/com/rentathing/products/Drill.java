package com.rentathing.products;
public class Drill extends Product {

    private String brand;
    private String type;

    public Drill(String name, String brand, String type) {
        super(name);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public void detailScreen() {

    }
}

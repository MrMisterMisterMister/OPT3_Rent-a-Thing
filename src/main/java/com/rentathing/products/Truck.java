package com.rentathing.products;

public class Truck extends Product {

    private int loadCapacity;
    private int engineCapacity;

    public Truck(String name, int loadCapacity, int engineCapacity) {
        super(name);
        this.loadCapacity = loadCapacity;
        this.engineCapacity = engineCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public void detailScreen() {

    }
}

package com.rentathing.factories;

import com.rentathing.products.Truck;

public class TruckFactory implements ITruckFactory {
    @Override
    public Truck createTruck(String name, int loadCapacity, int engineCapacity) {
        return new Truck(name, loadCapacity, engineCapacity);
    }
}

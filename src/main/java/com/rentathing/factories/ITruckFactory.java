package com.rentathing.factories;

import com.rentathing.products.Truck;

public interface ITruckFactory {
    Truck createTruck(String name, int loadCapacity, int engineCapacity);
}

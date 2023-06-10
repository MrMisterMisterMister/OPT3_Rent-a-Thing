package com.rentathing.factories;

import com.rentathing.products.Car;

public class CarFactory implements ICarFactory {
    @Override
    public Car createCar(String name, String brand, int weight, int engineCapacity) {
        return new Car(name, brand, weight, engineCapacity);
    }
}

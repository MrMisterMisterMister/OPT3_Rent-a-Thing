package com.rentathing.pricecalculators;

import com.rentathing.models.Car;
import com.rentathing.models.Product;

public class CarRentalPriceCalculator extends RentalPriceCalculator {
    @Override
    public double calculateBasePrice(Product product) {
        return 50;
    }

    @Override
    public double calculateInsuranceCost(Product product) {
        Car car = (Car) product;
        return car.getEngineCapacity() * 0.01;
    }
}

package com.rentathing.pricecalculators;

import com.rentathing.products.Car;
import com.rentathing.products.Product;

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

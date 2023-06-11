package com.rentathing.pricecalculators;

import com.rentathing.models.Product;
import com.rentathing.models.Truck;

public class TruckRentalPriceCalculator extends RentalPriceCalculator {
    @Override
    public double calculateBasePrice(Product product) {
        Truck truck = (Truck) product;
        return truck.getLoadCapacity() * 0.10;
    }

    @Override
    public double calculateInsuranceCost(Product product) {
        Truck truck = (Truck) product;
        return truck.getEngineCapacity() * 0.01;
    }
}

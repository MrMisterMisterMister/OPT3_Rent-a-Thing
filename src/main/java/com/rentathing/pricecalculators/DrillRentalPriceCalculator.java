package com.rentathing.pricecalculators;

import com.rentathing.products.Product;

public class DrillRentalPriceCalculator extends RentalPriceCalculator {
    @Override
    public double calculateBasePrice(Product product) {
        return 5;
    }

    @Override
    public double calculateInsuranceCost(Product product) {
        return 1;
    }
}

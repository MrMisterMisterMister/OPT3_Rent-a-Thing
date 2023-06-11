package com.rentathing.factories;

import com.rentathing.models.Drill;
import com.rentathing.models.Product;

public class DrillFactory implements IProductFactory {
    @Override
    public Product createProduct(String productName, String... additionalParams) {
        String brand = additionalParams[0];
        String type = additionalParams[1];

        return new Drill(productName, brand, type);
    }
}

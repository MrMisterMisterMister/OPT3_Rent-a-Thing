package com.rentathing.factories;

import com.rentathing.models.Product;
import com.rentathing.models.Truck;
import com.rentathing.utils.parsing.ParsingUtils;

public class TruckFactory implements IProductFactory {
    @Override
    public Product createProduct(String productName, String... additionalParams) {
        int loadCapacity = ParsingUtils.parseStringToInt(additionalParams[0]);
        int engineCapacity = ParsingUtils.parseStringToInt(additionalParams[1]);

        return new Truck(productName, loadCapacity, engineCapacity);
    }
}

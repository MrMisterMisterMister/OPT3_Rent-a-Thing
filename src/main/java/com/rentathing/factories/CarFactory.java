package com.rentathing.factories;

import com.rentathing.models.Car;
import com.rentathing.models.Product;
import com.rentathing.utils.parsing.ParsingUtils;

public class CarFactory implements IProductFactory {
    @Override
    public Product createProduct(String productName, String... additionalParams) {
        String brand = additionalParams[0];
        int weight = ParsingUtils.parseStringToInt(additionalParams[1]);
        int engineCapacity = ParsingUtils.parseStringToInt(additionalParams[2]);

        return new Car(productName, brand, weight, engineCapacity);
    }
}

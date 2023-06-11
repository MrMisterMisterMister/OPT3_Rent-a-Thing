package com.rentathing.factories;

import com.rentathing.models.Product;

public interface IProductFactory {
    Product createProduct (String productName,String... additionalParams);
}

package com.rentathing.utils.mappings;

import com.rentathing.factories.CarFactory;
import com.rentathing.factories.DrillFactory;
import com.rentathing.factories.IProductFactory;
import com.rentathing.factories.TruckFactory;
import com.rentathing.models.ProductType;
import com.rentathing.ui.product.creation.CarCreationController;
import com.rentathing.ui.product.creation.DrillCreationController;
import com.rentathing.ui.product.creation.ProductCreationController;
import com.rentathing.ui.product.creation.TruckCreationController;

import java.util.HashMap;
import java.util.Map;

public class ProductMappings {
    private Map<ProductType, IProductFactory> productFactoryMappings;
    private Map<ProductType, String> windowMappings;
    private Map<ProductType, ProductCreationController> controllerMappings;

    public ProductMappings() {
        productFactoryMappings = new HashMap<>();
        windowMappings = new HashMap<>();
        controllerMappings = new HashMap<>();
        registerDefaultMappings();
    }

    private void registerDefaultMappings() {
        registerMapping(ProductType.TRUCK, new TruckFactory(), "/com/rentathing/fxml/product/creation/TruckCreationScreen.fxml", new TruckCreationController());
        registerMapping(ProductType.CAR, new CarFactory(), "/com/rentathing/fxml/product/creation/CarCreationScreen.fxml", new CarCreationController());
        registerMapping(ProductType.DRILL, new DrillFactory(), "/com/rentathing/fxml/product/creation/DrillCreationScreen.fxml", new DrillCreationController());
        // Add mappings for other default product types
    }

    public void registerMapping(ProductType productType, IProductFactory productFactory, String windowName, ProductCreationController productCreationController) {
        productFactoryMappings.put(productType, productFactory);
        windowMappings.put(productType, windowName);
        controllerMappings.put(productType, productCreationController);
    }

    public IProductFactory getFactory(ProductType productType) {
        return productFactoryMappings.get(productType);
    }

    public String getWindowName(ProductType productType) {
        return windowMappings.get(productType);
    }

    public ProductCreationController getController(ProductType productType) { return controllerMappings.get(productType); }
}

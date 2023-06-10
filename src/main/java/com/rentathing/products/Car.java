package com.rentathing.products;

import com.rentathing.pricecalculators.CarRentalPriceCalculator;
import com.rentathing.ui.product.CarDetailsController;

public class Car extends Product {

    private String brand;
    private int weight;
    private int engineCapacity;

    public Car(String name, String brand, int weight, int engineCapacity) {
        super(name);
        this.brand = brand;
        this.weight = weight;
        this.engineCapacity = engineCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public void detailScreen() {
        String fxml;
        fxml = "/com/rentathing/fxml/productdetailscreens/CarDetailsScreen.fxml";
        CarDetailsController controller = new CarDetailsController();
        controller.setProduct(this);
        controller.setRentalPriceCalculator(new CarRentalPriceCalculator());
        openProductDetailScreen(fxml, controller);
    }
}

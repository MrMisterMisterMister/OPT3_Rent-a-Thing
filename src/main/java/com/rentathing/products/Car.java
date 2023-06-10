package com.rentathing.products;

import com.rentathing.authentication.EmployeeSessionManager;
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
    public void detailScreen(EmployeeSessionManager sessionManager) {
        String fxml = "/com/rentathing/fxml/product/CarDetailsScreen.fxml";
        CarDetailsController controller = new CarDetailsController();
        controller.setProduct(this);
        controller.setRentalPriceCalculator(new CarRentalPriceCalculator());
        controller.setEmployeeSessionManager(sessionManager);
        openProductDetailScreen(fxml, controller);
    }
}

package com.rentathing.models;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.pricecalculators.TruckRentalPriceCalculator;
import com.rentathing.ui.product.details.TruckDetailsController;

public class Truck extends Product {

    private int loadCapacity;
    private int engineCapacity;

    public Truck(String name, int loadCapacity, int engineCapacity) {
        super(name);
        this.loadCapacity = loadCapacity;
        this.engineCapacity = engineCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void detailScreen(EmployeeSessionManager sessionManager) {
        String fxml = "/com/rentathing/fxml/product/details/TruckDetailsScreen.fxml";
        TruckDetailsController controller = new TruckDetailsController();
        controller.setProduct(this);
        controller.setRentalPriceCalculator(new TruckRentalPriceCalculator());
        controller.setEmployeeSessionManager(sessionManager);
        openProductDetailScreen(fxml, controller);
    }
}

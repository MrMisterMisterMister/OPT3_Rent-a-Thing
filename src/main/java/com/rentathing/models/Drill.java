package com.rentathing.models;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.pricecalculators.DrillRentalPriceCalculator;
import com.rentathing.ui.product.details.DrillDetailsController;

public class Drill extends Product {

    private String brand;
    private String type;

    public Drill(String name, String brand, String type) {
        super(name);
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public void detailScreen(EmployeeSessionManager sessionManager) {
        String fxml = "/com/rentathing/fxml/product/details/DrillDetailsScreen.fxml";
        DrillDetailsController controller = new DrillDetailsController();
        controller.setProduct(this);
        controller.setRentalPriceCalculator(new DrillRentalPriceCalculator());
        controller.setEmployeeSessionManager(sessionManager);
        openProductDetailScreen(fxml, controller);
    }
}

package com.rentathing.ui.product.details;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.models.Product;
import com.rentathing.models.Truck;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TruckDetailsController extends ProductDetailsController {

    @FXML
    private Label loadCapacityLabel;
    @FXML
    private Label engineCapacityLabel;

    private Truck truck;

    public void rentProduct() {
        super.rentProduct(truck);
    }

    public void returnProduct() {
        super.returnProduct(truck);
    }

    @Override
    public void setProduct(Product product) {
        this.truck = (Truck) product;
    }

    @Override
    public Product getProduct() { return truck; }

    @Override
    protected void initializeProductDetailsLabels() {
        productNameLabel.setText(truck.getName());
        loadCapacityLabel.setText(String.format("%dkg", truck.getLoadCapacity()));
        engineCapacityLabel.setText(String.format("%dcc", truck.getEngineCapacity()));
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
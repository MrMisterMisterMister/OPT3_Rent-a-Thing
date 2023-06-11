package com.rentathing.ui.product.details;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.models.Car;
import com.rentathing.models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CarDetailsController extends ProductDetailsController {

    @FXML
    private Label brandLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label engineCapacityLabel;

    private Car car;

    public void rentProduct() {
        super.rentProduct(car);
    }

    public void returnProduct() {
        super.returnProduct(car);
    }

    @Override
    public void setProduct(Product product) {
        this.car = (Car) product;
    }

    @Override
    public Product getProduct() {
        return car;
    }

    @Override
    protected void initializeProductDetailsLabels() {
        productNameLabel.setText(car.getName());
        brandLabel.setText(car.getBrand());
        weightLabel.setText(String.format("%dkg", (car.getWeight())));
        engineCapacityLabel.setText(String.format("%dcc", (car.getEngineCapacity())));
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
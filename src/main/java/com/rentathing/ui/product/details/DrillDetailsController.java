package com.rentathing.ui.product.details;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.models.Drill;
import com.rentathing.models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DrillDetailsController extends ProductDetailsController {

    @FXML
    private Label brandLabel;
    @FXML
    private Label typeLabel;

    private Drill drill;


    public void rentProduct() {
        super.rentProduct(drill);
    }

    public void returnProduct() {
        super.returnProduct(drill);
    }

    @Override
    public void setProduct(Product product) { this.drill = (Drill) product; }

    @Override
    public Product getProduct() { return drill; }

    @Override
    protected void initializeProductDetailsLabels() {
        productNameLabel.setText(drill.getName());
        brandLabel.setText(drill.getBrand());
        typeLabel.setText(drill.getType());
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

}
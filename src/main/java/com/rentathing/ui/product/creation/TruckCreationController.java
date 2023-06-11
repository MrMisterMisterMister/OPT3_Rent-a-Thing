package com.rentathing.ui.product.creation;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.IProductFactory;
import com.rentathing.factories.TruckFactory;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TruckCreationController extends ProductCreationController {

    @FXML
    private MFXTextField productNameTextField;
    @FXML
    private MFXTextField loadCapacityTextField;
    @FXML
    private MFXTextField engineCapacityTextField;
    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private IProductFactory productFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
        productFactory = new TruckFactory();
    }

    public void addProduct() {
        String productName = productNameTextField.getText();
        String loadCapacity = loadCapacityTextField.getText();
        String engineCapacity = engineCapacityTextField.getText();

        productFactory.createProduct(productName, loadCapacity, engineCapacity);
        System.out.println(productName + " toegevoegd.");
    }

    @Override
    public void setProductFactory(IProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}

package com.rentathing.ui.product.creation;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.CarFactory;
import com.rentathing.factories.IProductFactory;
import com.rentathing.models.Product;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CarCreationController extends ProductCreationController {

    @FXML
    private MFXTextField brandTextField;
    @FXML
    private MFXTextField weightTextField;
    @FXML
    private MFXTextField engineCapacityTextField;
    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private IProductFactory productFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
        productFactory = new CarFactory();
    }

    public void addProduct() {
        String productName = productNameTextField.getText();
        String brand = brandTextField.getText();
        String weight = weightTextField.getText();
        String engineCapacity = engineCapacityTextField.getText();

        Product newCar = productFactory.createProduct(productName, brand, weight, engineCapacity);
        System.out.println(productName + " toegevoegd.");
    }

    public void setProductFactory(IProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}

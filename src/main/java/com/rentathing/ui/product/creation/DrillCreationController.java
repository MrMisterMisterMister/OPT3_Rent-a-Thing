package com.rentathing.ui.product.creation;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.DrillFactory;
import com.rentathing.factories.IProductFactory;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DrillCreationController extends ProductCreationController {

    @FXML
    private MFXTextField productNameTextField;
    @FXML
    private MFXTextField brandTextField;
    @FXML
    private MFXTextField typeTextField;
    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private IProductFactory productFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
        productFactory = new DrillFactory();
    }

    public void addProduct() {
        String productName = productNameTextField.getText();
        String brand = brandTextField.getText();
        String type = typeTextField.getText();

        productFactory.createProduct(productName, brand, type);
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

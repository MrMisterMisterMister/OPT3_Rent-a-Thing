package com.rentathing.ui.product;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.CarFactory;
import com.rentathing.factories.ICarFactory;
import com.rentathing.utils.EmployeeSessionAware;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CarCreationController implements Initializable, EmployeeSessionAware {

    @FXML
    private MFXTextField productTextField;
    @FXML
    private MFXTextField brandTextField;
    @FXML
    private MFXTextField weightTextField;
    @FXML
    private MFXTextField engineCapacityTextField;
    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private ICarFactory carFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
        carFactory = new CarFactory();
    }

    public void addProduct() {
        String product = productTextField.getText();
        String brand = brandTextField.getText();
        int weight = isParsable(weightTextField.getText()) ? Integer.parseInt(weightTextField.getText()) : 0;
        int engineCapacity = isParsable(engineCapacityTextField.getText()) ? Integer.parseInt(engineCapacityTextField.getText()) : 0;

        carFactory.createCar(product, brand, weight, engineCapacity);
        System.out.println(product + " toegevoegd.");
    }

    public boolean isParsable(String text) {
        try {
            int parsable = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}

package com.rentathing.ui;

import com.rentathing.authentication.Employee;
import com.rentathing.authentication.EmployeeAuthenticationManager;
import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.utils.ScreenNavigator;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private MFXTextField usernameTextField;
    @FXML
    private MFXPasswordField passwordField;

    private EmployeeAuthenticationManager authenticationManager;
    private ScreenNavigator screenNavigator;

    public LoginController() {
        this.authenticationManager = EmployeeAuthenticationManager.getInstance();
        this.screenNavigator = ScreenNavigator.getInstance();
    }

    public void login() {
        Employee employee = authenticationManager.authenticate(usernameTextField.getText(), passwordField.getText());
        if (employee != null) {
            openMainMenuScreen(employee);
        } else {
            handleInvalidLogin();
        }
    }

    private void openMainMenuScreen(Employee employee) {
        EmployeeSessionManager sessionManager = new EmployeeSessionManager(employee);
        screenNavigator.openScreen("/com/rentathing/fxml/MainMenuScreen.fxml", MainMenuController.class, sessionManager);
    }

    private void handleInvalidLogin() {
        // Handle the invalid login
        System.out.println("Invalid login");
    }
}

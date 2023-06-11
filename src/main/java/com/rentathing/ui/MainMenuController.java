package com.rentathing.ui;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.utils.session.EmployeeSessionAware;
import com.rentathing.utils.screen.ScreenNavigator;
import com.rentathing.utils.mappings.ProductMappings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable, EmployeeSessionAware {

    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private ScreenNavigator screenNavigator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
        this.screenNavigator = ScreenNavigator.getInstance();
    }

    public void openOverviewScreen() {
        screenNavigator.openScreen("/com/rentathing/fxml/OverviewScreen.fxml", OverviewController.class, sessionManager, null, null);
    }

    public void openManagementScreen() {
        screenNavigator.openScreen("/com/rentathing/fxml/ManagementScreen.fxml", ManagementController.class, sessionManager, null, new ProductMappings());
    }

    public void logout() {
        // Perform logout functionality
    }

    private void handleException(IOException e) {
        e.printStackTrace();
    }


    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}

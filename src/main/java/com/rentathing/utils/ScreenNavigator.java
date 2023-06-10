package com.rentathing.utils;

import com.rentathing.authentication.EmployeeSessionManager;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ScreenNavigator {

    private static ScreenNavigator instance;

    private ScreenNavigator() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static ScreenNavigator getInstance() {
        if (instance == null) {
            instance = new ScreenNavigator();
        }
        return instance;
    }

    public <T> void openScreen(String fxml, Class<T> controllerClass, EmployeeSessionManager sessionManager) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            T controller = createController(controllerClass);

            if (controller instanceof EmployeeSessionAware) {
                ((EmployeeSessionAware) controller).setEmployeeSessionManager(sessionManager);
            }

            loader.setController(controller);
            WindowOpener.openWindow(fxml, loader.load());
        } catch (IOException e) {
            handleException(e);
        }
    }

    private <T> T createController(Class<T> controllerClass) {
        try {
            return controllerClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create controller: " + controllerClass.getName(), e);
        }
    }

    private void handleException(Exception e) {
        e.printStackTrace();
    }
}

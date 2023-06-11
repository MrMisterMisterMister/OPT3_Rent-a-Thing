package com.rentathing.utils.screen;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.IProductFactory;
import com.rentathing.ui.ManagementController;
import com.rentathing.ui.product.creation.ProductCreationController;
import com.rentathing.utils.session.EmployeeSessionAware;
import com.rentathing.utils.mappings.ProductMappings;
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

    public <T> void openScreen(String fxml, Class<T> controllerClass, EmployeeSessionManager sessionManager, IProductFactory productFactory, ProductMappings productMappings) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            T controller = createController(controllerClass);

            if (controller instanceof EmployeeSessionAware) {
                ((EmployeeSessionAware) controller).setEmployeeSessionManager(sessionManager);
            }
            if (controller instanceof ProductCreationController) {
                ((ProductCreationController) controller).setProductFactory(productFactory);
            }
            if (controller instanceof ManagementController) {
                ((ManagementController) controller).setProductMappings(productMappings);
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

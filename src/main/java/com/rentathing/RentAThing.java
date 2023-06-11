package com.rentathing;

import com.rentathing.models.Car;
import com.rentathing.models.Drill;
import com.rentathing.models.Truck;
import com.rentathing.utils.screen.WindowOpener;
import javafx.application.Application;
import javafx.stage.Stage;

public class RentAThing extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        WindowOpener.openWindow("/com/rentathing/fxml/LoginScreen.fxml", null);
        new Car("Ford Mustang Shelby GT500", "Ford", 1892, 5200);
        new Truck("Ford F-150 Raptor", 862, 3497);
        new Drill("DeWalt DCD771C2 20V MAX Cordless Drill/Driver Kit", "DeWalt", "Cordless Drill/Driver");
        stage.close();
    }
}

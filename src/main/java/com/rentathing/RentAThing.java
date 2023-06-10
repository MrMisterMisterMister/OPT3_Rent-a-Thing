package com.rentathing;

import com.rentathing.utils.WindowOpener;
import javafx.application.Application;
import javafx.stage.Stage;

public class RentAThing extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        WindowOpener.openWindow("/com/rentathing/fxml/LoginScreen.fxml", null);
        stage.close();
    }
}

module Rent.a.Thing {
    opens com.rentathing.products to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires java.sql; // in the future (maybe)

    opens com.rentathing to javafx.fxml;
    opens com.rentathing.ui to javafx.fxml;
    opens com.rentathing.ui.product to javafx.fxml;
    opens com.rentathing.utils to javafx.fxml;
    opens com.rentathing.utils.css to javafx.fxml;
    opens com.rentathing.rentalservice to javafx.fxml;

    exports com.rentathing;
    exports com.rentathing.ui;
    exports com.rentathing.ui.product;
    exports com.rentathing.utils;
    exports com.rentathing.utils.css;
    exports com.rentathing.rentalservice;
}
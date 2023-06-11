module Rent.a.Thing {
    opens com.rentathing.models to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires java.sql; // in the future (maybe)

    opens com.rentathing to javafx.fxml;
    opens com.rentathing.ui to javafx.fxml;
    opens com.rentathing.utils.css to javafx.fxml;
    opens com.rentathing.rentalservice to javafx.fxml;
    opens com.rentathing.ui.product.creation to javafx.fxml;
    opens com.rentathing.ui.product.details to javafx.fxml;
    opens com.rentathing.utils.mappings to javafx.fxml;
    opens com.rentathing.utils.screen to javafx.fxml;
    opens com.rentathing.utils.parsing to javafx.fxml;
    opens com.rentathing.utils.session to javafx.fxml;

    exports com.rentathing;
    exports com.rentathing.ui;
    exports com.rentathing.utils.css;
    exports com.rentathing.rentalservice;
    exports com.rentathing.ui.product.creation;
    exports com.rentathing.ui.product.details;
    exports com.rentathing.utils.mappings;
    exports com.rentathing.utils.screen;
    exports com.rentathing.utils.parsing;
    exports com.rentathing.utils.session;
}
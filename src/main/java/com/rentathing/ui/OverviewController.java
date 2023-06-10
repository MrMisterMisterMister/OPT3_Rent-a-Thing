package com.rentathing.ui;

import com.rentathing.rental.Rental;
import com.rentathing.observers.IObserver;
import com.rentathing.products.Car;
import com.rentathing.products.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OverviewController implements IObserver, Initializable {

    @FXML
    private TableView<Product> overviewTableView;
    @FXML
    private TableColumn<Product, String> numberColumn;
    @FXML
    private TableColumn<Product, String> productColumn;
    @FXML
    private TableColumn<Product, String> statusColumn;
    @FXML
    private Label employeeLabel;

    private ObservableList<Product> products;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        initializeSampleData();
        initializeTableView();
    }

    private void initializeTableColumns() {
        // Set up numberColumn
        numberColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue() == null ? null : overviewTableView.getItems().indexOf(cellData.getValue()) + 1;
            return rowIndex != null ? new SimpleStringProperty(rowIndex.toString()) : null;
        });

        // Set up productColumn
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productColumn.setCellFactory(column -> createClickableTableCell());

        // Set up stockColumn
        statusColumn.setCellValueFactory(cellData -> {
            Product product = cellData.getValue();
            String availability = product.isInStock() ? "Op voorraad" : "Verhuurd";
            return new SimpleStringProperty(availability);
        });
        statusColumn.setCellFactory(column -> createClickableTableCell());
    }

    private TableCell<Product, String> createClickableTableCell() {
        return new TableCell<Product, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }

            {
                setOnMouseClicked(event -> {
                    if (!isEmpty() && event.getClickCount() == 2) {
                        Product product = getTableView().getItems().get(getIndex());
                        product.detailScreen();
                    }
                });
                setCursor(Cursor.HAND);
            }
        };
    }

    private void initializeSampleData() {
        // TODO Product.getProducts() implementation
        products = FXCollections.observableArrayList();
        for (int i = 1; i < 3; i++) {
            Car car;
            if (i % 2 == 0) {
                car = new Car("Car " + i, "Brand " + i, 1000 * i, 2000 * i);
                car.setRental(new Rental("Employee " + i, "Customer " + i, LocalDate.now(), LocalDate.of(2023, 8, 15), true));
            } else {
                car = new Car("Car " + i, "Brand " + i, 1000 * i, 2000 * i);
            }
            car.registerObserver(this);
            products.add(car);
        }
    }

    private void initializeTableView() {
        overviewTableView.setItems(products);
        overviewTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        overviewTableView.setPlaceholder(new Label("Geen producten op voorraad."));
        // Set cell alignment
        numberColumn.setStyle("-fx-alignment: CENTER;");
        productColumn.setStyle("-fx-alignment: CENTER;");
        statusColumn.setStyle("-fx-alignment: CENTER;");
        // Set font size
        numberColumn.setStyle("-fx-font-size: 14px;");
        productColumn.setStyle("-fx-font-size: 14px;");
        statusColumn.setStyle("-fx-font-size: 14px;");
    }

    @Override
    public void update() {
        // Refresh the table view
        overviewTableView.refresh();
    }
}

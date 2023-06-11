package com.rentathing.ui;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.observers.IObserver;
import com.rentathing.models.Product;
import com.rentathing.utils.session.EmployeeSessionAware;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OverviewController implements IObserver, Initializable, EmployeeSessionAware {

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

    private final ObservableList<Product> productList = FXCollections.observableArrayList();
    private EmployeeSessionManager sessionManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableColumns();
        updateTableData();
        initializeTableView();

        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());
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
        return new TableCell<>() {
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
                        product.detailScreen(sessionManager);
                    }
                });
                setCursor(Cursor.HAND);
            }
        };
    }

    private void initializeTableView() {
        overviewTableView.setItems(productList);
        overviewTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        overviewTableView.setPlaceholder(new Label("Geen producten op voorraad."));
    }

    private void updateTableData() {
        List<Product> currentProducts = Product.getProducts();

        // Remove products that are no longer present
        productList.removeIf(product -> !currentProducts.contains(product));

        // Add new products to the list
        for (Product product : currentProducts) {
            if (!productList.contains(product)) {
                product.registerObserver(this);
                productList.add(product);
            }
        }

        // Check if productList is not empty and remove the placeholder
        if (!productList.isEmpty()) {
            overviewTableView.setPlaceholder(null);
        }
    }

    @Override
    public void update() {
        updateTableData();
        overviewTableView.refresh();
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
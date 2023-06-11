package com.rentathing.ui;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.factories.IProductFactory;
import com.rentathing.models.ProductType;
import com.rentathing.ui.product.creation.ProductCreationController;
import com.rentathing.utils.session.EmployeeSessionAware;
import com.rentathing.utils.screen.ScreenNavigator;
import com.rentathing.utils.mappings.ProductMappings;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ManagementController implements Initializable, EmployeeSessionAware {

    @FXML
    TableView<ProductType> managementTableView;
    @FXML
    TableColumn<ProductType, String> numberColumn;
    @FXML
    TableColumn<ProductType, String> typeColumn;
    @FXML
    private Label employeeLabel;

    private ScreenNavigator screenNavigator;
    private EmployeeSessionManager sessionManager;
    private List<ProductType> productTypeList = Arrays.asList(ProductType.values());
    private ProductMappings productMappings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        screenNavigator = ScreenNavigator.getInstance();
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());

        // Set the cell value factory for the numberColumn
        numberColumn.setCellValueFactory(cellData -> {
            Integer rowIndex = cellData.getValue() == null ? null : managementTableView.getItems().indexOf(cellData.getValue()) + 1;
            return rowIndex != null ? new SimpleStringProperty(rowIndex.toString()) : null;
        });

        // Set the cell value factory for the typeColumn
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        typeColumn.setCellFactory(column -> createClickableTableCell());

        // Add the productTypeList to the TableView
        managementTableView.getItems().addAll(productTypeList);
    }

    private TableCell<ProductType, String> createClickableTableCell() {
        return new TableCell<ProductType, String>() {
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
                    ProductType productType = getTableView().getItems().get(getIndex());
                    String windowName = productMappings.getWindowName(productType);
                    IProductFactory productFactory = productMappings.getFactory(productType);
                    ProductCreationController productCreationController = productMappings.getController(productType);
                        screenNavigator.openScreen(windowName, productCreationController.getClass(), sessionManager, productFactory, null);
                    }
                });
            setCursor(Cursor.HAND);
            }
        };
    }

    public void setProductMappings(ProductMappings productMappings) {
        this.productMappings = productMappings;
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
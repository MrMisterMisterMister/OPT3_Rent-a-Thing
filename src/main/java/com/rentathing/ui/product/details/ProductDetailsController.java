package com.rentathing.ui.product.details;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.models.Product;
import com.rentathing.pricecalculators.RentalPriceCalculator;
import com.rentathing.rentalservice.RentalService;
import com.rentathing.utils.session.EmployeeSessionAware;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public abstract class ProductDetailsController implements Initializable, EmployeeSessionAware {

    @FXML
    protected Label productNameLabel;
    @FXML
    protected MFXDatePicker startDatePicker;
    @FXML
    protected MFXDatePicker endDatePicker;
    @FXML
    protected MFXTextField rentedByTextField;
    @FXML
    protected MFXTextField rentedToTextField;
    @FXML
    protected CheckBox insuranceCheckBox;
    @FXML
    protected Label rentPriceLabel;
    @FXML
    protected Label insurancePriceLabel;
    @FXML
    protected Label totalPriceLabel;
    @FXML
    protected MFXButton rentButton;
    @FXML
    protected MFXButton returnButton;
    @FXML
    protected Label employeeLabel;

    protected EmployeeSessionManager sessionManager;
    protected RentalPriceCalculator rentalPriceCalculator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());

        if (getProduct().getRental() == null) {
            initializeRentMode();
        } else {
            initializeReturnMode(getProduct());
        }

        initializeProductDetailsLabels();

        // Add event handlers to the date picker controls and checkbox
        startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> updateUI(getProduct()));
        endDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> updateUI(getProduct()));
        insuranceCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> updateUI(getProduct()));
    }

    public abstract void setProduct(Product product);

    public abstract Product getProduct();

    public void setRentalPriceCalculator(RentalPriceCalculator rentalPriceCalculator) {
        this.rentalPriceCalculator = rentalPriceCalculator;
    }

    protected abstract void initializeProductDetailsLabels();

    public void rentProduct(Product product) {
        String rentedBy = rentedByTextField.getText();
        String rentedTo = rentedToTextField.getText();
        RentalService rentalService = createRental(rentedBy, rentedTo, startDatePicker.getValue(), endDatePicker.getValue(), insuranceCheckBox.isSelected());

        // Rent the car
        product.setRental(rentalService);
        System.out.println(product.getName() + " rented.");
        initializeReturnMode(product);
    }

    public void returnProduct(Product product) {
        product.returnProduct();
        System.out.println(product.getName() + " returned.");
        initializeRentMode();
    }

    public void updateUI(Product product) {
        // Get the selected start and end dates
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        boolean insured = insuranceCheckBox.isSelected();

        if (startDate != null && endDate != null) {
            // Perform the rental price calculation
            double rentalPrice = rentalPriceCalculator.calculateBasePrice(product);
            double insurancePrice = rentalPriceCalculator.calculateInsuranceCost(product);
            double totalPrice = rentalPriceCalculator.calculateRentalPrice(product, insured, startDate, endDate);

            // Update the UI labels with the calculated prices
            rentPriceLabel.setText(String.format("€%.2f/d", rentalPrice));
            insurancePriceLabel.setText(String.format("€%.2f/d", insurancePrice));
            totalPriceLabel.setText(String.format("€%.2f", totalPrice));
        }
    }

    protected void initializeRentMode() {
        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(null);
        insuranceCheckBox.setSelected(false);
        rentedByTextField.setText(sessionManager.getActiveEmployee().getFullName());
        rentedToTextField.setText("");

        rentPriceLabel.setText(String.format("€%.2f/d", 0.00));
        insurancePriceLabel.setText(String.format("€%.2f/d", 0.00));
        totalPriceLabel.setText(String.format("€%.2f", 0.00));

        // enable needed controls
        rentButton.setDisable(false);
        rentedByTextField.setEditable(true);
        rentedToTextField.setEditable(true);
        startDatePicker.setEditable(true);
        endDatePicker.setEditable(true);
        insuranceCheckBox.setDisable(false);

        // disable unneeded controls
        returnButton.setDisable(true);
        returnButton.setVisible(false);
    }

    protected void initializeReturnMode(Product product) {
        RentalService rentalService = product.getRental();

        startDatePicker.setValue(rentalService.getStartDate());
        endDatePicker.setValue(rentalService.getEndDate());
        insuranceCheckBox.setSelected(rentalService.isInsured());
        rentedByTextField.setText(rentalService.getRentedBy());
        rentedToTextField.setText(rentalService.getRentedTo());

        double rentalPrice = rentalPriceCalculator.calculateBasePrice(product);
        double insurancePrice = rentalPriceCalculator.calculateInsuranceCost(product);
        double totalPrice = rentalPriceCalculator.calculateRentalPrice(product, rentalService.isInsured(), rentalService.getStartDate(), rentalService.getEndDate());

        // Update the UI labels with the calculated prices
        rentPriceLabel.setText(String.format("€%.2f/d", rentalPrice));
        insurancePriceLabel.setText(String.format("€%.2f/d", insurancePrice));
        totalPriceLabel.setText(String.format("€%.2f", totalPrice));

        // disable unneeded controls
        rentButton.setDisable(true);
        rentedByTextField.setEditable(false);
        rentedToTextField.setEditable(false);
        startDatePicker.setEditable(false);
        endDatePicker.setEditable(false);
        insuranceCheckBox.setDisable(true);

        // enable needed controls
        returnButton.setDisable(false);
        returnButton.setVisible(true);
    }

    protected RentalService createRental(String rentedBy, String rentedTo, LocalDate startDate, LocalDate endDate, boolean insured) {
        return new RentalService(rentedBy, rentedTo, startDate, endDate, insured);
    }
}

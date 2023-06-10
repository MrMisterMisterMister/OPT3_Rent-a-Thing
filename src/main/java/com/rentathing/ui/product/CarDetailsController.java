package com.rentathing.ui.product;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.pricecalculators.CarRentalPriceCalculator;
import com.rentathing.pricecalculators.RentalPriceCalculator;
import com.rentathing.products.Car;
import com.rentathing.rentalservice.RentalService;
import com.rentathing.products.Product;
import com.rentathing.utils.EmployeeSessionAware;
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

public class CarDetailsController implements Initializable, EmployeeSessionAware {

    @FXML
    private Label productLabel;
    @FXML
    private Label brandLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label engineCapacityLabel;
    @FXML
    private MFXDatePicker startDatePicker;
    @FXML
    private MFXDatePicker endDatePicker;
    @FXML
    private MFXTextField rentedByTextField;
    @FXML
    private MFXTextField rentedToTextField;
    @FXML
    private CheckBox insuranceCheckBox;
    @FXML
    private Label rentPriceLabel;
    @FXML
    private Label insurancePriceLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private MFXButton rentButton;
    @FXML
    private MFXButton returnButton;
    @FXML
    private Label employeeLabel;

    private EmployeeSessionManager sessionManager;
    private RentalPriceCalculator rentalPriceCalculator;
    private Car car;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeLabel.setText(sessionManager.getActiveEmployee().getFullName());

        if (car.getRental() == null) {
            initializeRentMode();
        } else {
            initializeReturnMode();
        }

        initializeCarDetailsLabels();

        // Add event handlers to the date picker controls and checkbox
        startDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> updateUI());
        endDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> updateUI());
        insuranceCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> updateUI());
    }

    public void setProduct(Product product) {
        this.car = (Car) product;
    }

    public void setRentalPriceCalculator(RentalPriceCalculator rentalPriceCalculator) {
        this.rentalPriceCalculator = rentalPriceCalculator;
    }

    private void initializeCarDetailsLabels() {
        // Set up labels
        productLabel.setText(car.getName());
        brandLabel.setText(car.getBrand());
        weightLabel.setText(String.format("%dkg", (car.getWeight())));
        engineCapacityLabel.setText(String.format("%dcc", (car.getEngineCapacity())));
    }

    public void rentProduct() {
        // Get the necessary input values (rented by, rented to, insurance checkbox state)
        String rentedBy = rentedByTextField.getText();
        String rentedTo = rentedToTextField.getText();
        RentalService rentalService = createRental(rentedBy, rentedTo, startDatePicker.getValue(), endDatePicker.getValue(), insuranceCheckBox.isSelected());

        // Rent the car
        car.setRental(rentalService);
        System.out.println(car.getName() + " rented.");
        initializeReturnMode();
    }

    public void returnProduct() {
        car.returnProduct();
        System.out.println(car.getName() + " returned.");
        initializeRentMode();
    }

    public void updateUI() {
        // Get the selected start and end dates
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        boolean insured = insuranceCheckBox.isSelected();

        if (startDate != null && endDate != null) {
            // Perform the rental price calculation
            double rentalPrice = rentalPriceCalculator.calculateBasePrice(car);
            double insurancePrice = rentalPriceCalculator.calculateInsuranceCost(car);
            double totalPrice = rentalPriceCalculator.calculateRentalPrice(car, insured, startDate, endDate);

            // Update the UI labels with the calculated prices
            rentPriceLabel.setText(String.format("€%.2f/d", rentalPrice));
            insurancePriceLabel.setText(String.format("€%.2f/d", insurancePrice));
            totalPriceLabel.setText(String.format("€%.2f", totalPrice));
        }
    }

    private void initializeRentMode() {
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

    private void initializeReturnMode() {
        RentalService rentalService = car.getRental();

        startDatePicker.setValue(rentalService.getStartDate());
        endDatePicker.setValue(rentalService.getEndDate());
        insuranceCheckBox.setSelected(rentalService.isInsured());
        rentedByTextField.setText(rentalService.getRentedBy());
        rentedToTextField.setText(rentalService.getRentedTo());

        double rentalPrice = rentalPriceCalculator.calculateBasePrice(car);
        double insurancePrice = rentalPriceCalculator.calculateInsuranceCost(car);
        double totalPrice = rentalPriceCalculator.calculateRentalPrice(car, rentalService.isInsured(), rentalService.getStartDate(), rentalService.getEndDate());

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

    private RentalPriceCalculator createRentalPriceCalculator() {
        // Inject the RentalPriceCalculator implementation here (e.g., CarRentalPriceCalculator)
        return new CarRentalPriceCalculator();
    }

    private RentalService createRental(String rentedBy, String rentedTo, LocalDate startDate, LocalDate endDate, boolean insured) {
        // Create and return a new Rental instance
        return new RentalService(rentedBy, rentedTo, startDate, endDate, insured);
    }

    @Override
    public void setEmployeeSessionManager(EmployeeSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}


/*** Advice from ChatGPT that I MIGHT do:
 * Single Responsibility Principle (SRP): The CarDetailsController class seems to have multiple responsibilities. Consider
 * splitting it into smaller, more focused classes, such as a CarDetailsViewController, a CarRentalService, and a
 * RentalPriceCalculator to separate concerns and improve code maintainability.
 *
 * Encapsulation and Data Hiding: Consider encapsulating the fields of the CarDetailsController class and providing getter
 * and setter methods for accessing and modifying the fields, rather than accessing them directly. This helps encapsulate the
 * internal state of the class and promotes data hiding.
 *
 * Error Handling: Add appropriate error handling and validation to handle potential exceptions or invalid input values.
 * For example, when parsing user input or calculating prices, validate the input values and handle any errors gracefully.
 * ***/
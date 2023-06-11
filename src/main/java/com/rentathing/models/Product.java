package com.rentathing.models;

import com.rentathing.authentication.EmployeeSessionManager;
import com.rentathing.rentalservice.RentalService;
import com.rentathing.observers.Observable;
import com.rentathing.utils.screen.WindowOpener;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

public abstract class Product extends Observable {
    private String name;
    private boolean inStock;
    private RentalService rentalService;
    private static List<Product> productList = new ArrayList<>();

    public Product(String name) {
        this.name = name;
        this.inStock = true;
        productList.add(this);

        setChanged();
        notifyObservers();

        System.out.println(this + " created");
    }

    public String getName() {
        return name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public static List<Product> getProducts() {
        return productList;
    }

    public RentalService getRental() {
        return rentalService;
    }

    public void setRental(RentalService rentalService) {
        this.rentalService = rentalService;
        this.inStock = false;

        setChanged();
        notifyObservers();
    }

    public void returnProduct() {
        this.rentalService = null;
        this.inStock = true;

        setChanged();
        notifyObservers();
    }

    public abstract void detailScreen(EmployeeSessionManager sessionManager);

    public void openProductDetailScreen(String fxml, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            loader.setController(controller);
            WindowOpener.openWindow(fxml, loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

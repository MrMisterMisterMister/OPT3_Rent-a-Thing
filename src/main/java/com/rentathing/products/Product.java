package com.rentathing.products;

import com.rentathing.rental.Rental;
import com.rentathing.observers.Observable;
import com.rentathing.utils.WindowOpener;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

public abstract class Product extends Observable {
    private String name;
    private boolean inStock;
    private Rental rental;
    private static List<Product> productList = new ArrayList<>();

    public Product(String name) {
        this.name = name;
        this.inStock = true;
        productList.add(this);
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

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
        this.inStock = false;
        setChanged();
        notifyObservers();
    }

    public void returnProduct() {
        this.rental = null;
        this.inStock = true;
        setChanged();
        notifyObservers();
    }

    public abstract void detailScreen();

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

package com.rentathing.pricecalculators;

import com.rentathing.models.Product;

import java.time.LocalDate;

public abstract class RentalPriceCalculator {

    public final double calculateRentalPrice(Product product, boolean insure, LocalDate startDate, LocalDate endDate) {
        double basePrice = calculateBasePrice(product);
        double totalDays = calculateTotalRentDays(startDate, endDate);

        double rentalPrice = basePrice * totalDays;

        if (insure) {
            double insuranceCost = calculateInsuranceCost(product);
            rentalPrice += insuranceCost * totalDays;
        }

        return rentalPrice;
    }

    public abstract double calculateBasePrice(Product product);

    public abstract double calculateInsuranceCost(Product product);

    protected double calculateTotalRentDays(LocalDate startDate, LocalDate endDate) {
        // Adding +1 counts the first day as well e.g. May 1st to May 3rd will count 3 days instead of 2.
        return endDate.toEpochDay() - startDate.toEpochDay() + 1;
    }
}
package com.rentathing.pricecalculators;

import com.rentathing.products.Product;

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


    /***
    The example provided adheres to multiple SOLID principles. Here's how it relates to each principle:

    1. Single Responsibility Principle (SRP): Each class has a single responsibility. The `RentalPriceCalculator` class
        is responsible for calculating the rental price, while the `Car` and `Truck` classes represent specific types of products.
        This separation of concerns ensures that each class has a clear and focused responsibility.

    2. Open-Closed Principle (OCP): The example demonstrates the OCP by using inheritance and polymorphism.
        The `RentalPriceCalculator` class defines the template method for calculating rental prices, and new rental price
        calculators can be added by creating subclasses without modifying the existing code. This allows for easy extension
        without modifying the core implementation.

    3. Liskov Substitution Principle (LSP): The `CarRentalPriceCalculator` and `TruckRentalPriceCalculator` subclasses can
        be substituted for the base `RentalPriceCalculator` class without breaking the behavior of the program. This means
        that the subclasses conform to the contract defined by the base class.

    4. Interface Segregation Principle (ISP): In the provided example, there are no explicit interfaces, but the design
        follows the idea of separating the common behavior (`RentalPriceCalculator`) from the specific implementations
        (`CarRentalPriceCalculator` and `TruckRentalPriceCalculator`). This allows clients to depend on abstractions and
        not be affected by unnecessary methods they don't use.

    5. Dependency Inversion Principle (DIP): The example demonstrates the DIP by depending on abstractions rather than
        concrete implementations. The `RentalPriceCalculator` class depends on the abstract `Product` class, allowing for
        flexibility and decoupling between the calculator and specific product types.

        Overall, the example illustrates adherence to several SOLID principles, promoting modular, extensible, and maintainable code.
     ***/

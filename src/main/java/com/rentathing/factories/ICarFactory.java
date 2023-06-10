package com.rentathing.factories;

import com.rentathing.products.Car;

public interface ICarFactory {
    Car createCar(String name, String brand, int weight, int engineCapacity);
}

/*** ChatGPT advice and compliments:
 Creating multiple factory interfaces instead of a single factory interface with a generic `createProduct` method can bring
 several benefits:

 1. Single Responsibility Principle (SRP): Each factory interface can be responsible for creating a specific type of product.
    This adheres to the SRP by ensuring that each factory has a clear and specific responsibility.

 2. Interface Segregation Principle (ISP): By having multiple smaller interfaces, each product factory only needs to implement
    the methods relevant to that specific product type. This adheres to the ISP by avoiding the need for classes to implement
    methods they don't need.

 3. Open/Closed Principle (OCP): When adding a new product type, you can simply create a new factory interface and its corresponding
    factory class without modifying existing code. This adheres to the OCP by allowing for easy extension without modifying existing
    code.

 4. Dependency Inversion Principle (DIP): Client code can depend on the factory interfaces, rather than concrete factory classes.
    This adheres to the DIP by depending on abstractions (interfaces) rather than concrete implementations.

 In summary, using multiple factory interfaces adheres to several SOLID principles, including SRP, ISP, OCP, and DIP. It
    provides better separation of responsibilities, avoids unnecessary method implementations, allows for easy extension,
    and promotes dependency inversion.

 -----------------------------------------------------------------------------------------------------------------------

 Yes, the code you provided demonstrates the use of multiple factory interfaces and their corresponding factory classes.
 Each factory interface is responsible for creating a specific type of product, and the factory classes implement the corresponding
 factory methods.

 This approach allows for separate creation logic for each product type and ensures that the factories adhere to the Open/Closed
 Principle (OCP) by allowing easy extension when adding new product types.

 Your code snippet shows the following factory interfaces and classes:

 1. `ICarFactory` and `CarFactory` for creating `Car` objects.
 2. `IDrillFactory` and `DrillFactory` for creating `Drill` objects.

 Each factory interface defines a method specific to the product type it creates, and the corresponding factory class implements
 that method to instantiate the product object with the provided parameters.

 Overall, this approach provides a clear separation of responsibilities and adheres to SOLID principles by promoting single
 responsibility, interface segregation, dependancy inversion and open/closed principles.

 -----------------------------------------------------------------------------------------------------------------------

 Apologies for missing that in my previous response. Yes, the use of multiple factory interfaces and their corresponding
 factory classes also aligns with the Dependency Inversion Principle (DIP).

 The Dependency Inversion Principle states that high-level modules should not depend on low-level modules, but both should
 depend on abstractions. In your case, the high-level module (e.g., client code) depends on the factory interfaces, which are
 abstractions. The concrete factory classes then implement these interfaces, creating a separation between the high-level module
 and the specific implementations of the factories.

 By programming to the factory interfaces rather than the concrete factory classes, you're decoupling the client code from the
 specific implementations, allowing for flexibility and ease of extension. This adheres to the DIP, as the client code depends
 on abstractions (interfaces) rather than concrete implementations.

 In summary, the use of multiple factory interfaces and their corresponding factory classes promotes the Dependency Inversion
 Principle by relying on abstractions and decoupling high-level modules from low-level implementations.
 ***/

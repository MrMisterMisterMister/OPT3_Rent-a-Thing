package com.rentathing.authentication;

import java.util.ArrayList;

public class EmployeeAuthenticationManager {

    private static EmployeeAuthenticationManager instance;
    private ArrayList<Employee> employees;

    public static EmployeeAuthenticationManager getInstance() {
        if (instance == null) {
            instance = new EmployeeAuthenticationManager();
        }
        return instance;
    }

    public EmployeeAuthenticationManager() {
        // Initialize the list of employees, not safe, but...meh
        employees = new ArrayList<>();
        employees.add(new Employee("john", "password123", "John Smith"));
        employees.add(new Employee("jane", "password456", "Jane Doe"));
        employees.add(new Employee("admin", "admin", "admin"));
    }

    public Employee authenticate(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null; // Authentication failed
    }
}

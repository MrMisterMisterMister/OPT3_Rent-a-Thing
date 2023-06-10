package com.rentathing.authentication;

public class EmployeeSessionManager {
    private Employee activeEmployee;

    public EmployeeSessionManager(Employee employee) {
        this.activeEmployee = employee;
    }

    public Employee getActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(Employee employee) {
        this.activeEmployee = employee;
    }
}

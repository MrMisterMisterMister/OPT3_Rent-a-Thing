package com.rentathing.authentication;

import com.rentathing.models.Employee;

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

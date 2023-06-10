package com.rentathing.rentalservice;

import java.time.LocalDate;

public class RentalService {
    private String rentedTo;
    private String rentedBy;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean insured;

    public RentalService(String rentedTo, String rentedBy, LocalDate startDate, LocalDate endDate, boolean insured) {
        this.rentedTo = rentedTo;
        this.rentedBy = rentedBy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insured = insured;
    }

    public String getRentedTo() {
        return rentedTo;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isInsured() {
        return insured;
    }
}
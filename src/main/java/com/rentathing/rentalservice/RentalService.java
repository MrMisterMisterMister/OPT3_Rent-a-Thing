package com.rentathing.rentalservice;

import java.time.LocalDate;

public class RentalService {
    private String rentedBy;
    private String rentedTo;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean insured;

    public RentalService(String rentedBy, String rentedTo, LocalDate startDate, LocalDate endDate, boolean insured) {
        this.rentedBy = rentedBy;
        this.rentedTo = rentedTo;
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

package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset{
    // Properties
    private String makeModel;
    private int year;
    private int odometer;

    // Method


    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue(){
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;
        BigDecimal value = getOriginalCost();

        if (age <= 3){
            for (int i = 0; i < age; i++) {
                value = value.multiply(new BigDecimal("0.97"));
            }
        } else if (age <= 6) {
            for (int i = 0; i < age; i++) {
                value = value.multiply(new BigDecimal("0.94"));
            }
        } else if (age <= 10) {
            value = value.multiply(new BigDecimal("0.92"));
        } else {
            value = new BigDecimal("1000.00");
        }

        String makeModelLower = makeModel.toLowerCase();
        if (!(makeModelLower.contains("honda") || makeModelLower.contains("toyota"))
                && odometer > 100000){
            value = value.multiply(new BigDecimal("0.75"));
        }
        return value;

        // My first attempt
        /*BigDecimal cost = getOriginalCost();
        BigDecimal updatedCost = null;

        if (makeModel.equalsIgnoreCase("Honda") || makeModel.equalsIgnoreCase("Toyota")){
            System.out.println("Have a nice day");
        }
        else if (year >= 0 && year <= 3){
            if (odometer > 100_000){
                updatedCost = cost.multiply(new BigDecimal(".003").subtract(cost.multiply(new BigDecimal(.25))));
            } else {
                updatedCost = cost.multiply(new BigDecimal(.003));
            }
        } else if (year >= 4 && year <= 6) {
            if (odometer > 100_000) {
                updatedCost = cost.multiply(new BigDecimal(.006).subtract(cost.multiply(new BigDecimal(.25))));
            } else {
                updatedCost = cost.multiply(new BigDecimal(.006));
            }
        } else if (year >= 7 && year <= 10){
            if (odometer > 100_000){
                updatedCost = cost.multiply(new BigDecimal(.008).subtract(cost.multiply(new BigDecimal(.25))));
            } else {
                updatedCost = cost.multiply(new BigDecimal(.008));
            }
        } else if (year > 10) {
            updatedCost = BigDecimal.valueOf(1000.00);
        }
        return updatedCost;*/
    }
}

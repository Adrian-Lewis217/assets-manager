package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset{
    // Properties
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    // Method

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    @Override
    public BigDecimal getValue(){
        BigDecimal value = BigDecimal.ZERO;

        switch (condition) {
            case 1:
                value = new BigDecimal("180.00").multiply(BigDecimal.valueOf(squareFoot));
                break;
            case 2:
                value = new BigDecimal("130.00").multiply(BigDecimal.valueOf(squareFoot));
                break;
            case 3:
                value = new BigDecimal("90.00").multiply(BigDecimal.valueOf(squareFoot));
                break;
            case 4:
                value = new BigDecimal("80.00").multiply(BigDecimal.valueOf(squareFoot));
                break;
        }
        // My first attempt
        /*BigDecimal updatedCost = null;
        if (condition == 1){
            updatedCost = BigDecimal.valueOf(((180.00 * squareFoot) + (.25 * squareFoot)));
        }
        else if (condition == 2){
            updatedCost = BigDecimal.valueOf(((130.00 * squareFoot) + (.25 * squareFoot)));
        }
        else if (condition == 3){
            updatedCost = BigDecimal.valueOf(((90.00 * squareFoot) + (.25 * squareFoot)));
        }
        else if (condition == 4){
            updatedCost = BigDecimal.valueOf(((80.00 * squareFoot) + (.25 * squareFoot)));
        }*/
        return value;
    }
}

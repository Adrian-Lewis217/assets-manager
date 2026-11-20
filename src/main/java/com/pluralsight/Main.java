package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Asset> assets = new ArrayList<>();

        // House objects
        // String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize
        House house1 = new House("Main House","2014-02-17",new BigDecimal("175000.00"),"751 Potato St",2, 3000,7000);
        House house2 = new House("Vacation House","2020-06-02",new BigDecimal("425000.00"),"1235 Highlight rd",1, 4000,9000);

        // Vehicle objects
        // String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer
        // Four vehicles: Camaro,Silverado,Old Car,Project Car
        Vehicle vehicle1 = new Vehicle("Main Car","2024-03-25",new BigDecimal("40000.00"),"Chevrolet Camaro",2014,54000);
        Vehicle vehicle2 = new Vehicle("Second Car","2020-07-15",new BigDecimal("35000.00"),"Chevrolet Silverado",2017,105000);
        Vehicle vehicle3 = new Vehicle("Old Car","2019-05-01",new BigDecimal("18000.00"),"Honda Civic",2010,223000);
        Vehicle vehicle4 = new Vehicle("Project Car","2012-03-25",new BigDecimal("10000.00"),"Chevrolet Camaro",1969,150000);

        // add assets to List
        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);
        assets.add(vehicle3);
        assets.add(vehicle4);

        // Display assets' information
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%.2f%n", asset.getOriginalCost());

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Year: " + vehicle.getYear());
            }
        }
    }
}

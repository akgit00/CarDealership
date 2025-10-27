package com.pluralsight;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private static final String FILE_PATH = "inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            //dealership info
            String line = br.readLine();
            if (line == null) {
                System.out.println("Error: The file is empty.");
                return null;
            }

            String[] dealershipInfo = line.split("\\|");
            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            dealership = new Dealership(name, address, phone);

            //vehicle info
            String vehicleLine;
            while ((vehicleLine = br.readLine()) != null) {
                String[] data = vehicleLine.split("\\|");
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle();
                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        //will handle later
    }
}

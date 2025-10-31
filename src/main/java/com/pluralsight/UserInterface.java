package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        scanner = new Scanner(System.in);
    }

    public void display() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== DEALERSHIP MENU =====");
            System.out.println("1. List all vehicles");
            System.out.println("2. Search by price");
            System.out.println("3. Search by make & model");
            System.out.println("4. Search by year range");
            System.out.println("5. Search by color");
            System.out.println("6. Search by mileage");
            System.out.println("7. Search by type");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> displayVehicles(dealership.getAllVehicles());
                case "2" -> processGetByPriceRequest();
                case "3" -> processGetByMakeModelRequest();
                case "4" -> processGetByYearRequest();
                case "5" -> processGetByColorRequest();
                case "6" -> processGetByMileageRequest();
                case "7" -> processGetByVehicleTypeRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "0" -> running = false;
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    //helper methods
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processAddVehicleRequest() {
        System.out.println("Enter new vehicle details:");
        System.out.print("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        new DealershipFileManager().saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());
        Vehicle found = null;

        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                found = v;
                break;
            }
        }

        if (found != null) {
            dealership.removeVehicle(found);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
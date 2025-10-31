package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }


    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    //custom search methods
    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                matches.add(v);
            }
        }
        return matches;
    }
}
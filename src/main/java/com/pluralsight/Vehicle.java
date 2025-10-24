package com.pluralsight;

public class Vehicle {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    // getters and setters
    public int getVin() { return vin; }
    public void setVin(int vin) { this.vin = vin; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getOdometer() { return odometer; }
    public void setOdometer(int odometer) { this.odometer = odometer; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String toString() {
        return vin + " | " + year + " | " + make + " | " + model + " | " + vehicleType + " | " + color + " | " + odometer + " | $" + price;
    }
}

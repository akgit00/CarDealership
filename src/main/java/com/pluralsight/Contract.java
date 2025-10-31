package com.pluralsight;

public abstract class Contract {

    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    //getters
    public String getDate() { return date; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public Vehicle getVehicleSold() { return vehicleSold; }

    //these are abstract so each contract type computes differently
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();


    @Override
    public String toString() {
        return String.format("Date: %s | Customer: %s | Email: %s | Vehicle: %s",
                date, customerName, customerEmail, vehicleSold);
    }
}
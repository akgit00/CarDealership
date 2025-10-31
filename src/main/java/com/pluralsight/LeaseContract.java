package com.pluralsight;

public class LeaseContract extends Contract {

    // 50% of price
    private double expectedEndingValue;

    // 7% of price
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        double price = vehicleSold.getPrice();
        this.expectedEndingValue = price * 0.5;
        this.leaseFee = price * 0.07;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        totalPrice = expectedEndingValue + leaseFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double price = getTotalPrice();
        // 4% annual
        double rate = 0.04 / 12;
        int months = 36;

        monthlyPayment = (price * rate) / (1 - Math.pow(1 + rate, -months));
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return String.format("LEASE | %s | %s | %s | Total: $%.2f | Monthly: $%.2f",
                getDate(), getCustomerName(), getCustomerEmail(), getTotalPrice(), getMonthlyPayment());
    }
}
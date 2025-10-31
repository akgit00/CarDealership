package com.pluralsight;

public class SalesContract extends Contract {

    private double salesTaxAmount;      // 5%
    private double recordingFee = 100;  // Always $100
    private double processingFee;       // 295 or 495
    private boolean finance;            // true/false

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;

        double price = vehicleSold.getPrice();
        this.salesTaxAmount = price * 0.05;
        this.processingFee = (price < 10000) ? 295 : 495;
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        totalPrice = price + salesTaxAmount + recordingFee + processingFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0.0; // No financing

        double price = getTotalPrice();
        double rate;
        int months;

        if (price >= 10000) {
            rate = 0.0425 / 12; // 4.25% annual interest
            months = 48;
        } else {
            rate = 0.0525 / 12; // 5.25%
            months = 24;
        }

        monthlyPayment = (price * rate) / (1 - Math.pow(1 + rate, -months));
        return monthlyPayment;
    }

    public boolean isFinance() { return finance; }

    @Override
    public String toString() {
        return String.format("SALE | %s | %s | %s | Total: $%.2f | Monthly: $%.2f | Finance: %s",
                getDate(), getCustomerName(), getCustomerEmail(), getTotalPrice(), getMonthlyPayment(), finance ? "YES" : "NO");
    }
}

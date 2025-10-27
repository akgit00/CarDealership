package com.pluralsight;

public class TheApp {
    public static void main(String[] args) {
                DealershipFileManager fileManager = new DealershipFileManager();
                Dealership dealership = fileManager.getDealership();

                if (dealership != null) {
                    System.out.println("Dealership loaded: " + dealership.getName());
                    for (Vehicle v : dealership.getAllVehicles()) {
                        System.out.println(v);
                    }
                }
            }
        }

package org.example.foodsystem.user;

import org.example.foodsystem.order.Order;

public class Customer extends User {
private final String address;

    public Customer(String username, String password, String address) {
        super(username, password);
        this.address = address;
    }


    @Override
    public void viewDashboard() {
        System.out.println("Customer Dashboard:");
        System.out.println("1. View Order History");
        System.out.println("2. Update Address");
        // Add customer-specific actions
    }

    public void placeOrder(Order order) {
        //TODO set up placeOrder command
    }

    public String getAddress() {
        return address;
    }
}

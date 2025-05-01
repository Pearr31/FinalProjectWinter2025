package org.example.foodsystem.user;

import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.TakeoutOrder;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final String address;

    public Customer(String username, String password, String address) {
        super(username, password);
        this.address = address;
    }

    /**
     * displays customer specific dashboard
     */
    @Override
    public void viewDashboard() {
        System.out.println("Customer Dashboard:");
    }

    public Order placeOrder(String orderType, int orderId, List<MenuItem> items, Driver driver) {
        return null;   //implement place order logic
    }


    public String getAddress() {
        return address;
    }

}

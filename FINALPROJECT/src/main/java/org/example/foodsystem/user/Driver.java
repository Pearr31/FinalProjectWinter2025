package org.example.foodsystem.user;

import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessableOrder;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User implements ProcessableOrder {
    private List<DeliveryOrder> pendingOrders = new ArrayList<>();
    private String roleCode;
    private boolean authenticated;

    public Driver(String username, String password, String roleCode) {
        super(username, password);
        this.roleCode = roleCode;
        this.authenticated = false;
    }

    public boolean login(String username, String password, String roleCode) {
        //TODO implement login logic with specific roleCode's for driver and admin
        return false;
    }

    public void viewPendingOrders() {
        if (authenticated) {
            //TODO implement pending orders logic
        } else {
            System.out.println("access denied - driver not authenticated");
        }
    }

    public void acceptOrder(DeliveryOrder order) {
        if (authenticated) {
            //TODO implement logic to remove orders from pending orders and accept them
        } else {
            System.out.println("access denied - driver not authenticated");
        }
    }

    @Override
    public void processOrder(Order order) {
        //TODO implement driver's ability to set order status to delivering
    }

    @Override
    public void viewDashboard() {
        if (authenticated) {
            System.out.println("Driver dashboard");
        } else {
            System.out.println("access denied - driver not authenticated");
        }
    }

}

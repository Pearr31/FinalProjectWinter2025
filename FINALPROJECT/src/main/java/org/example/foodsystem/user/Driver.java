package org.example.foodsystem.user;

import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessOrder;

public class Driver extends User implements ProcessOrder {
    private final String driverId;

    public Driver(String username, String password, String driverId) {
        super(username, password);
        this.driverId = driverId;
    }

    @Override
    public void processOrder(Order order) {
        //Update order status (delivering/inprogress/cancelled)
    }

    @Override
    public void viewDashboard() {
        System.out.println("Driver Dashboard : Available Delivery Orders");
    }

    @Override
    public boolean validateOrder(Order order) {
        return false;
    }

    @Override
    public void processPayment(Order order) {

    }

    @Override
    public void updateOrderStatus(Order order, String status) {

    }
}

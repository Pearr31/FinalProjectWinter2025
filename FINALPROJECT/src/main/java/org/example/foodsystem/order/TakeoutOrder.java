package org.example.foodsystem.order;

import org.example.foodsystem.menu.MenuItem;

import java.time.LocalDateTime;
import java.util.List;

public class TakeoutOrder extends Order {
    private String pickupTime;

    public TakeoutOrder(int orderId, List<MenuItem> items) {
        super(orderId, items);
        this.pickupTime = null;
    }

    @Override
    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public void displayOrderDetails() {
        System.out.println("Takeout Order ID: " + orderId + " Total Price: " + totalPrice + " Pickup Time: " + pickupTime + " Status: " + status);
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
}

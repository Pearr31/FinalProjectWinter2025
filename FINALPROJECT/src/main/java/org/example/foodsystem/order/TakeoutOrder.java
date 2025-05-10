package org.example.foodsystem.order;

import org.example.foodsystem.menu.MenuItem;

import java.time.LocalDateTime;
import java.util.List;

public class TakeoutOrder extends Order {
    private String pickupTime;

    public TakeoutOrder(List<MenuItem> items) {
        super(items);
        this.pickupTime = "60 minutes from now";
        this.orderType = "Takeout";
    }

    /**
     * calculates total order price
     * @return order price
     */
    @Override
    public double calculateTotal() {
        return totalPrice = items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @Override
    public void displayOrderDetails() {
        System.out.println("Takeout Order ID: " + orderId + " Total Price: " + totalPrice + " Pickup Time: " + pickupTime + " Status: " + status);
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String time) {
        this.pickupTime = time;
    }
}

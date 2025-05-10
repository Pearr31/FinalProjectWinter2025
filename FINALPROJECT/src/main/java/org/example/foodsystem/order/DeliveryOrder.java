package org.example.foodsystem.order;

import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.user.Driver;

import java.util.List;

public class DeliveryOrder extends Order {
    private Driver driver;
    private String customerAddress;
    private static final double DELIVERY_FEE = 5.50;

    public DeliveryOrder(List<MenuItem> items, Driver driver, String customerAddress) {
        super(items);
        this.driver = driver;
        this.customerAddress = customerAddress;
        this.orderType = "Delivery";
    }

    /**
     * calculates total order price
     *
     * @return order price with delivery fee
     */
    @Override
    public double calculateTotal() {
        double subtotal = items.stream().mapToDouble(MenuItem::getPrice).sum();
        return totalPrice = subtotal + DELIVERY_FEE;
    }

    /**
     * displays delivery order details
     */
    @Override
    public void displayOrderDetails() {
        System.out.println("Delivery Order ID: " + orderId + " Total Price: " + totalPrice + " Driver: " + driver.getUsername() + " Address: " + customerAddress + " Status: " + status);

    }

    public String getAdress() {
        return customerAddress;
    }
}

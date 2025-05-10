package org.example.foodsystem.user;

import org.example.foodsystem.DiscountManager.DiscountManager;
import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.TakeoutOrder;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String address;
    private List<Order> orderHistory = new ArrayList<>();

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

    /**
     * allows customer to view menuItems
     *
     * @param menuItems different foods
     */
    public void viewMenu(List<MenuItem> menuItems) {
        System.out.println("Menu Items:");
        for (MenuItem item : menuItems) {
            System.out.println("- " + item.getName() + " (" + item.getGenre() + ") - $" + item.getPrice());
        }
    }

    /**
     * Places an order of the specified type and applies discount if valid.
     */
    public Order placeOrder(String orderType, List<MenuItem> items, Driver driver, String discountCode) {
        Order order;
        if (orderType.equalsIgnoreCase("Takeout")) {
            order = new TakeoutOrder(items);
        } else if (orderType.equalsIgnoreCase("Delivery") && driver != null) {
            order = new DeliveryOrder(items, driver, address);
        } else {
            throw new IllegalArgumentException("Invalid order type.");
        }
        if (DiscountManager.isValidCode(discountCode)) {
            order.applyDiscount(0.15);
        }
        return order;
    }

    /**
     * allows customer to view current order statuses
     */
    public void viewOrderStatuses() {
        if (orderHistory.isEmpty()) {
            System.out.println("You have no orders.");
        } else {
            for (Order order : orderHistory) {
                System.out.print("Order ID: " + order.getOrderId() +
                        " Type: " + order.getOrderType() +
                        " Status: " + order.getStatus() +
                        " Total: $" + order.getTotalPrice());

                if (order instanceof TakeoutOrder takeout) {
                    System.out.print(" Pickup Time: " + takeout.getPickupTime());
                }

                System.out.println();
            }
        }
    }

    public void addToOrderHistory(Order order) {
        orderHistory.add(order);
    }

    public String getAddress() {
        return address;
    }
}

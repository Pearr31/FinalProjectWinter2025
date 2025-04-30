package org.example.foodsystem.user;

import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessOrder;

public class Admin extends User {
    private final String adminId;

    public Admin(String username, String password, String adminId) {
        super(username, password);
        this.adminId = adminId;
    }

    public void addMenuItem(String name, double price, String genre) {

    }

    public void addDiscountCode(String code) {

    }

    @Override
    public void viewDashboard() {
        System.out.println("Admin Dashboard:");
        System.out.println("1. Manage Users");
        System.out.println("2. View System Reports");
        System.out.println("3. Add menu item");
        System.out.println("4. Add discount code");
        // Add admin-specific actions
    }


}

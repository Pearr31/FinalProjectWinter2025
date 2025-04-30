package org.example;

public class Admin extends User implements OrderProcessor {
    private String adminId;

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
        System.out.println("Admin Dashboard: Manage Menu, Discounts, Orders");
    }


    @Override
    public void processOrder(Order order) {
        //Mark order as processed
    }


}

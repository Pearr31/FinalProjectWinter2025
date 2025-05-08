package org.example.foodsystem;

import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.user.Admin;
import org.example.foodsystem.user.Customer;
import org.example.foodsystem.user.Driver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded users
        Admin admin = new Admin("admin", "admin123", "ADMIN01");
        Driver driver = new Driver("driver", "driver123", "DRIVER01");
        Customer customer = new Customer("cust", "cust123", "123 Maple St");

        // Login loop
        while (true) {
            System.out.println("\n--- Login Portal ---");
            System.out.print("Username: ");
            String uname = scanner.nextLine();
            System.out.print("Password: ");
            String pword = scanner.nextLine();

            if (admin.login(uname, pword, "ADMIN01")) {
                System.out.println("Welcome Admin!");
                admin.viewDashboard();
                System.out.print("Add discount code (or press Enter to skip): ");
                String newCode = scanner.nextLine();
                if (!newCode.isBlank()) admin.addDiscountCode(newCode);
                admin.logout();

            } else if (driver.login(uname, pword, "DRIVER01")) {
                System.out.println("Welcome Driver!");
                driver.viewDashboard();
                driver.logout();

            } else if (customer.login(uname, pword)) {
                System.out.println("Welcome Customer!");
                customer.viewDashboard();
                List<MenuItem> orderItems = List.of(
                        new MenuItem("Burger", "Fast Food", 10.0),
                        new MenuItem("Fries", "Fast Food", 3.0)
                );
                System.out.print("Enter order type (Takeout/Delivery): ");
                String type = scanner.nextLine();
                System.out.print("Enter discount code if any: ");
                String code = scanner.nextLine();
                Order placedOrder = customer.placeOrder(type, 1, orderItems, driver, code);
                placedOrder.displayOrderDetails();
                customer.logout();

            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

    }
}
package org.example.foodsystem;


import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.system.SystemManager;
import org.example.foodsystem.user.Admin;
import org.example.foodsystem.user.Customer;
import org.example.foodsystem.user.Driver;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        SystemManager systemManager = new SystemManager();
        systemManager.loadMenuItems("menu_items.csv");

        Admin admin = new Admin("admin", "admin123", "ADMIN01");
        Driver driver = new Driver("driver", "driver123", "DRIVER01");
        Customer customer = new Customer("cust", "cust123", "123 Maple St");

        while (true) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Username: ");
            String uname = scanner.nextLine().trim();
            System.out.print("Password: ");
            String pword = scanner.nextLine().trim();

            if (admin.login(uname, pword, "ADMIN01")) {
                System.out.println("Welcome Admin!");
                admin.viewDashboard();

                boolean loggedIn = true;
                while (loggedIn) {
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. Add Discount Code");
                    System.out.println("2. Edit Pickup Time for Takeout Order");
                    System.out.println("3. Logout");
                    System.out.print("Choose an option: ");
                    String option = scanner.nextLine().trim();

                    switch (option) {
                        case "1" -> {
                            System.out.print("Enter discount code to add: ");
                            String code = scanner.nextLine();
                            if (!code.isBlank()) {
                                admin.addDiscountCode(code);
                            }
                        }
                        case "2" -> {
                            for (Order o : systemManager.getAllOrders()) {
                                if (o instanceof org.example.foodsystem.order.TakeoutOrder) {
                                    System.out.println("Takeout Order ID: " + o.getOrderId() +
                                            " | Current Pickup Time: " +
                                            ((org.example.foodsystem.order.TakeoutOrder) o).getPickupTime());
                                }
                            }

                            System.out.print("Enter Order ID to edit: ");
                            int id = Integer.parseInt(scanner.nextLine());

                            System.out.print("Enter new pickup time (in minutes from now, max 75): ");
                            int newTime = Integer.parseInt(scanner.nextLine());

                            for (Order o : systemManager.getAllOrders()) {
                                if (o.getOrderId() == id) {
                                    admin.updatePickupTime(o, newTime);
                                    break;
                                }
                            }
                        }
                        case "3" -> {
                            admin.logout();
                            loggedIn = false;
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                }

            } else if (driver.login(uname, pword, "DRIVER01")) {
                System.out.println("Welcome Driver!");
                driver.viewDashboard();

                boolean loggedIn = true;
                while (loggedIn) {
                    System.out.println("\n--- Driver Menu ---");
                    System.out.println("1. View Pending Orders");
                    System.out.println("2. Deliver Next Order");
                    System.out.println("3. Logout");
                    System.out.print("Choose an option: ");
                    String option = scanner.nextLine();

                    switch (option) {
                        case "1" -> driver.viewPendingOrders();
                        case "2" -> {
                            System.out.print("Type 'drive' to deliver next order: ");
                            String action = scanner.nextLine().trim();
                            if (action.equalsIgnoreCase("drive")) {
                                driver.deliverNextOrder();
                            }
                        }
                        case "3" -> {
                            driver.logout();
                            loggedIn = false;
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                }

            } else if (customer.login(uname, pword)) {
                System.out.println("Welcome Customer!");

                boolean loggedIn = true;
                while (loggedIn) {
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println("1. View Menu");
                    System.out.println("2. Place Order");
                    System.out.println("3. View Order Statuses");
                    System.out.println("4. Logout");

                    System.out.print("Choose an option: ");
                    String option = scanner.nextLine();

                    switch (option) {
                        case "1" -> customer.viewMenu(systemManager.getMenuItems());

                        case "2" -> {
                            List<MenuItem> menu = systemManager.getMenuItems();
                            List<MenuItem> selectedItems = new ArrayList<>();

                            System.out.println("\nChoose items (comma-separated index):");
                            for (int i = 0; i < menu.size(); i++) {
                                System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + String.format("%.2f", menu.get(i).getPrice()));
                            }

                            String[] choices = scanner.nextLine().split(",");
                            for (String c : choices) {
                                try {
                                    int index = Integer.parseInt(c.trim()) - 1;
                                    if (index >= 0 && index < menu.size()) {
                                        selectedItems.add(menu.get(index));
                                    }
                                } catch (NumberFormatException ignored) {
                                }
                            }

                            if (selectedItems.isEmpty()) {
                                System.out.println("No valid items selected.");
                            } else {
                                String type = "";
                                while (true) {
                                        System.out.print("Takeout or Delivery: ");
                                        type = scanner.nextLine().trim();
                                        if(type.equalsIgnoreCase("Takeout") || type.equalsIgnoreCase("Delivery")) {
                                            break;
                                        } else {
                                            System.out.println("Invalid input. Please enter 'Takeout' or 'Delivery'.");
                                        }

                                }
                                System.out.print("Enter discount code (or leave empty): ");
                                String discount = scanner.nextLine();

                                Order order = customer.placeOrder(type, selectedItems, driver, discount);
                                customer.addToOrderHistory(order);
                                systemManager.recordOrder(order);
                                systemManager.saveOrderToHistory(order, "order_history.csv");

                                if (order instanceof DeliveryOrder dOrder) {
                                   driver.addToPendingOrders(dOrder);
                                }

                                order.displayOrderDetails();
                            }
                        }

                        case "3" -> customer.viewOrderStatuses();

                        case "4" -> {
                            customer.logout();
                            loggedIn = false;
                        }

                        default -> System.out.println("Invalid choice.");
                    }
                }

            } else {
                System.out.println("Invalid login. Try again.\n");
            }
        }
    }
}

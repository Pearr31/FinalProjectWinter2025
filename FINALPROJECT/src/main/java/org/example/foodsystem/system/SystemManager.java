package org.example.foodsystem.system;

import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.TakeoutOrder;
import org.example.foodsystem.user.User;
import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.user.Driver;


import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class SystemManager {
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();


    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


    public void loadMenuItems(String filePath) throws URISyntaxException {
        menuItems.clear();
        try {
            Scanner scanner = null;
            URL resource = getClass().getClassLoader().getResource(filePath);
            if (resource != null) {
                File file = new File(resource.toURI());
                scanner = new Scanner(file);
            } else {
                System.out.println("File not found!");
            }


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String genre = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    MenuItem item = new MenuItem(name, genre, price);
                    menuItems.add(item);
                }

            }
            System.out.println("Menu Items loaded from CSV:" + filePath);

        } catch (IOException e) {
            System.out.println("Error loading menu items");
        }

    }

    //prints to target csv instead of resources
    public void saveOrderToHistory(Order order, String filePath) {
        FileWriter fw = null;
        try {
            URL resource = getClass().getClassLoader().getResource(filePath);

            if (resource != null) {
                File file = new File(resource.toURI());
                fw = new FileWriter(file, true);
            } else {
                File file = new File(filePath);
                fw = new FileWriter(file, true);
            }

            for (MenuItem item : order.getItems()) {
                fw.write(order.getOrderId() + ",");
                fw.write(order.getOrderType() + ",");
                fw.write(order.getTotalPrice() + ",");
                fw.write(item.getName() + ",");
                fw.write(item.getGenre() + ",");
                fw.write(item.getPrice() + "\n");
            }

            if (order instanceof DeliveryOrder deliveryOrder) {
                fw.write(deliveryOrder.getOrderId() + ",Address:," + deliveryOrder.getAdress() + "\n");
            }

            if (order instanceof TakeoutOrder takeoutOrder) {
                fw.write(takeoutOrder.getOrderId() + ",Pickup Time:," + takeoutOrder.getPickupTime() + "\n");
            }

            System.out.println("Order saved successfully.");
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error saving order history: " + e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.err.println("Error closing FileWriter: " + e.getMessage());
                }
            }
        }
    }

    public void assignDeliveryToDriver(DeliveryOrder order, Driver driver) {
        driver.acceptOrder(order);
    }

    public void recordOrder(Order order) {
        allOrders.add(order);
    }

    public List<Order> getAllOrders() {
        return allOrders;
    }
}

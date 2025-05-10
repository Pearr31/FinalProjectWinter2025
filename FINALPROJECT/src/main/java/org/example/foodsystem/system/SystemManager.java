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
import java.util.*;
import java.util.List;

public class SystemManager {
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }



    public void loadMenuItems(String filePath) {
        menuItems.clear();
        try (Scanner scanner = new Scanner(new File(filePath))) {
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

    public void saveOrderToHistory(Order order, String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            //for (Order order : orders) {
                for (MenuItem item : order.getItems()) {
                    fw.write(order.getOrderId() + ",");
                    fw.write(order.getOrderType() + ",");
                    fw.write(order.getStatus() + ",");
                    fw.write(order.getTotalPrice() + ",");
                    fw.write(item.getName() + ",");
                    fw.write(item.getGenre() + ",");
                    fw.write(item.getPrice() + "\n");
                }

                if (order instanceof DeliveryOrder deliveryOrder) {
                    fw.write("Address:," + deliveryOrder.getAdress() + "\n");
                }

                if (order instanceof TakeoutOrder takeoutOrder) {
                    fw.write("Pickup Time:," + takeoutOrder.getPickupTime() + "\n");
                }
                fw.write("________________________________\n");
            //}
            System.out.println("Order saved successfuly");
        } catch (IOException e) {
            System.out.println("Error saving order history");
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

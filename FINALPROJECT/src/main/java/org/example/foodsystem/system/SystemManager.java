package org.example.foodsystem.system;

import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.user.User;


import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class SystemManager {
    private List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void loadMenuItems(String filePath) {
        //TODO filereader reads inputted csv file to upload menu items

    }

    public void saveOrderHistory(List<Order> orders, String filePath) {
        //TODO filewriter writes down all orders processed or selected orders
    }


}

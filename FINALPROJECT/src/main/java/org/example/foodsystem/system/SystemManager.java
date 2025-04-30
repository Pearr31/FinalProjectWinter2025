package org.example.foodsystem.system;

import org.example.foodsystem.menu.MenuItem;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.user.User;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class SystemManager {
    private User currentUser;
    private final Map<String, User> userDatabase = new HashMap<>();

    public void loadMenu(String fileName) {
        File file = new File();

        //TODO filereader reads inputted csv file for menu

    }

    public void saveOrder(String fileName, Order order){
    //TODO filewriter writes down all orders processed or selected orders
    }

    public void saveDiscountsToFile(String fileName) {
        //TODO filewriter writes down all discount codes??

    }

    public User login(String username, String password) {
        // Validate credentials against a User database/file
        // Return User object with role (Admin, Driver, etc.)
    }

    public void logout(User user) {

    }
}

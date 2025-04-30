package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class OrderManager {
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<String> discountCodes = new ArrayList<>();

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
}

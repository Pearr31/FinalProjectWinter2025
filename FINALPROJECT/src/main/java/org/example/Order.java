package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected int orderId;
    protected List<MenuItem> items;
    protected double totalPrice;


    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<MenuItem>();
    }

    public abstract double calculateTotal();



}

package org.example.foodsystem.order;

import org.example.foodsystem.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Order {
    private static int nextId= 1;
    protected int orderId;
    protected List<MenuItem> items;
    protected double totalPrice;
    protected String status;
    protected String orderType;


    public abstract double calculateTotal();

    public abstract void displayOrderDetails();

    public void applyDiscount(double percentOff) {
    this.totalPrice = totalPrice - totalPrice * percentOff;
    }


    public Order(List<MenuItem> items) {
        this.orderId = nextId++;
        this.items = items;
        this.totalPrice = calculateTotal();
        this.status = "Pending";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(items, order.items) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, items, totalPrice, status);
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }
}

package org.example.foodsystem.order;

public interface ProcessOrder {
    boolean validateOrder(Order order);
    void processPayment(Order order);
    void updateOrderStatus(Order order, String status);
}

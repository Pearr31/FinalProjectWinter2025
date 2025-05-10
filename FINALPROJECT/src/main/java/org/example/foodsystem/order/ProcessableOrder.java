package org.example.foodsystem.order;

/**
 * Processes the given customer order.
 * The behavior of processing may vary depending on the implementing class:
 * Drivers typically mark the order as 'Delivered'
 * Admins may mark it as 'Processed' or 'Ready for Pickup'
 */
public interface ProcessableOrder {
    public void processOrder(Order order);
}

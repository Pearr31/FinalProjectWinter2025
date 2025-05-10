package org.example.foodsystem.user;

import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessableOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Driver extends User implements ProcessableOrder {
    private Queue<DeliveryOrder> pendingOrders = new LinkedList<>();
    private String roleCode;
    private boolean authenticated;

    public Driver(String username, String password, String roleCode) {
        super(username, password);
        this.roleCode = roleCode;
        this.authenticated = false; //check if necessary
    }

    /**
     * allows user to login to system
     * @param username inputted by user
     * @param password inputted by user
     * @param roleCode only for driver and admin classes
     * @return boolean value on if logged in or not
     */
    public boolean login(String username, String password, String roleCode) {
        authenticated = super.login(username, password) && (this.roleCode != null && this.roleCode.equals(roleCode));
        return authenticated;
    }

    /**
     * terminates users actions in system
     */
    public void logout() {
        authenticated = false;
        System.out.println(username + "has logged out of FoodDeliverySystem.");
    }

    /**
     * shows all active orders that are pending
     */
    public void viewPendingOrders() {
        if (authenticated) {
            if (pendingOrders.isEmpty()) {
                System.out.println("No pending orders.");
            } else {
                for (DeliveryOrder order : pendingOrders) {
                    order.displayOrderDetails();
                }
            }
        } else {
            System.out.println("Access denied: Driver not authenticated.");
        }
    }

    /**
     * accepts a pending order driver can then deliver
     * @param order placed order
     */
    public void acceptOrder(DeliveryOrder order) {
        if (authenticated) {
            pendingOrders.offer(order);
            order.setStatus("Out for Delivery");
            System.out.println("Order " + order.getOrderId() + " is now out for delivery.");
        } else {
            System.out.println("Access denied: Driver not authenticated.");
        }
    }

    /**
     * delivers the accepted order
     */
    public void deliverNextOrder() {
        if (authenticated) {
            DeliveryOrder next = pendingOrders.poll();
            if (next != null) {
                processOrder(next);
            } else {
                System.out.println("No deliveries to process.");
            }
        } else {
            System.out.println("Access denied.");
        }
    }

    /**
     * adds placed delivery orders to pending orders
     * @param order order placed by customer
     */
    public void addToPendingOrders(DeliveryOrder order) {
        pendingOrders.offer(order);
    }

    /**
     * processes the order
     * @param order placed by customer
     */
    @Override
    public void processOrder(Order order) {
        if (authenticated) {
            order.setStatus("Delivered");
            System.out.println("Order " + order.getOrderId() + " has been delivered to address: " + ((DeliveryOrder) order).getAdress());
        } else {
            System.out.println("Access denied: Driver not authenticated.");
        }
    }

    /**
     * allows driver to view user specific dashboard
     */
    @Override
    public void viewDashboard() {
        if (authenticated) {
            System.out.println("Driver dashboard");
        } else {
            System.out.println("Access denied: driver not authenticated.");
        }
    }

}

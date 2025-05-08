package org.example.foodsystem.user;

import org.example.foodsystem.order.DeliveryOrder;
import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessableOrder;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User implements ProcessableOrder {
    private List<DeliveryOrder> pendingOrders = new ArrayList<>();
    private String roleCode;
    private boolean authenticated;

    public Driver(String username, String password, String roleCode) {
        super(username, password);
        this.roleCode = roleCode;
        this.authenticated = false;
    }

    public boolean login(String username, String password, String roleCode) {
        authenticated = super.login(username, password) && (this.roleCode != null && this.roleCode.equals(roleCode));
        return authenticated;
    }

    public void logout() {
        authenticated = false;
        System.out.println(username + "has logged out of FoodDeliverySystem");
    }

    public void viewPendingOrders() {
        if (authenticated) {
            for (DeliveryOrder order : pendingOrders) {
                order.displayOrderDetails();
            }
        } else {
            System.out.println("access denied - driver not authenticated");
        }
    }

    public void acceptOrder(DeliveryOrder order) {
        if (authenticated) {
            pendingOrders.remove(order);
            order.setStatus("Out for Delivery");
            System.out.println("Order " + order.getOrderId() + " is now out for delivery.");
        } else {
            System.out.println("Access denied: Driver not authenticated.");
        }
    }

    @Override
    public void processOrder(Order order) {
        if (authenticated) {
            order.setStatus("Delivered");
            System.out.println("Order " + order.getOrderId() + " has been delivered to address: " + ((DeliveryOrder) order).getAddress());
        } else {
            System.out.println("Access denied: Driver not authenticated.");
        }
    }

    @Override
    public void viewDashboard() {
        if (authenticated) {
            System.out.println("Driver dashboard");
        } else {
            System.out.println("access denied - driver not authenticated");
        }
    }

}

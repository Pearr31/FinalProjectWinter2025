package org.example.foodsystem.user;

import org.example.foodsystem.order.Order;
import org.example.foodsystem.order.ProcessableOrder;
import org.example.foodsystem.order.TakeoutOrder;

public class Admin extends User implements ProcessableOrder {
    private final String roleCode;
    private boolean authenticated;

    public Admin(String username, String password, String roleCode) {
        super(username, password);
        this.roleCode = roleCode;
        this.authenticated = false;
    }

    /**
     * authenticates admin with role code
     * @param roleCode admins have role code only
     */
    public boolean login(String username, String password, String roleCode) {
        //TODO implement login logic with specific roleCode's for driver and admin
        return false;
    }

    public void assignPickupTime(TakeoutOrder order, String pickupTime) {
        if (authenticated) {
            order.setPickupTime(pickupTime);
        } else {
            System.out.println("access denied - admin not authenticated");
        }
    }

    /**
     * sets discount code for customers to use
     * @param code
     */
    public void addDiscountCode(String code){
        //TODO implement discount code logic
    }

    /**
     * set order status
     * @param order
     */
    @Override
    public void processOrder(Order order) {
        //TODO add admin's ability to set order status
    }


    @Override
    public void viewDashboard() {
        if (authenticated) {
            System.out.println("admin dashboard");
        } else {
            System.out.println("access denied - admin not authenticated");
        }
    }


}

package org.example.foodsystem.user;

import org.example.foodsystem.DiscountManager.DiscountManager;
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
        authenticated = super.login(username,password) && (this.roleCode!= null && this.roleCode.equals(roleCode));
        return authenticated;
    }

    public void logout() {
        authenticated = false;
        System.out.println(username + "has logged out of FoodDeliverySystem");
    }

    public void assignPickupTime(TakeoutOrder order, String pickupTime) {
        if (authenticated) {
            order.setPickupTime(pickupTime);
            order.setStatus("ready for pick up");
        } else {
            System.out.println("access denied: admin not authenticated");
        }
    }

    /**
     * sets discount code for customers to use
     * @param code
     */
    public void addDiscountCode(String code){
        if (authenticated) {
            DiscountManager.addCode(code);
            System.out.println("Discount code added: " + code);
        } else {
            System.out.println("Access denied: admin not authenticated");
        }
    }

    /**
     * set order status
     * @param order
     */
    @Override
    public void processOrder(Order order) {
        if(authenticated) {
            order.setStatus("Processed by admin");
            System.out.println("processing order: " + order.getOrderId());
        } else {
            System.out.println("Access denied: admin not authenticated");
        }
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

package org.example;

public class Driver extends User implements OrderProcessor{
    private String driverId;

    public Driver(String username, String password, String driverId) {
        super(username, password);
        this.driverId = driverId;
    }

    @Override
    public void processOrder(Order order) {
        //Update order status (delivering/inprogress/cancelled)
    }

    @Override
    public void viewDashboard() {
        System.out.println("Driver Dashboard : Available Delivery Orders");
    }
}

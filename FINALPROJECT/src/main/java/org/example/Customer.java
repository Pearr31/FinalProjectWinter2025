package org.example;

public class Customer extends User{
private String address;

    public Customer(String username, String password, String address) {
        super(username, password);
        this.address = address;
    }


    @Override
    public void viewDashboard() {
        System.out.println("Customer DashBoard: OrderHistory");
    }

    public void placeOrder(Order order) {
        //TODO
    }
}

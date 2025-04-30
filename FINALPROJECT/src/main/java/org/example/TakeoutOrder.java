package org.example;

public class TakeoutOrder extends Order{
    private String pickupTime;

    public TakeoutOrder(int orderId, String pickupTime) {
        super(orderId);
        this.pickupTime = pickupTime;
    }

    @Override
    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }
}

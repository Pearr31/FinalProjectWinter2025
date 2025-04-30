package org.example;

public class DeliveryOrder extends Order{
    private String deliveryAddress;
    private double deliveryFee;

    public DeliveryOrder(int orderId, String deliveryAddress, double deliveryFee) {
        super(orderId);
        this.deliveryAddress = deliveryAddress;
        this.deliveryFee = deliveryFee;
    }


    @Override
    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum() + deliveryFee;
    }
}

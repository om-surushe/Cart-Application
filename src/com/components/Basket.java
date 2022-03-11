package com.components;

public class Basket {

    private List<item> order; 
    private int OrderCost;
    private boolean isPaid;
    private String orderID;

    public Basket(String orderID) {
        this.orderID = orderID;
    }

    public Basket(String orderID, List<item> order) {
        this.orderID = orderID;
        this.order = order;
    }

    public void addItem(item item) {
        order.add(item);
    }

    public void removeItem(item item) {
        order.remove(item);
    }

    public List<item> getOrder() {
        return order;
    }

    public void setOrderCost(int orderCost) {
        this.OrderCost = orderCost;
    }

    public int getOrderCost() {
        return OrderCost;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public boolean getPaid() {
        return isPaid;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}

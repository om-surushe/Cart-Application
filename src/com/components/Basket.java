package com.components;

// import java.util.ArrayList;
// import java.util.List;

public class Basket {

    private List<item> order; //= new ArrayList<item>();
    private int OrderCost;
    private boolean isPaid;
    private String orderID;

    public Basket(String orderID) {
        this.orderID = orderID;
        // this.order = new ArrayList<item>();
    }

    public Basket(String orderID, List<item> order) {
        this.orderID = orderID;
        this.order = order;
    }

    public void addItem(item item) {
        order.add(item);
    }

    public void removeItem(int item) {
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

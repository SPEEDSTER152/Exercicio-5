package Repositories;

import models.OrderItem;

import java.util.List;

public class Order {

    public OrderItem orderItem;

    private List<OrderItem> items;

    public Order(List<OrderItem> items) {
    }

    public void Order(List<OrderItem> items) {
        this.items = items;
    }
    public void postOrder(OrderItem orderItem){
        this.items.add(orderItem);
    }
    public List<OrderItem> getItems(){
        return items;
    }
}

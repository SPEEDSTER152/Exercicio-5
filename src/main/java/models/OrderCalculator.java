package models;

import Repositories.Order;

public class OrderCalculator {

    Order order;
    Double totalOrder;

    public Double calculateOrder(Order order){
        return totalOrder = order.getItems().stream()
        .mapToDouble(OrderItem::totalPrice)
        .sum();
    }
}

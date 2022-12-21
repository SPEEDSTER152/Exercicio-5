package Services;

import Repositories.Order;
import models.OrderCalculator;
import models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    Double totalOrder;
    @Autowired
    private Order order;

    private OrderCalculator orderCalculator;

    private OrderItem orderItem;

    public void postOrder(OrderItem orderItem){
     order.postOrder(orderItem);
    }

    public List<Object> listItems(){
        Order order = null;
        return Collections.singletonList(order.getItems());
    }

    public Double orderCalculator(){
        this.orderCalculator = new OrderCalculator();
        return orderCalculator.calculateOrder(order);
    }
}

package Controllers;

import Services.OrderService;
import models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Order order;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderItem> postOrder(@RequestBody OrderItem orderitem) {
        orderService.postOrder(orderitem);
                return new ResponseEntity<OrderItem>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Double> calculateOrder(){
        return new ResponseEntity(orderService.orderCalculator(),HttpStatus.OK);
}
}

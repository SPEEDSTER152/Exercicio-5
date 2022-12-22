package models;

import Repositories.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCalculatorTest {

    @Test
    public void shouldCalculateTotalPrice() {

        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<OrderItem> items = Arrays.asList(
                aOrderItem(1, 0.5, 200.00, 0.5),
                aOrderItem(2, 1.0, 300.00, 1.0)
        );
        Double result = orderCalculator.calculateOrder(new Order(items));

        assertEquals(800.00, result);
    }

    private OrderItem aOrderItem(final Integer quantity,
                                 final Double Discount,
                                 final Double price,
                                 final Double maxDiscountPercentage) {

        Product product = new Product(1, "Geladeira", 5, price, maxDiscountPercentage);
        Double discount = null;
        return new OrderItem(product, quantity, discount);

    }
}
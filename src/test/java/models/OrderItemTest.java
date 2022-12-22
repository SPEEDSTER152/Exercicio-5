package models;

import org.junit.jupiter.api.Test;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class OrderItemTest {

    @Test
    public void shouldCalculateTotalPrice() {
        final Product product = new Product(1, "Fogao", 5, 100.00, 50.00,50.00);


        final OrderItem orderItem = new OrderItem("fogao", 5, 0.5);

        final Double result = orderItem.totalPrice();
        assertEquals(63000.00, result);
    }
}

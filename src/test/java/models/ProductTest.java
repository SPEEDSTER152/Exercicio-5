package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void shouldCalculateTotalPriceWithDiscount(){

        Product product = new Product(1,"Fogao",5,40.00,20.00,20.00);
        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(370000, result);
    }

    @Test
    public void whenDiscountIsHigher(){
        Product product = new Product(2, "panela", 10, 50.00, 20.00,30.00);
        Double result = product.getMaxDiscountPrice(0.20);
        assertEquals(300000, result);
    }

    @Test
    public void whenDiscountIsLower(){
        Product product = new Product(3, "geladeira", 15, 60.00, 30.00,30.00);
        Double result = product.getPriceWithDiscount(0.25);
        assertEquals(200000, result);

    }

    @Test
    public void shoulAddQuantiyIsCorrect(){
        Product product = new Product(4, "aspirador", 5, 50.00, 10.00, 40.00);
        Integer result = product.addQuantity(4);
        assertEquals(0,result);
    }

    @Test
    public void whenQuantityIsHigher(){
        Product product = new Product(5, "Talheres", 10, 10.00, 5.00, 5.00);
        Integer result = product.ReduceQuantity(5);
        assertEquals( 0,result);
    }

    @Test
    public void whenQuantityIsLower(){
        Product product = new Product(6, "Copos", 15, 20.00, 5.00, 15.00);
        Integer result = product.ReduceQuantity(6);
        assertEquals(1,result);
    }
}

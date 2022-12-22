package Repositories;

import models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private Product product;

    private final List<Product> products;


    public ProductRepository() {
        this.products = new ArrayList<>();


        Product prod1 = new Product(1, "TV", 5, 40.00, 10.00,30.00);
        Product prod2 = new Product(2, "Geladeira", 10, 50.00, 20.00,30.00);

        products.add(prod1);
        products.add(prod2);
    }

    public  List<Product> findall(){
        return  products;
    }

    public Product findByid(Integer id){
        return products.stream()
                .filter(prd -> prd.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void addStock(Integer id, Integer quantity){
        products.stream()
                .filter(prd -> prd.getProductId().equals(id))
                .forEach(prd -> prd.addQuantity(quantity));
    }

    public void reduceStock(Integer id, Integer quantity){
        products.stream()
                .filter(prd -> prd.getProductId().equals(id))
                .forEach(prd -> prd.ReduceQuantity(quantity));
    }

    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public List<Product> getProducts(){
        return products;
    }
}

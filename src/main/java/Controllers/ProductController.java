package Controllers;

import Services.ProductService;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Product product;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findall(){
        return new ResponseEntity<>(productService.findall(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> findByid(@PathVariable Integer id){
        return new ResponseEntity<Product>((Product) productService.findall(),HttpStatus.OK);
    }
  @PutMapping("{id}/{quantity]")
    public void addStock(@PathVariable("id") Integer id,
                        @PathVariable("quantity") Integer quantity){
                        productService.addstock(id,quantity);

  }
}

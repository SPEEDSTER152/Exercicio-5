package Services;

import Repositories.ProductRepository;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findall(){
     return productRepository.findall();
    }

    public Product findById(Integer id){
        return productRepository.findByid(id);
    }

    public void addstock(Integer id,Integer quantity){
        productRepository.addStock(id,quantity);
    }
}

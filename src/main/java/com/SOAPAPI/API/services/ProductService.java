package com.SOAPAPI.API.services;

import com.SOAPAPI.API.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Long id);
    void deleteAllProducts();
    Product getProductById(Long id);
    List<Product> getAllProducts();
}



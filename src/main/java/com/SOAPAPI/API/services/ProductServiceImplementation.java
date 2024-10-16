package com.SOAPAPI.API.services;

import com.SOAPAPI.API.entities.Product;
import com.SOAPAPI.API.repositories.ProductRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@WebService(serviceName = "ProductWS")
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    @WebMethod(operationName = "saveProduct")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @WebMethod(operationName = "updateProduct")
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @WebMethod(operationName = "deleteProductById")
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @WebMethod(operationName = "deleteAllProducts")
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    @WebMethod(operationName = "getProductById")
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    @WebMethod(operationName = "getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

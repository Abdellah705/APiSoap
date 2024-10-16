package com.SOAPAPI.API;

import com.SOAPAPI.API.entities.Product;
import com.SOAPAPI.API.services.ProductService;
import com.SOAPAPI.API.services.ProductServiceImplementation;
import jakarta.xml.ws.Endpoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(ProductService productService) {
		Product product1 = new Product(1L, "P1", 20.00, "Produit Numero 1");
		Product product2 = new Product(2L, "P2", 25.00, "Produit Numero 2");
		Product product3 = new Product(3L, "P3", 90.00, "Produit Numero 3");
		Product product4 = new Product(4L, "P4", 100.00, "Produit Numero 4");
		Product product5 = new Product(5L, "P5", 200.00, "Produit Numero 5");

		return args -> {
			productService.saveProduct(product1);
			productService.saveProduct(product2);
			productService.saveProduct(product3);
			productService.saveProduct(product4);
			productService.saveProduct(product5);
		};
	}

	@Bean
	public Endpoint endpoint(ProductServiceImplementation productServiceImplementation) {
		String url = "http://0.0.0.0:8088/ProductWS";
		Endpoint endpoint = Endpoint.publish(url, productServiceImplementation);
		System.out.println(url + " deployed");
		return endpoint;
	}
}

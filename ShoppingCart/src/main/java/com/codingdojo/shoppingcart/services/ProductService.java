package com.codingdojo.shoppingcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.shoppingcart.models.Product;
import com.codingdojo.shoppingcart.repositories.ProductRepository;


@Service
public class ProductService {
	//dependency injection
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	//find all products
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	//Search for product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	//save product created
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	public Product findByName(String name) {
		return productRepo.getByName(name);
	}
	
}

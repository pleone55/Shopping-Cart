package com.codingdojo.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.shoppingcart.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	//find all products
	List<Product> findAll();
	
	//find by name
	Product getByName(String name);
}

package com.codingdojo.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.shoppingcart.models.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	//find all categories
	List<Category> findAll();
}

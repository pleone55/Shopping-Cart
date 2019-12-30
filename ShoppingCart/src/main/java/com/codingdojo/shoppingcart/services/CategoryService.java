package com.codingdojo.shoppingcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.shoppingcart.models.Category;
import com.codingdojo.shoppingcart.repositories.CategoryRepository;

@Service
public class CategoryService {
	//dependency injection
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	//find all products
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	//Search for product
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	//save product created
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
}

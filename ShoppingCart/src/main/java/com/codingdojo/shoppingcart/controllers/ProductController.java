package com.codingdojo.shoppingcart.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.shoppingcart.models.Category;
import com.codingdojo.shoppingcart.models.Product;
import com.codingdojo.shoppingcart.services.CategoryService;
import com.codingdojo.shoppingcart.services.ProductService;

@Controller
public class ProductController {
	//dependency injection
	private final ProductService proService;
	private final CategoryService catService;
	
	public ProductController(ProductService proService, CategoryService catService) {
		this.proService = proService;
		this.catService = catService;
	}
	
	@GetMapping("/products/new")
	public String productIndex(@ModelAttribute("product") Product product) {
		return "/products/newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/newProduct.jsp";
		}else {
			proService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") Long productId, @RequestParam("id") Long categoryId) {
		Product product = proService.findProduct(productId);
		Category category = catService.findCategory(categoryId);
		
		product.getCategories().add(category);
		proService.createProduct(product);
		
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		// Model variables
		Product product = proService.findProduct(id);
		List<Category> categories = catService.allCategories();
		List<Category> remCategories = new ArrayList<Category>();
		
		// removes all categories linked to product
		for (Category category : categories) {
			for (Product pro : category.getProducts()) {
				if (pro.getId().equals(id)) {
					remCategories.add(category);
				}
			}
		}
		
		// Removes found objects
		categories.removeAll(remCategories);
		
		// Binds data to models
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);

		return "/products/showProduct.jsp";
	}
}

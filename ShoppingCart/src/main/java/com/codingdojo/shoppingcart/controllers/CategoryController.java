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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.shoppingcart.models.Category;
import com.codingdojo.shoppingcart.models.Product;
import com.codingdojo.shoppingcart.services.CategoryService;
import com.codingdojo.shoppingcart.services.ProductService;



@Controller
public class CategoryController {
	//dependency injection
	private final CategoryService catService;
	private final ProductService proService;
	
	public CategoryController(CategoryService catService, ProductService proService) {
		this.catService = catService;
		this.proService = proService;
	}
	
	@GetMapping("/categories/new")
	public String categoryIndex(@ModelAttribute("category") Category category) {
		return "/categories/newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "categories/newCategory.jsp";
		}else {
			catService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@PutMapping("/categories/{id}")
	public String updateCategory(@PathVariable("id") Long categoryId, @RequestParam("id") Long productId) {
		Category category = catService.findCategory(categoryId);
		Product product = proService.findProduct(productId);
		
		
		category.getProducts().add(product);
		catService.createCategory(category);
		
		return "redirect:/categories/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = catService.findCategory(id);
		model.addAttribute("category", category);
		return "/categories/showCat.jsp";
	}
	
	@RequestMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = catService.allCategories();
		model.addAttribute("categories", categories);
		return "/categories/catList.jsp";
	}
	
}

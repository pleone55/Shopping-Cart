package com.codingdojo.shoppingcart.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.shoppingcart.models.Product;
import com.codingdojo.shoppingcart.services.ProductService;

@Controller
public class CartController {
	private final ProductService productService;
	
	public CartController(ProductService productServce) {
		this.productService = productServce;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "/cart/dashboard.jsp";
	}
	
	@RequestMapping("/add/{id}")
	public String addCart(@PathVariable Long id, Model model, HttpSession session) {
		Product p = productService.findProduct(id);
		
		if(session.getAttribute("productSesh") == null) {
			Map<String, Integer> cart = new HashMap<>();
			cart.put(p.getName(), (int) p.getPrice());
			session.setAttribute("productSesh", cart);
			model.addAttribute("cart", cart);
			double sum = 0;
			for(double val : cart.values()) {
				sum += val;
			}
			model.addAttribute("sum", sum);
		}else {
			Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("productSesh");
			cart.put(p.getName(), (int) p.getPrice());
			session.setAttribute("productSesh", cart);
			model.addAttribute("cart", cart);
			double sum = 0;
			for(double val : cart.values()) {
				sum += val;
			}
			model.addAttribute("sum", sum);
		}
		return "/cart/addCart.jsp";
	}
	

	@RequestMapping("/cart")
	public String cart(HttpSession session, Model model) {
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("productSesh");
		model.addAttribute("cart", cart);
		double sum = 0;
		for (double val : cart.values()) {
			sum += val;
		}
		model.addAttribute("sum", sum);
		return "/cart/addCart.jsp";
	}
	

	@RequestMapping("/delete")
	public String deleteFromCart(@RequestParam("key") String key, HttpSession session, Model model) {
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("productSesh");
		cart.remove(key);
		double sum = 0;
		for (double val : cart.values()) {
			sum += val;
		}
		session.setAttribute("productSesh", cart);
		model.addAttribute("cart", cart);
		model.addAttribute("sum", sum);
		return "redirect:/cart";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("productSesh");
		model.addAttribute("cart", cart);
		double sum = 0;
		for (double val : cart.values()) {
			sum += val;
		}
		model.addAttribute("sum", sum);
		return "/cart/payment.jsp";
	}
	
	@RequestMapping("/complete")
	public String complete() {
		return "/cart/complete.jsp";
	}
}

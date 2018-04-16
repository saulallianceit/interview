package com.example.interview.interview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.interview.model.Product;
import com.example.interview.interview.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/listing")
	public String showList(Model model){
		
		model.addAttribute("products", productService.getAllProducts());
		
		return "listingPage";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product){
				
			productService.save(product);		
			return "redirect:/products/listing";		
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(Model model, @PathVariable(value="id") long id){
		
		Product product = productService.get(id);
		model.addAttribute("product", product);
		
		return "editProduct";
	}
	
	@PostMapping("updateProduct")
	public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "editProduct";
		} else {
			productService.update(product);		
			return "redirect:/products/listing";
		}
	}
	
	@GetMapping("/removeProduct/{id}")
	public String removeProduct(Model model, @PathVariable(value="id") long id){
		
		productService.remove(id);
		return "redirect:/products/listing";
	}
}

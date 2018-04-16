package com.example.interview.interview.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.interview.interview.model.User;
import com.example.interview.interview.service.ProductService;



@Controller
public class LoginController {	
	
	@Autowired
	ProductService productService;
	
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/login");
	}
	
	@GetMapping("/login")
	public String showLoginPage(){		
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute("user") User user, Model model){						
		
		Properties properties = new Properties();
		InputStream input = null;

		try {
			
			input = new FileInputStream("users.properties");						
			properties.load(input);							
			
		} catch (Exception e) {
			LOGGER.error("Error loading properties file");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error("Error closing properties file");
				}
			}
		}				
		
		if((user.getUser().equals(properties.getProperty("admin")) && user.getPassword().equals(properties.getProperty("adminPassword"))) || (user.getUser().equals(properties.getProperty("user")) && user.getPassword().equals(properties.getProperty("userPassword")))){
			model.addAttribute("products", productService.getAllProducts());
			return "listingPage";
		} else {
			return "loginErrorPage";
		}
	}
}

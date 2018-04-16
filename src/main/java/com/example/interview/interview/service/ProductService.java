package com.example.interview.interview.service;

import java.util.List;

import com.example.interview.interview.model.Product;


public interface ProductService {
		
	List<Product> getAllProducts();
	Product save(Product product);
	Product update(Product product);
	Product get(long id);
	void remove(long id);
	long getNextId();
}

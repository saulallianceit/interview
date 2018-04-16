package com.example.interview.interview.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.interview.interview.model.Product;
import com.example.interview.interview.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private List<Product> products;	

	public ProductServiceImpl(){
		this.products = new ArrayList<Product>();
		products.add(new Product(1,"Shoe","White Shoe"));
		products.add(new Product(2,"Computer","Toshiba"));
		products.add(new Product(3,"Computer","Apple"));
		products.add(new Product(4,"Toy Car","Matel"));
	}
	
	@Override
	public List<Product> getAllProducts() {
		return this.products;
	}

	@Override
	public Product save(Product product) {
		product.setId(getNextId());
		products.add(product);
		
		return product;
	}

	@Override
	public Product update(Product product) {
		int productCount = products.size();
		for(int i=0;i<productCount;i++){
			Product savedProduct = products.get(i);
			
			if(savedProduct.getId() == product.getId()){
				products.set(i, product);
				return product;
			}
		}
		return product;
	}

	@Override
	public Product get(long id) {
		for(Product product : products){
			if(id == product.getId()){
				return product;
			}
		}
		return null;
	}
	
	@Override
	public void remove(long id){
		
		for(Product product : products){
			if(id == product.getId()){
				products.remove(product);
			}
		}
	}

	@Override
	public long getNextId() {
		long id = 0L;
		
		for(Product product : products){
			long productId = product.getId();
			
			if(productId > id){
				id = productId;
			}
		}
		return id + 1;
	}

}

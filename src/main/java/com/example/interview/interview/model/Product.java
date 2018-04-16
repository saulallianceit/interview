package com.example.interview.interview.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	@NotNull @NotBlank @NotEmpty 
	private String name;
	@NotNull @NotBlank @NotEmpty
	private String description;	
	
	public Product(){}
	
	public Product(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

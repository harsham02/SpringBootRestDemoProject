package com.sa.springbootrestdemo.service;

import java.util.List;

import com.sa.springbootrestdemo.controller.dto.ProductDto;
import com.sa.springbootrestdemo.entities.Product;
import com.sa.springbootrestdemo.exception.ProductAlreadyExistsException;
import com.sa.springbootrestdemo.exception.ProductNotFoundException;

public interface ProductService {
	
	public List<Product> getAllProducts() throws ProductNotFoundException; //GET
	public Product addProduct(Product product) throws ProductAlreadyExistsException; //POST
	public Product editProduct(Product product); //PUT
	public Product getProductById(long id) throws ProductNotFoundException; //GET
	public Product getProductByName(String name); //GET
	public String deleteProduct(long id); //DELETE

	public List<ProductDto> getAllProductDtos(); //GET
	public ProductDto getProductDtoById(long id); //GET
	public ProductDto getProductDtoByName(String name); //GET
	
}
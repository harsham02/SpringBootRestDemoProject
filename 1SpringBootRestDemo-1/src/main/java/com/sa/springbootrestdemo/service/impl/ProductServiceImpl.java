package com.sa.springbootrestdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.springbootrestdemo.controller.dto.ProductDto;
import com.sa.springbootrestdemo.entities.Product;
import com.sa.springbootrestdemo.exception.ProductAlreadyExistsException;
import com.sa.springbootrestdemo.exception.ProductNotFoundException;
import com.sa.springbootrestdemo.mapper.ProductMapper;
import com.sa.springbootrestdemo.repository.ProductRepository;
import com.sa.springbootrestdemo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo; //Product
	
	@Autowired
	private ProductMapper mapper; //ProductDto

	@Override
	public List<Product> getAllProducts() throws ProductNotFoundException {
		List<Product> products = productRepo.findAll(); //in-built methods
		//Or
//		List<Product> products = productRepo.getProducts(); //Custom Query
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Products does not exist. Please add products..");
		}
		return products;
	}

	@Override
	public Product addProduct(Product product) throws ProductAlreadyExistsException {
		Product product2 = null;
		if(productRepo.existsById(product.getProductId())) {
			throw new ProductAlreadyExistsException("Product already exist..");
		}
		else {
			 product2 = productRepo.save(product); //in-built method - insert the data
		}
		return product2;
	}

	@Override
	public Product editProduct(Product product) {
		
		return null;
	}

	@Override
	public Product getProductById(long id) throws ProductNotFoundException {
//		Product product = productRepo.findById(id).get(); //in-built method
		//or
//		Product product = productRepo.getProductById(id); //Custom Query
		//or
		Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product does not exist with this id"));
//		if(! productRepo.existsById(id)) {
//			throw new ProductNotFoundException("Product does not exist with this id");
//		}
		return product;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getAllProductDtos() {
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		List<Product> products = new ArrayList<>();
		ProductDto productDto = new ProductDto();
		products = productRepo.findAll();
		for(Product product : products) {
			productDto = mapper.convertToDto(product);
			productDtos.add(productDto);
		}
		return productDtos;
	}

	@Override
	public ProductDto getProductDtoById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProductDtoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

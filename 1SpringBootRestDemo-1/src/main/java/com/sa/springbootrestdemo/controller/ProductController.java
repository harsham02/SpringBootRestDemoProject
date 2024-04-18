package com.sa.springbootrestdemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sa.springbootrestdemo.entities.Product;
import com.sa.springbootrestdemo.exception.ProductAlreadyExistsException;
import com.sa.springbootrestdemo.exception.ProductNotFoundException;
import com.sa.springbootrestdemo.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
//	@RequestMapping(name = "/products", method = RequestMethod.GET)
	//Or
//	@GetMapping("/products")
//	public List<Product> get(){
//		List<Product> products = null;
//		try {
//			products = service.getAllProducts();
//		} catch (ProductNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		return products;
//	}
	
	//Or
	
	
//	@RequestMapping(name = "/products", method = RequestMethod.GET)
	//Or
	@GetMapping("/products")
//	@Operation(summary = "To get list of Products")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	
//	@RequestMapping(name = "/product", method = RequestMethod.POST)
	//or
	@PostMapping("/product/add")
//	@Operation(summary = "To add a Product")
	public ResponseEntity<?> post(@RequestBody Product product){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
		} catch (ProductAlreadyExistsException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return response;
	}
	
	
//	@RequestMapping(name = "/products", method = RequestMethod.GET)
	//Or
	@GetMapping("/product/{id}")
	@Operation(summary = "To get the Product by using id - path variable")
	public ResponseEntity<?> getById(@PathVariable(value = "id") long id){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
//	@RequestMapping(name = "/products", method = RequestMethod.GET)
	//Or
	@GetMapping("/product/id")
	@Operation(summary = "To get the Product by using id - path param")
	public ResponseEntity<?> getProductById(@PathParam(value = "id") long id){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/productDtos")
	@Operation(summary = "To get list of ProductDtos")
	public ResponseEntity<?> getProductDtos(){
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.getAllProductDtos(), HttpStatus.OK);
		return response;
	}
	
}

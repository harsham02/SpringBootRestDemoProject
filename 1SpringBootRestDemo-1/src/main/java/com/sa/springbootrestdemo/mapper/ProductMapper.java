package com.sa.springbootrestdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.springbootrestdemo.controller.dto.ProductDto;
import com.sa.springbootrestdemo.entities.Product;

@Mapper
public interface ProductMapper {
	
	@Mapping(source = "product.productId", target = "productId")//Source - Entity, target- Dto
	@Mapping(source = "product.name", target = "name")
	public ProductDto convertToDto(Product product); //Convert Entity to Dto
	
	
	@Mapping(source = "productId", target = "productId")//Source - Dto, target - Entity
	@Mapping(source = "name", target = "name")
	public Product convertToEntity(ProductDto dto); //Convert Dto to Entity
	
	
}

package com.sa.springbootrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sa.springbootrestdemo.mapper.ProductMapper;
import com.sa.springbootrestdemo.mapper.ProductMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ProductAPI",version = "1.0",description = "API for product service"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ProductMapper getMapper() {
		return new ProductMapperImpl();
	}

}

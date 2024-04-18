package com.sa.springbootrestdemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Default Constructor
@AllArgsConstructor //Parameterized Constructor
@Data //Getter and setter methods
@Entity //Maps as a table in DB
public class Product {
	
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	private String name;
	private int quantity;
	private double price;

}



#Spring Boot RESTful Product Management
This Spring Boot project serves as a RESTful API for managing product information. It leverages Java, Core Java, Hibernate, and Spring Boot to provide CRUD functionality for products.

Introduction
The Spring Boot RESTful Product Management project aims to demonstrate the implementation of a RESTful API for handling product data. It offers endpoints to perform CRUD operations on products, enabling users to create, read, update, and delete product records.

Features
Create: Add a new product to the database.
Read: Retrieve product information.
Update: Modify existing product details.
Delete: Remove a product from the database.

API Documentation
#POST /product/product/add: Create a new product.
#Request Body: Product details.
#GET /product/products: Get a list of all products.
#GET /product/productDtos: Get a list of ProductDtos.
#GET /product/product/{id}: Get a product by ID (path variable).
*Parameters: id (Product ID).
#GET /product/product?id={id}: Get a product by ID (query parameter).
*Parameters: id (Product ID).

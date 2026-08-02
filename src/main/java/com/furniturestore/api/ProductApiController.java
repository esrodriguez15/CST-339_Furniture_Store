package com.furniturestore.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniturestore.data.service.ProductDataService;
import com.furniturestore.model.ProductModel;

/**
 * REST API controller for retrieving all products and individual products 
 * from database as JSON
 * 
 */
@RestController
@RequestMapping("/api/products")
public class ProductApiController 
{
	private final ProductDataService productDataService;
	
	public ProductApiController(ProductDataService productDataService)
	{
		this.productDataService = productDataService;
	}
	
	/**
	 * REST API - return all products
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts()
	{
		List<ProductModel> products = productDataService.findAll();
		return ResponseEntity.ok(products);
	}
	
	/*
	 * REST API - return desired product
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable Long id)
	{
		ProductModel product = productDataService.findById(id);
		
		if (product == null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
}

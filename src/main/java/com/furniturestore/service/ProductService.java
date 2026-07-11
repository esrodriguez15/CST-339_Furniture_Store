package com.furniturestore.service;

import java.util.List;

import com.furniturestore.model.ProductModel;

/**
 * Interface that defines the operations for the product service.
 */
public interface ProductService
{
	/**
	 * Creates a new product.
	 *
	 * @param product the product to create
	 * @return true when the product is successfully created
	 */
	public boolean createProduct(ProductModel product);
	
	/**
	 * Returns all products for display.
	 */
	public List<ProductModel> getAllProducts();
	
	/**
	 * Deletes product
	 * 
	 */
	public void deleteProduct(Long id);
	 
}

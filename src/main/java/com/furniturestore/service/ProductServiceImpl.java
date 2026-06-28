package com.furniturestore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniturestore.model.ProductModel;

/**
 * Service implementation used to create and temporarily store products.
 */
@Service
public class ProductServiceImpl implements ProductService
{
	private final List<ProductModel> products = new ArrayList<ProductModel>();

	/**
	 * Adds a new product to the temporary product list.
	 *
	 * @param product the product to create
	 * @return true when the product is successfully added
	 */
	@Override
	public boolean createProduct(ProductModel product)
	{
		products.add(product);
		return true;
	}
	
	@Override
	public List<ProductModel> getAllProducts()
	{
	    return products;
	}
}

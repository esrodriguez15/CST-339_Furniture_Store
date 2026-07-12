package com.furniturestore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniturestore.data.service.ProductDataService;
import com.furniturestore.model.ProductModel;

/**
 * Service implementation used to manage products.
 */
@Service
public class ProductServiceImpl implements ProductService
{
	private final ProductDataService productDataService;

	/**
	 * Constructor injection used to provide the product data service.
	 *
	 * @param productDataService the product data service
	 */
	public ProductServiceImpl(ProductDataService productDataService)
	{
		this.productDataService = productDataService;
	}

	/**
	 * Creates a new product.
	 *
	 * @param product the product to create
	 * @return true when the product is successfully created
	 */
	@Override
	public boolean createProduct(ProductModel product)
	{
		productDataService.save(product);
		return true;
	}

	/**
	 * Returns all products.
	 *
	 * @return the list of products
	 */
	@Override
	public List<ProductModel> getAllProducts()
	{
		return productDataService.findAll();
	}

	/**
	 * Returns one product by its ID.
	 *
	 * @param id the product ID
	 * @return the matching product
	 */
	@Override
	public ProductModel getProductById(Long id)
	{
		return productDataService.findById(id);
	}

	/**
	 * Updates an existing product.
	 *
	 * @param product the updated product
	 * @return true when the update is successful
	 */
	@Override
	public boolean updateProduct(ProductModel product)
	{
		productDataService.update(product);
		return true;
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id the product ID
	 */
	@Override
	public void deleteProduct(Long id)
	{
		productDataService.deleteById(id);
	}
}

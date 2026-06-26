package com.furniturestore.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Model used to store product information entered through
 * the product creation form.
 */
public class ProductModel
{
	@NotBlank(message = "Product name is required")
	@Size(max = 100, message = "Product name cannot exceed 100 characters")
	private String productName;

	@NotBlank(message = "Description is required")
	@Size(max = 500, message = "Description cannot exceed 500 characters")
	private String description;

	@NotBlank(message = "Category is required")
	private String category;

	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01", message = "Price must be greater than zero")
	private Double price;

	@NotNull(message = "Quantity is required")
	@Min(value = 0, message = "Quantity cannot be negative")
	private Integer quantity;

	/**
	 * Returns the product name.
	 *
	 * @return the product name
	 */
	public String getProductName()
	{
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the product name to set
	 */
	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	/**
	 * Returns the product description.
	 *
	 * @return the product description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the product description.
	 *
	 * @param description the product description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Returns the product category.
	 *
	 * @return the product category
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * Sets the product category.
	 *
	 * @param category the product category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	/**
	 * Returns the product price.
	 *
	 * @return the product price
	 */
	public Double getPrice()
	{
		return price;
	}

	/**
	 * Sets the product price.
	 *
	 * @param price the product price to set
	 */
	public void setPrice(Double price)
	{
		this.price = price;
	}

	/**
	 * Returns the available product quantity.
	 *
	 * @return the product quantity
	 */
	public Integer getQuantity()
	{
		return quantity;
	}

	/**
	 * Sets the available product quantity.
	 *
	 * @param quantity the product quantity to set
	 */
	public void setQuantity(Integer quantity)
	{
		this.quantity = quantity;
	}
}
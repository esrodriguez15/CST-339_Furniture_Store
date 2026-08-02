package com.furniturestore.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity class that represents a product. 
 * Each field corresponds to column in the database.
 */
@Table("products")
public class ProductEntity 
{
	@Id
	private Long id;
	private String productName;
	private String description;
	private String category;
	private Double price;
	private Integer quantity;
	
	 /**
	  * Gets product ID
	  */
    public Long getId() {
        return id;
    }

    /**
     * Sets product ID
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns product name
     * 
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets product name
     * 
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Returns product description
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets product description
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns product category
     * 
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets product category
     * 
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * returns price
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     * sets price
     * 
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * returns product quantity
     * 
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets products quantity
     * 
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }	
}

package com.furniturestore.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.furniturestore.data.entity.ProductEntity;

/**
 * Extends Spring Data JDBC's CRUD Repository functions
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long>
{
	
}

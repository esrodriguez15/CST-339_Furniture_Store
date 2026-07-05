package com.furniturestore.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.furniturestore.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>
{
	
}

package com.furniturestore.data.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.furniturestore.data.entity.ProductEntity;
import com.furniturestore.data.repository.ProductRepository;
import com.furniturestore.model.ProductModel;

@Service
public class ProductDataService 
{
	private final ProductRepository productRepository;
	
	public ProductDataService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
	public void save(ProductModel model)
	{
		ProductEntity entity = new ProductEntity();
		entity.setProductName(model.getProductName());
		entity.setDescription(model.getDescription());
		entity.setCategory(model.getCategory());
		entity.setPrice(model.getPrice());
		entity.setQuantity(model.getQuantity());
		productRepository.save(entity);	
	}
	
	public List<ProductModel> findAll()
	{
		return ((List<ProductEntity>) productRepository.findAll())
				.stream()
				.map(e -> {
					ProductModel m = new ProductModel();
					m.setProductName(e.getProductName());
					m.setDescription(e.getDescription());
					m.setCategory(e.getCategory());
					m.setPrice(e.getPrice());
					m.setQuantity(e.getQuantity());
					return m;
				})
				.collect(Collectors.toList());
	}
	
	public void deleteById(Long id)
	{
		productRepository.deleteById(id);
	}
}

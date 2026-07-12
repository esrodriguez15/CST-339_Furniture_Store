package com.furniturestore.data.service;

import java.util.List;
import java.util.Optional;
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
				.map(entity -> {
					ProductModel model = new ProductModel();
					model.setId(entity.getId());
					model.setProductName(entity.getProductName());
					model.setDescription(entity.getDescription());
					model.setCategory(entity.getCategory());
					model.setPrice(entity.getPrice());
					model.setQuantity(entity.getQuantity());
					return model;
				})
				.collect(Collectors.toList());
	}

	public ProductModel findById(Long id)
	{
		Optional<ProductEntity> optionalEntity = productRepository.findById(id);

		if (optionalEntity.isEmpty())
		{
			return null;
		}

		ProductEntity entity = optionalEntity.get();

		ProductModel model = new ProductModel();
		model.setId(entity.getId());
		model.setProductName(entity.getProductName());
		model.setDescription(entity.getDescription());
		model.setCategory(entity.getCategory());
		model.setPrice(entity.getPrice());
		model.setQuantity(entity.getQuantity());

		return model;
	}

	public void update(ProductModel model)
	{
		ProductEntity entity = new ProductEntity();
		entity.setId(model.getId());
		entity.setProductName(model.getProductName());
		entity.setDescription(model.getDescription());
		entity.setCategory(model.getCategory());
		entity.setPrice(model.getPrice());
		entity.setQuantity(model.getQuantity());

		productRepository.save(entity);
	}

	public void deleteById(Long id)
	{
		productRepository.deleteById(id);
	}
}
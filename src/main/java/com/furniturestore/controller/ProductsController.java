package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.furniturestore.model.ProductModel;
import com.furniturestore.service.ProductService;

import jakarta.validation.Valid;

/**
 * Controller used to display products and process
 * the product creation form.
 */
@Controller
public class ProductsController
{
	private final ProductService productService;

	/**
	 * Constructor injection used to provide the product service.
	 *
	 * @param productService the product service
	 */
	public ProductsController(ProductService productService)
	{
		this.productService = productService;
	}

	/**
	 * Displays the customer product page.
	 *
	 * @return the products page
	 */
	@GetMapping("/products")
	public String products()
	{
		return "products";
	}

	/**
	 * Displays the product creation form.
	 *
	 * @param model the Spring MVC model
	 * @return the product creation page
	 */
	@GetMapping("/products/create")
	public String displayProductForm(Model model)
	{
		model.addAttribute("productModel", new ProductModel());

		return "product-create";
	}

	/**
	 * Processes the submitted product creation form.
	 *
	 * @param productModel the submitted product information
	 * @param bindingResult the validation results
	 * @param model the Spring MVC model
	 * @return the product creation page
	 */
	@PostMapping("/products/create")
	public String createProduct(
			@Valid @ModelAttribute("productModel") ProductModel productModel,
			BindingResult bindingResult,
			Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "product-create";
		}

		productService.createProduct(productModel);

		model.addAttribute("successMessage", "Product created successfully.");
		model.addAttribute("productModel", new ProductModel());

		return "product-create";
	}
}
package com.furniturestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String products(Model model)
	{
	    model.addAttribute("products", productService.getAllProducts());
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
	
	/**
	 * Displays the product edit form.
	 *
	 * @param id the product ID
	 * @param model the Spring MVC model
	 * @return the product edit page
	 */
	@GetMapping("/products/edit/{id}")
	public String displayEditProductForm(@PathVariable Long id, Model model)
	{
	    ProductModel product = productService.getProductById(id);

	    model.addAttribute("productModel", product);

	    return "product-edit";
	}

	/**
	 * Processes the submitted product edit form.
	 *
	 * @param productModel the updated product
	 * @param bindingResult the validation results
	 * @return redirects to the products page
	 */
	@PostMapping("/products/edit")
	public String updateProduct(
	        @Valid @ModelAttribute("productModel") ProductModel productModel,
	        BindingResult bindingResult)
	{
	    if (bindingResult.hasErrors())
	    {
	        return "product-edit";
	    }

	    productService.updateProduct(productModel);

	    return "redirect:/products";
	}
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		productService.deleteProduct(id);
		return "redirect:/products";	
	}
}

package com.productcatalogview.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcatalogview.model.Product;
import com.productcatalogview.service.ICatalogViewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalogview/v1")
public class CatalogViewController {
	
	
	private final ICatalogViewService catalogViewService;
	
//	http://localhost:8082/catalogview/v1/products
	@GetMapping("/products")
	ResponseEntity<List<Product>>  getAllProducts(){
		List<Product> products =  catalogViewService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/products/color/{color}/price/{price}")
	ResponseEntity<List<Product>>  getByColorAndLesserPrice(String color,double price){
		List<Product> products =  catalogViewService.getByColorAndLesserPrice(color, price);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/products/category/{category}/brand/{brand}")
	ResponseEntity<List<Product>>  getByCategoryAndBrand(String category, String brand){
		List<Product> products =  catalogViewService.getByCategoryAndBrand(category, brand);
		return ResponseEntity.ok(products);
	}
	@GetMapping("/products/offers/{offername}")
	ResponseEntity<List<Product>>  getByoffers(String offername){
		List<Product> products =  catalogViewService.getByoffers(offername);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/products/id/{productId}")
	ResponseEntity<Product> getById(int productId){
		Product product =  catalogViewService.getById(productId);
		return ResponseEntity.ok(product);
	}

}















package com.productcatalogview.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.productcatalogview.model.Product;


//pass the application name of the microservice to which you want to communicate
//this is the client for Catalog Service
// the abstract methods will be imolemented by feign
@FeignClient(name = "product-catalog") 
public interface ICatalogFeignClient {
	
	// this is a http to java binder
	//converts the http calls to java method calls
	
	//copy the restend points from the ProductController as abstract methods
	// copy the url pattern also
//	http://product-catalog/product-api/v1/products
	@GetMapping("/product-api/v1/products")
	List<Product> getAll();
	
//	http://product-catalog/product-api/v1/products/color/black/price/10000
	@GetMapping("/product-api/v1/products/color/{color}/price/{price}")
	List<Product> getByColorAndLesserPrice(@PathVariable String color,@PathVariable double price);
	
//	http://product-catalog/product-api/v1/products/category/Electronics/brand/Samsung
	@GetMapping("/product-api/v1/products/category/{categoryName}/brand/{brandName}")
	List<Product> getByCategoryAndBrand(@PathVariable String categoryName,String brandName);
		
//	http://product-catalog/product-api/v1/products/id/1
	@GetMapping("/product-api/v1/products/id/{productId}")
	Product getById(@PathVariable int productId);
	
//	http://localhost:8081/product-api/v1/products/offers?offername=Bank offer
	@GetMapping("/product-api/v1/products/offers")
	List<Product> getByoffers(@RequestParam String offername);
	
	
	

}

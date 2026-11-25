package com.productcatalogview.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productcatalogview.exception.ProductNotFoundException;
import com.productcatalogview.feign.ICatalogFeignClient;
import com.productcatalogview.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogViewFeignServiceImpl implements ICatalogViewService{
	
	//autowire ICatalogFeignClient;
	private final ICatalogFeignClient feignClient;
   //call the methods of feign client just like calling java methods
	
	@Override
	public List<Product> getAllProducts() {
		return feignClient.getAll();
	}

	@Override
	public List<Product> getByColorAndLesserPrice(String color, double price) throws ProductNotFoundException {
		return feignClient.getByColorAndLesserPrice(color, price);
	}

	@Override
	public List<Product> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException {
		return feignClient.getByCategoryAndBrand(category, brand);
	}

	@Override
	public List<Product> getByoffers(String offername) throws ProductNotFoundException {
		return feignClient.getByoffers(offername);
	}

	@Override
	public Product getById(int productId) {
		return getById(productId);
	}

}

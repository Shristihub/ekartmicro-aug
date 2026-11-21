package com.productcatalogview.service;

import java.util.List;

import com.productcatalogview.exception.ProductNotFoundException;
import com.productcatalogview.model.Product;

public interface ICatalogViewService {

	List<Product> getAllProducts();
	List<Product> getByColorAndLesserPrice(String color,double price) throws ProductNotFoundException;
	List<Product> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException;
	List<Product> getByoffers(String offername)throws ProductNotFoundException;
	Product getById(int productId);
	
	
}

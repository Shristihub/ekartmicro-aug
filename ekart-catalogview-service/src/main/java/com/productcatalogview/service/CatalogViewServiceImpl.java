package com.productcatalogview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.productcatalogview.exception.ProductNotFoundException;
import com.productcatalogview.model.Product;

//@Service
public class CatalogViewServiceImpl implements ICatalogViewService{
	
	//from here call the other microservice
	
	// get the url of the microservice - pass the application name
	private final String BASEURL = "http://product-catalog/product-api/v1/products";

	
	private RestClient restclient;
	
//	create a RestClient object using the builder and autowire it
	public CatalogViewServiceImpl(@Qualifier("loadBalancedBuilder") RestClient.Builder restclientBuilder) {
		super();
		this.restclient = restclientBuilder.build();
	}

	@Override
	public List<Product> getAllProducts() {
		// http://localhost:8081/product-api/v1/products  - the endpoint to call
		return restclient.get()
		          .uri(BASEURL)
		          .accept(MediaType.APPLICATION_JSON)
		          .retrieve()
		          .body(new ParameterizedTypeReference<List<Product>>() {});
	}

	@Override
	public List<Product> getByColorAndLesserPrice(String color, double price) throws ProductNotFoundException {
		// http://localhost:8081/product-api/v1/products/color/black/price/10000
		return restclient.get()
		          .uri(BASEURL.concat("/color/{co}/price/{price}"),color,price)
		          .accept(MediaType.APPLICATION_JSON)
		          .retrieve()
		          .body(new ParameterizedTypeReference<List<Product>>() {});
	
	}

	@Override
	public List<Product> getByCategoryAndBrand(String category, String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByoffers(String offername) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int productId) {
		// http://localhost:8081/product-api/v1/products/id/1
		return  restclient.get()
		          .uri(BASEURL.concat("/id/{id}"),productId)
		          .accept(MediaType.APPLICATION_JSON)
		          .retrieve()
		          .body(new ParameterizedTypeReference<Product>() {});	 
	}

}

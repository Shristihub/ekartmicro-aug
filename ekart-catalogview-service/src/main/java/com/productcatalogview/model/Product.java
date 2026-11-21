package com.productcatalogview.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	private String productName;
	private Integer productId;
	private double price;  
	private int ratings;
	
	private Features features;
	private List<Offers> offers;
	private List<Category> categories; 
	private Brand brand; 
	private List<String> paymentMode; 
	private List<String> deliveryTypes; 
	
}





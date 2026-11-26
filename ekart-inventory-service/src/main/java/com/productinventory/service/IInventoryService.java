package com.productinventory.service;

import com.productinventory.exception.ProductIdNotFoundException;
import com.productinventory.model.InventoryDto;

public interface IInventoryService {

	String addStock(InventoryDto inventoryDto);
	String updateStock(int productId,int stock, String type) throws ProductIdNotFoundException; //type is inc/dec
	int checkStock(int productId) throws ProductIdNotFoundException;
}

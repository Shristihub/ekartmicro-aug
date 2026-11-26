package com.productcatalog.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productcatalog.dtos.InventoryDto;

@FeignClient(name = "product-inventory") //application name
public interface IInventoryFeignClient {
	
//	http://product-inventory/inventory-service/v1/inventories/productId/1
	
	@PostMapping("/inventory-service/v1/inventories")
	String addStock(@RequestBody InventoryDto inventoryDto);
	
	

}

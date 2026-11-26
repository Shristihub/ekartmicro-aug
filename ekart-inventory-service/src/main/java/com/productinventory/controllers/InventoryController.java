package com.productinventory.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.productinventory.config.AppConfig;
import com.productinventory.model.InventoryDto;
import com.productinventory.service.IInventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory-service/v1")
@RequiredArgsConstructor
public class InventoryController {

	
	private final IInventoryService inventoryService;

	
//	http://localhost:8083/inventory-service/v1/inventories
	
	@PostMapping("/inventories")
	ResponseEntity<String> addStock(@RequestBody InventoryDto inventoryDto) {
		System.out.println(inventoryDto);
		String status = inventoryService.addStock(inventoryDto);
		return ResponseEntity.ok(status);
	}
	
//	http://localhost:8083/inventory-service/v1/inventories/stockupdate?productId=1&stock=100&type=a
		
	@GetMapping("/inventories/stockupdate")
	ResponseEntity<String> updateStock(@RequestParam int productId,@RequestParam int stock,@RequestParam String type) {
		String status = inventoryService.updateStock(productId, stock, type);
		return ResponseEntity.ok(status);
	}
	
//	http://localhost:8083/inventory-service/v1/inventories/productId/1
	
	@GetMapping("/inventories/productId/{productId}")
	ResponseEntity<Integer> checkStock(@PathVariable int productId) {
		int stock = inventoryService.checkStock(productId);
		return ResponseEntity.ok(stock);
	}

}

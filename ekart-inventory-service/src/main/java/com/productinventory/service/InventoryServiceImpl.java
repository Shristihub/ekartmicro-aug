package com.productinventory.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productinventory.exception.ProductIdNotFoundException;
import com.productinventory.model.Inventory;
import com.productinventory.model.InventoryDto;
import com.productinventory.repository.IInventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements IInventoryService {

	private final IInventoryRepository repository;
	private final ModelMapper mapper;

	@Override
	public String addStock(InventoryDto inventoryDto) {
		// convert dto to entity
		Inventory inventory = new Inventory(null, inventoryDto.getProductId(), inventoryDto.getStock());
		System.out.println(inventory);
		// save itin db
		repository.save(inventory);

		return "Stock added ";
	}

	@Override
	public String updateStock(int productId, int stock, String type) {
		// check if productId is available
		Optional<Inventory> optInventory = repository.findByProductId(productId);
		// check if opt has value
		if (optInventory.isEmpty())
			throw new ProductIdNotFoundException("productId not found");
		// get the inventory object
		Inventory inventory = optInventory.get();
		// get the stock
		int oldStock = inventory.getStock();

		// check if the stock had to be increased/decreased
		if (type.equals("a")) {
			// add the stock to the oldstock
			int newStock = oldStock + stock; // stock from the parameter
			inventory.setStock(newStock); // set the new stock
		} else {
			if (stock > oldStock) {
				inventory.setStock(oldStock);
			}
			// reduce the stock from the oldstock
			int reducedStock = oldStock - stock; // stock from the parameter
			inventory.setStock(reducedStock); // set the new stock
		}
		// save it in db
		repository.save(inventory);
		return "stock updated";
	}

	@Override
	public int checkStock(int productId) {
		// check if productId is available
		Optional<Inventory> optInventory = repository.findByProductId(productId);
		// check if opt has value
		if (optInventory.isEmpty())
			throw new ProductIdNotFoundException("productId not found");
		// get the inventory object
		Inventory inventory = optInventory.get();
		// get the stock
		int stock = inventory.getStock();
		return stock;
	}

}

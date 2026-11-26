package com.productinventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Entity
public class Inventory {

		@Id
		@GeneratedValue(generator = "inventory_gen", strategy = GenerationType.AUTO)
		@SequenceGenerator(name = "inventory_gen",sequenceName = "inventory_seq",initialValue = 50,allocationSize = 1)
		private Integer inventoryId;
		private int productId;
        private int stock;
        
}








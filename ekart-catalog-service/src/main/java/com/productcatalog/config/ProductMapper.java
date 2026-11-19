package com.productcatalog.config;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.productcatalog.dtos.BrandDto;
import com.productcatalog.dtos.CategoryDto;
import com.productcatalog.dtos.ProductDto;
import com.productcatalog.model.Brand;
import com.productcatalog.model.Category;
import com.productcatalog.model.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductMapper {

	// ModelMapper is autowired/injected
	private final ModelMapper mapper;

	// to Dto
	public ProductDto toProductDto(Product product) {
		return mapper.map(product, ProductDto.class);
	}

	public BrandDto toBrandDto(Brand brand) {
		return mapper.map(brand, BrandDto.class);
	}

	public CategoryDto toCategoryDto(Category category) {
		return mapper.map(category, CategoryDto.class);
	}

	// to entity
	public Product toProductEntity(ProductDto productDto) {
		return mapper.map(productDto, Product.class);
	}
	public Brand toBrandEntity(BrandDto brandDto) {
		return mapper.map(brandDto, Brand.class);
	}
	public Category toCategoryEntity(CategoryDto categoryDto) {
		return mapper.map(categoryDto, Category.class);
	}

}

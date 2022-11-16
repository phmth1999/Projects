package com.springmvc.converter;

import com.springmvc.dto.ProductDto;
import com.springmvc.entity.ProductEntity;

public class ProductConverter {
	public static ProductDto toDto(ProductEntity productEntity) throws Exception {
		ProductDto productDto = new ProductDto();
		try {
			productDto.setId(productEntity.getId());
			productDto.setId_productdetail(productEntity.getId_productdetail());
			productDto.setImg(productEntity.getImg());
			productDto.setName(productEntity.getName());
			productDto.setPrice(productEntity.getPrice());
			productDto.setQuantity(productEntity.getQuantity());
			productDto.setDate_create(productEntity.getDate_create());
			productDto.setDate_update(productEntity.getDate_update());
			productDto.setDate_delete(productEntity.getDate_delete());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDto;
	}
	public static ProductEntity toEntity(ProductDto productDto) throws Exception {
		ProductEntity productEntity = new ProductEntity();
		try {
			productEntity.setId_productdetail(productDto.getId_productdetail());
			productEntity.setImg(productDto.getImg());
			productEntity.setName(productDto.getName());
			productEntity.setPrice(productDto.getPrice());
			productEntity.setQuantity(productDto.getQuantity());
			productEntity.setDate_create(productDto.getDate_create());
			productEntity.setDate_update(productDto.getDate_update());
			productEntity.setDate_delete(productDto.getDate_delete());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productEntity;
	}
}

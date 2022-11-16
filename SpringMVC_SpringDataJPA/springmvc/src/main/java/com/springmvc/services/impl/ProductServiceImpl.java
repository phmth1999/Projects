package com.springmvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.converter.ProductConverter;
import com.springmvc.dto.ProductDto;
import com.springmvc.entity.ProductEntity;
import com.springmvc.repositories.IProductRepository;
import com.springmvc.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productRepository;

	@Override
	public List<ProductDto> findAll() throws Exception {
		List<ProductDto> listProductDto = new ArrayList<>();
		try {
			List<ProductEntity> listProductEntity = productRepository.findAll();
			for (ProductEntity productEntity : listProductEntity) {
				ProductDto productDto = ProductConverter.toDto(productEntity);
				listProductDto.add(productDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProductDto;
	}

}

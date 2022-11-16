package com.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.converter.ProductConverter;
import com.springboot.dto.ProductDto;
import com.springboot.entity.ProductEntity;
import com.springboot.repositories.IProductRepository;
import com.springboot.services.IProductService;

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

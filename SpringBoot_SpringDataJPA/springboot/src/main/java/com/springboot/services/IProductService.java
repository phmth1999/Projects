package com.springboot.services;

import java.util.List;

import com.springboot.dto.ProductDto;

public interface IProductService {
	List<ProductDto> findAll() throws Exception;
}

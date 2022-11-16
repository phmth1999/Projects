package com.springmvc.services;

import java.util.List;

import com.springmvc.dto.ProductDto;

public interface IProductService {
	List<ProductDto> findAll() throws Exception;
}

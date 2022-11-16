package com.springmvc.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dto.ProductDto;
import com.springmvc.dto.ResponseObject;
import com.springmvc.services.IProductService;

@CrossOrigin
@RestController
public class ProductApi {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/api/san-pham")
	ResponseEntity<ResponseObject> findAllProduct() throws Exception {
		ResponseEntity<ResponseObject> responseEntity = null;
		try {
			List<ProductDto> listProductDto = productService.findAll();
			if(listProductDto != null){
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", listProductDto));
			}else{
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot find product", listProductDto));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
}

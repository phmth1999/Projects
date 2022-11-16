package com.springmvc.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dto.ProductDto;
import com.springmvc.services.IProductService;

@Controller("webHome")
public class HomeController {
	@Autowired
	private IProductService productService;
	
	@GetMapping({ "/", "/trang-chu" })
	public ModelAndView Index() throws Exception {
		ModelAndView mav = new ModelAndView("web/home");
		try {
			List<ProductDto> listProductDto = productService.findAll();
			mav.addObject("listProductDto",listProductDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}

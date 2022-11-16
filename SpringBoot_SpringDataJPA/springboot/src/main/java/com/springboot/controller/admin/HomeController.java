package com.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("admin")
public class HomeController {
	
	@GetMapping("/quan-tri/trang-chu")
	public ModelAndView Index() throws Exception {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}

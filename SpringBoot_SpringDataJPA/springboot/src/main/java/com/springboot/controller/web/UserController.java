package com.springboot.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.dto.UserDto;

@Controller
public class UserController {
	@GetMapping({ "/dang-nhap" })
	public ModelAndView login(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = new ModelAndView("web/login");
		try {
			mav.addObject("user", new UserDto());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@GetMapping("/dang-xuat")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/trang-chu");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@GetMapping("/accessDenied")
	public ModelAndView accessDenied() throws Exception {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("redirect:/dang-nhap?accessDenied");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@GetMapping({ "/dang-ki" })
	public ModelAndView register(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = new ModelAndView("web/register");
		return mav;
	}
	@GetMapping({ "/quen-mat-khau" })
	public ModelAndView forgotPassword(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = new ModelAndView("web/forgotpassword");
		return mav;
	}
	@GetMapping({ "/xac-nhan" })
	public ModelAndView confirm(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = new ModelAndView("web/confirm");
		return mav;
	}
	@GetMapping({ "/cap-nhat-password" })
	public ModelAndView updatePassword(HttpServletRequest request, HttpSession httpSession) throws Exception {
		ModelAndView mav = new ModelAndView("web/updatepassword");
		return mav;
	}
}

package com.servlet.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.common.Constant;
import com.servlet.dao.impl.LoginDaoImpl;
import com.servlet.dto.LoginDto;

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher rd = req.getRequestDispatcher(Constant.LOGIN);
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("txtUserName");
		String password = req.getParameter("txtPassword");
		req.setAttribute("userName", userName);
		req.setAttribute("password", password);
		try {
			if (checkInput(userName, password,req) == false) {
				req.getRequestDispatcher(Constant.LOGIN).forward(req, resp);
			} else {
				LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
				int checkLogin = loginDaoImpl.selCheckLogin(userName, password);
				if (checkLogin == 1) {
					LoginDto loginDto = loginDaoImpl.selGetUserLogin(userName);
					HttpSession session = req.getSession();
					session.setAttribute("fullName", loginDto.getFullName());
					session.setAttribute("userId", loginDto.getUserId());
					resp.sendRedirect("search");
				} else {
					req.setAttribute("error", Constant.ERROR_LOGIN_FAIL);
					req.getRequestDispatcher(Constant.LOGIN).forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkInput(String userName, String password, HttpServletRequest req) throws Exception {
		boolean valid = false;
		try {
			if (userName == null || userName.isEmpty()) {
				valid = false;
				req.setAttribute("error", Constant.ERROR_LOGIN_USERNAME_REQUIRED);
			} else if (password == null || password.isEmpty()) {
				valid = false;
				req.setAttribute("error", Constant.ERROR_LOGIN_PASSWORD_REQUIRED);
			} else {
				valid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}
}

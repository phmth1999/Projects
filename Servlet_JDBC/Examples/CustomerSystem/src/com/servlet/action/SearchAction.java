package com.servlet.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.common.Constant;
import com.servlet.dao.impl.SearchDaoImpl;
import com.servlet.dto.SearchDto;

@SuppressWarnings("serial")
public class SearchAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int page = 1;
			int record = 10;
			if(req.getParameter("page")!=null){
				page = Integer.parseInt(req.getParameter("page"));
			}
			
			SearchDaoImpl searchDaoImpl = new SearchDaoImpl();
			ArrayList<SearchDto> listCustomer = searchDaoImpl.selListCustomer((page-1)*record, record);
			req.setAttribute("listCustomer", listCustomer);
			
			RequestDispatcher rd = req.getRequestDispatcher(Constant.SEARCH);
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SearchDaoImpl searchDaoImpl = new SearchDaoImpl();
			
			String clickSearch = req.getParameter("btnSearch");
			String clickFirst= req.getParameter("btnFirst");
			String clickPrevious = req.getParameter("btnPrevious");
			String clickNext = req.getParameter("btnNext");
			String clickLast = req.getParameter("btnLast");
			String clickDelete = req.getParameter("btnDelete");
			
			if(clickSearch!=null){
				
			}
			if(clickFirst!=null){
				
			}
			if(clickPrevious!=null){
				
			}
			if(clickNext!=null){
				
			}
			if(clickLast!=null){
				
			}
			if(clickDelete!=null){
				String[] listCheckBoxItem = req.getParameterValues("checkBoxItem");
				if(listCheckBoxItem!=null){
					for (int i = 0; i < listCheckBoxItem.length; i++) {
						searchDaoImpl.updCustomer(listCheckBoxItem[i]);
					}
					doGet(req, resp);
				}else{
					req.setAttribute("errorDelete", Constant.ERROR_SEARCH_DELETE);
					doGet(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

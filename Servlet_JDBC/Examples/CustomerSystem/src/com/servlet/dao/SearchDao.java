package com.servlet.dao;

import java.util.ArrayList;

import com.servlet.dto.SearchDto;

public interface SearchDao {
	public ArrayList<SearchDto> selListCustomer(int first, int last) throws Exception;

	public ArrayList<SearchDto> selListCustomerSearch(int first, int last, String customerName, String sex,
			String birthdayFrom, String birthdayTo) throws Exception;

	public int selCount(String customerName, String sex, String birthdayFrom, String birthdayTo)
			throws Exception;

	public void updCustomer(String customerId) throws Exception;
}

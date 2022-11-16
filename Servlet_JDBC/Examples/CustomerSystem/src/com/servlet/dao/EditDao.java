package com.servlet.dao;

import com.servlet.dto.EditDto;

public interface EditDao {
	public EditDto getCustomerById(int customerID) throws Exception;

	public void insCustomer(EditDto editDto) throws Exception;

	public void updCustomer(EditDto editDto) throws Exception;
}

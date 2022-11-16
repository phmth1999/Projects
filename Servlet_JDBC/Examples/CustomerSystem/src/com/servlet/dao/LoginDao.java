package com.servlet.dao;

import com.servlet.dto.LoginDto;

public interface LoginDao {
	public int selCheckLogin(String userName, String password) throws Exception;

	public LoginDto selGetUserLogin(String userName) throws Exception;
}

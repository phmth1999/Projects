package com.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.common.DBConnection;
import com.servlet.dao.LoginDao;
import com.servlet.dto.LoginDto;

public class LoginDaoImpl implements LoginDao {

	@Override
	public int selCheckLogin(String userName, String password) throws Exception {
		Connection conn = null;
		int ckeckLogin = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(*) as cnt from users where delete_user is null and user_name=? and password=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			ckeckLogin = resultSet.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return ckeckLogin;
	}

	@Override
	public LoginDto selGetUserLogin(String userName) throws Exception {
		Connection conn = null;
		LoginDto loginDto = new LoginDto();
		try {
			conn = DBConnection.getConnection();
			String sql = "select user_id, full_name from users where delete_user is null and user_name=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			loginDto.setUserId(resultSet.getInt("user_id"));
			loginDto.setFullName(resultSet.getString("full_name"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return loginDto;
	}
}

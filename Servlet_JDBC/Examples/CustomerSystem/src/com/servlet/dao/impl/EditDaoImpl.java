package com.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.common.DBConnection;
import com.servlet.common.Utils;
import com.servlet.dao.EditDao;
import com.servlet.dto.EditDto;

public class EditDaoImpl implements EditDao {

	@Override
	public EditDto getCustomerById(int customerId) throws Exception {
		Connection conn = null;
		EditDto editDto = new EditDto();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from customers where delete_customer is null and customer_id=? ";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			editDto.setCustomerId(customerId);
			editDto.setCustomerName(resultSet.getString("customer_name"));
			editDto.setSex(Utils.convert0ToMale(resultSet.getString("sex")));
			editDto.setBirthday(resultSet.getString("birthday"));
			editDto.setEmail(resultSet.getString("email"));
			editDto.setAddress(resultSet.getString("address"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return editDto;
	}

	@Override
	public void insCustomer(EditDto editDto) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into customers ('customer_name',"
					                         + "'sex',"
					                         + "'birthday',"
					                         + "'email',"
					                         + "'address',"
					                         + "'delete_customer',"
					                         + "'insert_customer',"
					                         + "'update_customer',"
					                         + "'user_id') "
					   + "values('?','?','?','?','?','?','?','?','?')";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, editDto.getCustomerName());
			preparedStatement.setString(2, Utils.convertMaleTo0(editDto.getSex()));
			preparedStatement.setString(3, editDto.getBirthday());
			preparedStatement.setString(4, editDto.getEmail());
			preparedStatement.setString(5, editDto.getAddress());
			preparedStatement.setString(6, null);
			preparedStatement.setString(7, Utils.getCurrentDateTime());
			preparedStatement.setString(8, null);
			preparedStatement.setInt(9, editDto.getUserId());
			preparedStatement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			DBConnection.getRollbackTransaction(conn);
			e.printStackTrace();
		} finally {
			DBConnection.getCloseDBConnection(conn);
		}
	}

	@Override
	public void updCustomer(EditDto editDto) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "update customers "
					   + "set customer_name=?, "
					       + "sex=?, "
					       + "birthday=?, "
					       + "email=?, "
					       + "address=?, "
					       + "delete_customer=?, "
					       + "insert_customer=?, "
					       + "update_customer=?, "
					       + "user_id=?  "
					   + "where customer_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, editDto.getCustomerName());
			preparedStatement.setString(2, Utils.convertMaleTo0(editDto.getSex()));
			preparedStatement.setString(3, editDto.getBirthday());
			preparedStatement.setString(4, editDto.getEmail());
			preparedStatement.setString(5, editDto.getAddress());
			preparedStatement.setString(6, null);
			preparedStatement.setString(7, Utils.getCurrentDateTime());
			preparedStatement.setString(8, null);
			preparedStatement.setInt(9, editDto.getUserId());
			preparedStatement.setInt(10, editDto.getCustomerId());
			preparedStatement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			DBConnection.getRollbackTransaction(conn);
			e.printStackTrace();
		} finally {
			DBConnection.getCloseDBConnection(conn);
		}
	}
}

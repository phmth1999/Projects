package com.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.servlet.common.DBConnection;
import com.servlet.common.Utils;
import com.servlet.dao.SearchDao;
import com.servlet.dto.SearchDto;

public class SearchDaoImpl implements SearchDao{

	@Override
	public ArrayList<SearchDto> selListCustomer(int first, int last) throws Exception {
		Connection conn = null;
		ArrayList<SearchDto> listCustomer = new ArrayList<SearchDto>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from customers where delete_customer is null order by customer_id limit ?,?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, first);
			preparedStatement.setInt(2, last);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SearchDto searchDto = new SearchDto();
				searchDto.setCustomerId(resultSet.getInt("customer_id"));
				searchDto.setCustomerName(resultSet.getString("customer_name"));
				searchDto.setSex(Utils.convert0ToMale(resultSet.getString("sex")));
				searchDto.setBirthday(resultSet.getString("birthday"));
				searchDto.setEmail(resultSet.getString("email"));
				searchDto.setAddress(resultSet.getString("address"));
				listCustomer.add(searchDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return listCustomer;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<SearchDto> selListCustomerSearch(int first, int last, String customerName, String sex,
			String birthdayFrom, String birthdayTo) throws Exception {
		Connection conn = null;
		ArrayList<SearchDto> listCustomer = new ArrayList<SearchDto>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from customers where delete_customer is null";
			if(customerName != null || !customerName.isEmpty()){
				sql = " and customer_name like '%"+customerName+"%'";
			}
			if(sex != null || !sex.isEmpty()){
				sql = " and sex='"+sex+"'";
			}
			if(birthdayFrom != null || !birthdayFrom.isEmpty()){
				sql = " and birthday>='"+birthdayFrom+"'";
			}
			if(birthdayTo != null || !birthdayTo.isEmpty()){
				sql = " and birthday<='"+birthdayTo+"'";
			}
			sql = " order by customer_id limit ?,?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, first);
			preparedStatement.setInt(2, last);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SearchDto searchDto = new SearchDto();
				searchDto.setCustomerId(resultSet.getInt("customer_id"));
				searchDto.setCustomerName(resultSet.getString("customer_name"));
				searchDto.setSex(Utils.convert0ToMale(resultSet.getString("sex")));
				searchDto.setBirthday(resultSet.getString("birthday"));
				searchDto.setEmail(resultSet.getString("email"));
				searchDto.setAddress(resultSet.getString("address"));
				listCustomer.add(searchDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return listCustomer;
	}

	@SuppressWarnings("null")
	@Override
	public int selCount(String customerName, String sex, String birthdayFrom, String birthdayTo)
			throws Exception {
		Connection conn = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(*) as count from customers where delete_customer is null";
			if(customerName != null || !customerName.isEmpty()){
				sql = " and customer_name like '%"+customerName+"%'";
			}
			if(sex != null || !sex.isEmpty()){
				sql = " and sex='"+sex+"'";
			}
			if(birthdayFrom != null || !birthdayFrom.isEmpty()){
				sql = " and birthday>='"+birthdayFrom+"'";
			}
			if(birthdayTo != null || !birthdayTo.isEmpty()){
				sql = " and birthday<='"+birthdayTo+"'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.getCloseDBConnection(conn);
		}
		return count;
	}

	@Override
	public void updCustomer(String customerId) throws Exception {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			String sql = "update customers "
					   + "set delete_customer=? "
					   + "where customer_id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, Utils.getCurrentDateTime());
			preparedStatement.setString(2, customerId);
			preparedStatement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			DBConnection.getRollbackTransaction(conn);
			e.printStackTrace();
		}finally {
			DBConnection.getCloseDBConnection(conn);
		}
	}
}

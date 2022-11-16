package com.servlet.dto;

import java.util.Date;

public class EditDto {
	private int customerId;
	private String customerName;
	private String sex;
	private String birthday;
	private String email;
	private String address;
	private Date deleteUser;
	private Date insertUser;
	private Date updateUser;
	private int userId;
	
	public EditDto(){
		
	}
	
	public EditDto(int customerId, String customerName, String sex, String birthday, String email, String address, Date deleteUser, Date insertUser, Date updateUser, int userId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.deleteUser = deleteUser;
		this.insertUser = insertUser;
		this.updateUser = updateUser;
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(Date deleteUser) {
		this.deleteUser = deleteUser;
	}

	public Date getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(Date insertUser) {
		this.insertUser = insertUser;
	}

	public Date getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Date updateUser) {
		this.updateUser = updateUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}

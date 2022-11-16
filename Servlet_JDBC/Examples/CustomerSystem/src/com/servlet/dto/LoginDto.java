package com.servlet.dto;

import java.util.Date;

public class LoginDto {
	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private Date deleteUser;
	private Date insertUser;
	private Date updateUser;
	
	public LoginDto(){
		
	}
	
	public LoginDto(int userId, String userName, String password, String fullName, Date deleteUser, Date insertUser, Date updateUser) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.deleteUser = deleteUser;
		this.insertUser = insertUser;
		this.updateUser = updateUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
}

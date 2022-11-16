package com.servlet.common;

public class Constant {

	public static final String LOGIN = "/WEB-INF/jsp/login.jsp";
	public static final String SEARCH = "/WEB-INF/jsp/search.jsp";
	public static final String EDIT = "/WEB-INF/jsp/edit.jsp";

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/customer_system";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin1234";

	public static final String ERROR_LOGIN_USERNAME_REQUIRED = "Username is required";
	public static final String ERROR_LOGIN_PASSWORD_REQUIRED = "Password is required";
	public static final String ERROR_LOGIN_FAIL = "Username or Password not correct";
	
	public static final String ERROR_SEARCH_VALID_BIRTHDAYFROM = "BirthdayFrom not valid";
	public static final String ERROR_SEARCH_VALID_BIRTHDAYTO = "BirthdayTo not valid";
	public static final String ERROR_SEARCH_COMPARETO_BIRTHDAY = "BirthdayFrom larger than BirthdayTo";
	public static final String ERROR_SEARCH_DELETE = "Please select customerId";
	
	public static final String REGEX_BIRTHDAY = "^(?:\\d{4}\\/(?:(?:(?:(?:0[13578]|1[02])\\/(?:0[1-9]|[1-2][0-9]|3[01]))|(?:(?:0[469]|11)\\/(?:0[1-9]|[1-2][0-9]|30))|(?:02\\/(?:0[1-9]|1[0-9]|2[0-8]))))|(?:(?:\\d{2}(?:0[48]|[2468][048]|[13579][26]))|(?:(?:[02468][048])|[13579][26])00)\\/02\\/29)$";
}

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.servlet.dto.LoginDto" %>
<%@ page import="com.servlet.dto.SearchDto" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search</title>

<style><%@include file="/WEB-INF/css/search.css" %></style>

<script><%@include file="/WEB-INF/js/search.js" %></script>

</head>
<body class="class-body">
	<h1 class="class-training-h1">Traning</h1>

	<p class="class-login-p">Login > Search</p>

	<p class="class-blue">&nbsp;&nbsp;&nbsp;&nbsp;</p>
	
	<p class="class-fullName"> Welcome <%=session.getAttribute("fullName").toString() %> </p>

	<a href="login" class="class-logout">Logout</a>

	<form class="class-form-search" action="search" method="post">
	<div class="class-name">
	<label>Customer name</label>
	<input id="txtCustomerName" name="txtCustomerName">
	</div>

	<div class="class-sex">
	<label>Sex</label>
	<select name="slSex" id="slSex">
  		<option value=""></option>
 		 <option value="Male">Male</option>
 		 <option value="Female">Female</option>
	</select>
	</div>

	<div class="class-birthday">
	<label>Birthday</label>
	<input id="txtBirthdayForm" name="txtBirthdayForm">
	~
	<input id="txtBirthdayTo" name="txtBirthdayTo">
	</div>

	<div class="class-btnSearch">
	<button type="submit" id="btnSearch" name="btnSearch">Search</button>
	</div>
	</form>
	
	<form class="class-form-pagination" action="search" method="post">
	<div class="class-Previous">
	<button id="btnFirst" name="btnFirst"><%="<<"%></button>
	<button id="btnPrevious" name="btnPrevious"><%="<"%></button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	Previous
	</div>
	
	<div class="class-next">
	Next
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="btnNext" name="btnNext">></button>
	<button id="btnLast" name="btnLast">>></button>
	</div>
	</form>
	
	<form  action="search" method="post" onsubmit="return ClickDelete()">
	<div class="class-form-table">
	<table class="class-table" width="100%">
	<tr class="class-table-titile">
		<td class="class-table-checkAll"><input id="checkAll" name="checkAll" type="checkbox" onclick="ClickCheckAll(this)"></td>
		<td class="class-table-customerId">Customer Id</td>
		<td class="class-table-customerName">Customer name</td>
		<td class="class-table-sex">Sex</td>
		<td class="class-table-birthday">Birthday</td>
		<td class="class-table-email">Email</td>
		<td class="class-table-address">Address</td>
	</tr>
	<%
	int count =0;
	@SuppressWarnings("unchecked")
	ArrayList<SearchDto> listCustomer = (ArrayList<SearchDto>)request.getAttribute("listCustomer");
	for(SearchDto searchDto : listCustomer){ 
	count++;
	%>
	<%if(count%2==0){ %>
	<tr class="class-table-item">
	<%} %>
		<td class="class-table-checkAll"><input id="checkBoxItem" name="checkBoxItem" type="checkbox" value="<%=searchDto.getCustomerId() %>"></td>
		<td class="class-table-customerId"><%=searchDto.getCustomerId() %></td>
		<td class="class-table-customerName"><%=searchDto.getCustomerName() %></td>
		<td class="class-table-sex"><%=searchDto.getSex() %></td>
		<td class="class-table-birthday"><%=searchDto.getBirthday() %></td>
		<td class="class-table-email"><%=searchDto.getEmail() %></td>
		<td class="class-table-address"><%=searchDto.getAddress() %></td>
	</tr>
	<%} %>
	</table>
	</div>

	<div class="class-button">
	<button class="class-button-col-2">Add New</button>
	<button class="class-button-col-2" type="submit" id="btnDelete" name="btnDelete">Delete</button>
	</div>
	</form>

	<div class="class-footer"> Copyright ©2022 Web Customer System Servlet. </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit</title>

<style><%@include file="/WEB-INF/css/edit.css" %></style>

<script><%@include file="/WEB-INF/js/edit.js" %></script>

</head>
<body class="class-body" >

	<h1 class="class-training-h1">Traning</h1>
	
	<p class="class-login-p">Login > Search > Edit</p>
	
	<p class="class-fullName">Welcome ABC</p>

	<a href="login" class="class-logout">Logout</a>

	<form class="class-form-edit" action="">
	
	<label class="class-label-error" id="lblMessage"></label>

	<div class="class-col-6">
	<label class="class-label">User Id:</label>
	<p><label class="class-input" id="txtUserId"></label></p>
	</div>
	
	<div class="class-col-6">
	<label class="class-label">Customer name:</label>
	<input class="class-input" id="txtCustomerName" name="txtCustomerName" maxlength="8" type="text" >
	</div>
	
	 <div class="class-col-6">
	<label class="class-label">Sex:</label>
	<select  name="slSex" id="slSex">
  		<option  value=""></option>
  		<option  value="Male">Male</option>
  		<option  value="Female">Female</option>
	</select>
	</div> 
	
	 <div class="class-col-6">
	<label class="class-label">Birthday:</label>
	<input class="class-input" id="txtBirthday" name="txtBirthday" maxlength="10" type="text">
	</div>
	
	 <div class="class-col-6">
	<label class="class-label">Email:</label>
	<input class="class-input" id="txtEmail" name="txtEmail" type="text">
	</div> 

	 <div class="class-col-6">
	<label class="class-label">Address:</label>
	<textarea class="class-input" id="txtAddress" name="txtAddress"  rows="3"></textarea>
	</div> 

	<div class="class-button">
	<button class="class-button-col-2" id="btnSave" name="btnSave" type="submit">Save</button>
	<button class="class-button-col-2" onclick="ClickClear()">Clear</button>
	</div>
	</form>

	<div class="class-footer"> Copyright ©2022 Web Customer System Servlet. </div>

</body>
</html>
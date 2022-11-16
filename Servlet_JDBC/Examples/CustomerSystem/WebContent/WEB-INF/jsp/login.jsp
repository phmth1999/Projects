<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>

<style><%@include file="/WEB-INF/css/login.css" %></style>

<script><%@include file="/WEB-INF/js/login.js" %></script>

</head>
<body class="class-body" >

	<h1 class="class-training-h1">Traning</h1>

	<p class="class-login-p">Login</p>

	<form class="class-form-login" action="login" method="post">
	
	<h1 class="class-login-h1">LOGIN</h1>
	
	<div class="class-label-error">
	<label  id="lblMessage" >${error }</label>
	</div>

	<div class="class-col-2">
	<label class="class-label">User Id:</label>
	<input class="class-input" id="txtUserName" name="txtUserName" maxlength="8" type="text" value="${userName }">
	</div>

	<div class="class-col-2">
	<label class="class-label">Password:</label>
	<input class="class-input" id="txtPassword" name="txtPassword" maxlength="8" type="password" value="${password }">
	</div>
	
	<div class="class-button">
	<button class="class-button-col-2" id="btnLogin" name="btnLogin" type="submit">Login</button>
	<button class="class-button-col-2" onclick="ClickClear()" type="button">Clear</button>
	</div>
	</form>

	<div class="class-footer"> Copyright ©2022 Web Customer System Servlet. </div>

</body>
</html>
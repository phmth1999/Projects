<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page import="com.springboot.security.CustomSuccesHandler"%>
<header class="header">
	<div class="logo">
		<img src='<c:url value="template/web/images/logo.jpg" />' alt="">
	</div>
	<div class="search">
		<input type="text" placeholder="Tìm kiếm ...">
		<button>
			<i class="fa-solid fa-magnifying-glass"></i>
		</button>
	</div>
	<div class="login-register">
		<security:authorize access="isAnonymous()">
			<a href='<c:url value="/dang-nhap" />'>Đăng nhập</a>
			<p>|</p>
			<a href='<c:url value="/dang-ki" />'>Đăng kí</a>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<p><%=CustomSuccesHandler.getPrincipal().getFullName()%></p>
			<p>|</p>
			<a href='<c:url value="/dang-xuat" />'>Đăng xuất</a>
		</security:authorize>
	</div>
</header>
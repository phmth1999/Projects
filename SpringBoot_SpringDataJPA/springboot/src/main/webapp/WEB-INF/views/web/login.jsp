<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập</title>
<link href="<c:url value="/template/web/css/style.css"/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />
</head>
<body>
	<div id="wrapper">
		<%@include file="/WEB-INF/views/web/template/header.jsp"%>
		<div class="container">
			<div class="row justify-center">
				<form:form id="form-login" action="j_spring_security_check" method="post" modelAttribute="user">
					<h2>Đăng nhập</h2>
					<div class="messege">
						<c:if test="${param.incorrectAccount != null }">
						Username or password incorrect
					</c:if>
						<c:if test="${param.accessDenied != null }">
						You not authorize
					</c:if>
					</div>
					<div class="group-input">
						<label for="username">Tên đăng nhập *:</label>
						<form:input id="username" path="username" placeholder="Nhập tên đăng nhập" maxlength="50" />
					</div>
					<div class="group-input">
						<label for="password">Mật khẩu *:</label>
						<form:password id="password" path="password" placeholder="Nhập mật khẩu" maxlength="8" />
					</div>
					<div class="btn">
						<button type="submit">Đăng nhập</button>
					</div>
					<div class="link">
						<a href='<c:url value="/dang-ki" />'>Đăng kí</a>
						<p>|</p>
						<a href='<c:url value="/quen-mat-khau" />'>Quên mật khẩu</a>
					</div>
				</form:form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/web/template/footer.jsp"%>
	</div>
</body>
</html>
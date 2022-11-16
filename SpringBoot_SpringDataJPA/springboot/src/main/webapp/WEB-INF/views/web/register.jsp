<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng kí</title>
<link href="<c:url value="/template/web/css/style.css"/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />
</head>
<body>
	<div id="wrapper">
		<%@include file="/WEB-INF/views/web/template/header.jsp"%>
		<div class="container">
			<div class="row justify-center">
				<form id="form-register" action="" method="post">
					<h2>Đăng kí</h2>
					<div class="col">
						<div class="group-input">
							<label for="username">Tên đăng nhập *:</label> 
							<input id="username" name="username" type="text" placeholder="Vd: admin123" maxlength="20">
						</div>
						<div class="group-input">
							<label for="password">Mật khẩu *:</label> 
							<input id="password" name="password" type="password" placeholder="Vd: Admin123" maxlength="8">
						</div>
						<div class="group-input">
							<label for="fullname">Họ và tên *:</label> 
							<input id="fullname" name="fullname" type="text" placeholder="vd: Phạm Minh Thiện" maxlength="50">
						</div>
						<div class="group-input">
							<label for="email">Email *:</label> 
							<input id="email" name="email" type="email" placeholder="vd: phmth1999@gmail.com" maxlength="50">
						</div>
						<div class="group-input">
							<label for="sdt">SĐT *:</label> <input id="sdt" name="sdt"
								type="text" placeholder="vd: 0378348419" maxlength="10">
						</div>
						<div class="group-input">
							<label for="address">Địa chỉ *:</label> <input id="address"
								name="address" type="text"
								placeholder="vd: Cai Lậy, Tiền Giang, HCM" maxlength="255">
						</div>
					</div>
					<div class="btn">
						<button type="submit">Đăng kí</button>
					</div>
					<div class="link">
						<a href='<c:url value="/dang-nhap" />'>Đăng nhập</a>
						<p>|</p>
						<a href='<c:url value="/quen-mat-khau" />'>Quên mật khẩu</a>
					</div>
				</form>
			</div>
		</div>
		<%@include file="/WEB-INF/views/web/template/footer.jsp"%>
	</div>
</body>
</html>
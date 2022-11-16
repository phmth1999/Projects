<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title default="Master-layout" /></title>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link href="<c:url value="/template/web/css/style.css"/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />

<decorator:head />

</head>
<body>
	<div id="wrapper">
		<%@include file="/WEB-INF/decorators/web/header.jsp"%>

		<decorator:body />

		<%@include file="/WEB-INF/decorators/web/footer.jsp"%>
	</div>

	<script src="<c:url value="/template/web/js/app.js" />"></script>
</body>
</html>
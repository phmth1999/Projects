<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><decorator:title default="Admin" /></title>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link href="<c:url value="/template/admin/css/style.css"/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" />

<decorator:head />

</head>
<body class="no-skin">
		<%@include file="/WEB-INF/decorators/admin/header.jsp"%>

		<decorator:body />
		
		<%@include file="/WEB-INF/decorators/admin/footer.jsp"%>
		
		<script src="<c:url value="/template/admin/js/app.js" />"></script>
</body>
</html>
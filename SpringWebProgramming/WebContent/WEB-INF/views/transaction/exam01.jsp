<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>Home</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<h4>계좌 이체</h4>
	<form method="post">
		출금 계좌 : <input type="text"name="fromAno"/><br/>
		입금 계쫘 : <input type="text"name="toAno"/><br/>
		이체 금액 : <input type="number"name="amount"min="1"/><br/>
		<input type="submit"value="이체"class="btn btn-info"/>
	</form>
</body>
</html>
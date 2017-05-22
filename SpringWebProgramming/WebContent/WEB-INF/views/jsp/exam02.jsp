<%--
[지시자]
1. 작성: <%@ ... %>
2. 종류
	 <%@page ... %> : JSP가 무엇을 만들어 내느냐
	 <%@include ... %> : 외부 파일을 가져와서 포함시킨다/.
	 <%@taglib ... %>

--%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
      <meta charset="UTF-8">
			<meta name= viewport content="width=device-width initial-scale=1 user-scalable=no">
			<title>JSP Page</title>
			<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
			<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
			<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
	 </head>
	 <body>
			<h1>패키지 클래스 사용</h1>
			<%@include file="exam02_include.jsp" %>
	 </body>
</html>

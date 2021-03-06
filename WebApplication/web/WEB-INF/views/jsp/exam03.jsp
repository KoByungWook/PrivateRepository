<%--
[지시자]
1. 작성: <%@ ... %>
2. 종류
	 <%@page ... %> : JSP가 무엇을 만들어 내느냐
	 <%@include ... %> : 외부 파일을 가져와서 포함시킨다/.
	 <%@taglib ... %> : JSP에서 추가적으로 사용할 수 있는 커스텀 태그 로딩

--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>					<%--c가 붙는 태그들을 추가적으로 사용할 수 있음--%>
<!DOCTYPE html>
<html>
	 <head>
      <meta charset=UTF-8">
			<meta name= viewport content="width=device-width initial-scale=1 user-scalable=no">
			<title>JSP Page</title>
			<link href="/WebApplication/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
			<script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
			<script src="/WebApplication/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
	 </head>
	 <body>
			<h4>JSTL(Java Standard Tag Library) 사용하기</h4>
			<%for(int i=1;i<5;i++){%>
				 <img src="/WebApplication/resources/images/member0<%=i%>.png" width="50px" height="50px">
			<%}%><br/>
			
			<c:forEach begin="1" end="5" step="1" varStatus="status">
				 <img src="/WebApplication/resources/images/member0$(status.count).png" width="50px" height="50px">
			</c:forEach>
	 </body>
</html>

<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
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
	WebApplication Home
	<hr />
	<h4>html 태그</h4>
	<a href="html/exam01" class="btn btn-warning">exam01</a>

	<h4>CSS</h4>
	<a href="css/exam01" class="btn btn-success">exam01</a>
	<a href="css/exam02" class="btn btn-success">exam02</a>
	<a href="css/exam03" class="btn btn-success">exam03</a>

	<h4>JavaScript</h4>
	<%for(int i=1;i<=11;i++){
				 String exam = "exam" ;
				 if(i<10) {
						 exam += "0" + i;
				 }
				 else {
						 exam += String.valueOf(i);
				 }%>
	<a href="javascript/<%=exam%>" class="btn btn-primary"><%=exam%></a>
	<%}%>

	<h4>Jquery</h4>
	<%for(int i=1;i<=4;i++){
				 String exam = "exam";
				 if(i<10) {
						 exam += "0" + i;
				 }
				 else {
						 exam += String.valueOf(i);
				 }%>
	<a href="jquery/<%=exam%>" class="btn btn-primary"><%=exam%></a>
	<%}%>

	<h4>BootStrap</h4>
	<%for(int i=1;i<=3;i++){
					String exam = "exam";
					if(i<10) {
							exam += "0" +i;
					} else {
							exam += String.valueOf(i);
					}%>
	<a href="bootstrap/<%=exam%>" class="btn btn-primary"><%=exam%></a>
	<%}%>

	<h4>JSP</h4>
	<%for(int i=1;i<=5;i++){
					String exam = "exam";
					if(i<10) {
							exam += "0" +i;
					} else {
							exam += String.valueOf(i);
					}%>
	<a href="jsp/<%=exam%>" class="btn btn-primary"><%=exam%></a>
	<%}%>

	<h4>HTTP</h4>
	<h5>요청방식</h5>
	1) GET 방식:
	<a href="http/exam01" class="btn btn-primary">exam01</a>
	<br /> 2) POST 방식:
	<form method="post" action="http/exam01" style="display: inline">
		<input type="submit" value="exam01" class="btn btn-primary" />
	</form>

	<h4>요청 HTTP 정보 얻기</h4>
	<a href="http/exam02?type=freeboard&bno=5&hobby=baseball&hobby=soccer"
		class="btn btn-primary">exam02</a>
	<a href="http/exam03?type=freeboard&bno=5&hobby=baseball&hobby=soccer"
		class="btn btn-primary">exam03</a>

	<h4>폼 제출</h4>
	<a href="form/exam01" class="btn btn-primary">회원가입 양식 요청</a>

	<h4>파일 업로드</h4>
	<a href="form/exam02" class="btn btn-primary">회원가입 양식 요청</a>

	<h4>파일 다운로드</h4>
	<a href="file/exam03" class="btn btn-primary">파일로 저장</a>
	<img src="file/exam03" width="100px" height="100px" />

	<h4>의존성 주입</h4>
	<a href="di/exam01" class="btn btn-primary">회원 가입</a>
	<a href="di/exam02" class="btn btn-primary">로그인</a>

	<h4>redirect</h4>
	<a href="redirect/write" class="btn btn-primary">게시물 목록</a>
	<a href="redirect/list" class="btn btn-primary">게시물 쓰기</a>
	
	<h4>상태유지</h4>
	<a href="cookie/exam01" class="btn btn-primary">클라이언트 쿠키 저장</a>
	<a href="cookie/exam02" class="btn btn-primary">클라이언트 쿠키 읽기</a>
	<a href="cookie/exam03" class="btn btn-primary">클라이언트 쿠키 제거</a>
	<a href="session/exam04" class="btn btn-primary">서버 세션에 저장</a>
	<a href="session/exam05" class="btn btn-primary">서버 세션에서 읽기</a>
	<a href="session/exam06" class="btn btn-primary">서버 세션에서 제거</a>
	
	<h4>JDBC</h4>
	<a href="jdbc/exam01" class="btn btn-primary">글 쓰기</a>
	<a href="jdbc/exam02" class="btn btn-primary">글 쓰기</a>
	<a href="jdbc/exam03" class="btn btn-primary">회원가입하기</a>
	<a href="jdbc/exam04" class="btn btn-primary">게시물 목록</a>
	<a href="jdbc/exam05" class="btn btn-primary">게시물 페이지 목록</a>
	<a href="jdbc/exam06" class="btn btn-primary">회원 페이지 목록</a>
	
	<h4>AOP</h4>
	<a href="jdbc/exam05" class="btn btn-primary">실행 시간 체크</a>
	<a href="aop/exam01" class="btn btn-primary">로그인 없이 볼 수 있는 내용</a>
	<a href="aop/exam02write" class="btn btn-primary">로그인해야 볼 수 있는 내용</a>
	<a href="aop/exam02update" class="btn btn-primary">로그인해야 볼 수 있는 내용</a>
	
	<h4>transaction</h4>
	<a href="transaction/exam01" class="btn btn-primary">계좌 이체 테스트</a>
</body>
</html>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name=viewport
	content="width=device-width initial-scale=1 user-scalable=no">
<title>Home</title>
<link rel='stylesheet' href='http://fonts.googleapis.com/earlyaccess/nanumpenscript.css'>
<link rel='stylesheet' href='http://fonts.googleapis.com/earlyaccess/nanumgothic.css'>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript"></script>
<style type="text/css">
	.layer {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%)
	}
	.container {
		height: 70px;
		text-align: center;
		vertical-align: middle;
		display: table-cell;
	}
	.block {
		display: inline-block;
	}
</style>
</head>
<body>
	<div class="layer" style="font-family: 'Nanum Gothic', serif;">
	
		<div style="width:700px;text-align:right;margin:0px 0px 10px 0px;font-size:small">
		
			<div style="float:right;margin:0px 0px 0px 5px">
				<img src="mainMemberImage"style="width:70px;height:70px"/>
			</div>
			
			<div style="float:right;padding:10px 0px 0px 0px;">
				<div>
					ID : ${member.mid}
				</div>
				<div >
					이름 : ${member.mname}
				</div>
				<div>
					<a href="memberDetail"class="btn"style="font-size:small;padding:0px 0px 0px 0px;">회원정보</a>
					<a href="logOut"class="btn"style="font-size:small;padding:0px 0px 0px 0px;">로그아웃</a>
				</div>
			</div>
			
			<div class="container">
				<div class="block"style="font-size:52px;font-family: 'Nanum Pen Script', serif;">
					사진 게시판
				</div>
			</div>
			
		</div>
		
		<table class="table table-bordered" style="padding:auto;margin-bottom:10px;text-align:center;">
			<tr class="success">
				<td>번호</td>
				<td>미리보기</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>날짜</td>
				<td>조회수 </td>
			</tr>
			<c:forEach var="b" items="${list}">
				<tr>
					<td style="vertical-align:middle">${b.bno}</td>
					<td style="vertical-align:middle">
						<img src="photoThumbnail?bno=${b.bno}"style="width:70px;">
					</td>
					<td style="vertical-align:middle">
						<a href="photoDetail?pageNo=${pageNo}&bno=${b.bno}">${b.btitle}</a>
					</td>
					<td style="vertical-align:middle">${b.bid}</td>
					<td style="vertical-align:middle">${b.bdate}</td>
					<td style="vertical-align:middle">${b.bhitcount}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div style="text-align:right;margin:0px">
			<a href="photoUpLoad"class="btn btn-success">사진 업로드</a>
		</div>
		
		
		<div style="text-align:center">
			<a href="mainBoard?pageNo=1">[처음]</a>
			
			<c:if test="${groupNo>1}">
				<a href="mainBoard?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp;
				<a href="mainBoard?pageNo=${i}"<c:if test="${pageNo==i}">style="font-weight:bold; color:red"</c:if>>${i}</a>
				&nbsp;
			</c:forEach>
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="mainBoard?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			
			<a href="mainBoard?pageNo=${totalPageNo}">[맨끝]</a>
		</div>

	</div>
</body>
</html>
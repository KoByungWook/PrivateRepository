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
	.layer{
	  position:absolute;
	  top:40%;
	  left:50%;
	  transform:translate(-50%, -50%)
	}
</style>	
</head>
<body>
	<form class="layer"method="post" enctype="multipart/form-data"style="width:500px;">
		<h4>사진 업로드</h4>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</span>
				<input type="text"class="form-control"placeholder="아이디" name="bid"value="${member.mid}"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-pencil"></span>
				</span>
				<input type="text"class="form-control"placeholder="제목" name="btitle"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-leaf"></span>
				</span> <textarea rows="5" cols="30" class="form-control" placeholder="내용" name="bcontent"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-camera"></span>
				</span>
				<input type="file"class="form-control"placeholder="선택" name="battach"style="height:40px"/>
			</div>
		</div>
		<div style="text-align:center">
			<input type="submit"class="btn btn-info"value="글쓰기"/>
			<a href="mainBoard" class="btn btn-warning">취소</a>
		</div>
	</form>
</body>
</html>
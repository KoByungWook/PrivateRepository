<%@page contentType="text/html; charset=UTF-8"%>
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
	<form class="layer"method="post" enctype="multipart/form-data" style="width:500px;font-family: 'Nanum Gothic', serif;">
		<h4>회원 가입 양식</h4>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-qrcode"></span>
				</span>
				<input type="text"class="form-control"placeholder="아이디" name="mid"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</span>
				<input type="password"class="form-control"placeholder="비밀번호" name="mpassword"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</span>
				<input type="text"class="form-control"placeholder="이름" name="mname"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-leaf"></span>
				</span>
				<input type="number"class="form-control"placeholder="나이" name="mage"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-camera"></span>
				</span>
				<input type="file"class="form-control"placeholder="선택" name="mattach"style="height:40px"/>
			</div>
		</div>
		<div style="text-align:right">
			<input type="submit"class="btn btn-info"value="작성 완료"/>
			<a href="home" class="btn btn-warning">취소</a>
		</div>
	</form>
</body>
</html>
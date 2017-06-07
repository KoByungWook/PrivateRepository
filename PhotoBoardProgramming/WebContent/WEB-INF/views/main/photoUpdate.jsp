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
	<form class="layer"method="post"enctype="multipart/form-data"style="width:500px;font-family: 'Nanum Gothic', serif;">
		<h4>사진 게시물 수정</h4>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-tags"></span>
				</span>
				<input type="number"class="form-control"placeholder="번호" name="bno"value="${board.bno}"style="height:40px;"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-qrcode"></span>
				</span>
				<input type="text"class="form-control"placeholder="아이디" name="bid"value="${board.bid}"style="height:40px;"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-text-size"></span>
				</span>
				<input type="text"class="form-control"placeholder="제목" name="btitle"value="${board.btitle}"style="height:40px;"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-file"></span>
				</span> <textarea rows="5" cols="30" class="form-control" placeholder="내용" name="bcontent">${board.bcontent}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-picture"></span>
				</span>
				<input type="file"class="form-control"placeholder="선택" name="battach"style="height:40px;"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<input type="submit"class="btn btn-info"value="올리기"/>
				<a href="photoDetail?pageNo=${pageNo}&bno=${board.bno}" class="btn btn-warning">취소</a>
			</div>
		</div>
	</form>
</body>
</html>
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
<script type="text/javascript">
	function handleBtnUpdate() {
		var bid = $("#bid").val();
		$.ajax({
			url : "checkBid",
			method : "post",
			data : {
				"bno":"${board.bno}",
				"bid":bid
			},
			success : function(data) {
				if (data.result == "success") {
					location.href = "photoUpdate?pageNo=${pageNo}&bno=${board.bno}"
				} else {
					
				}
			}
		});
	}
	function handleBtnDelete() {
		var bid = $("#bid").val();
		$.ajax({
			url : "checkBid",
			method : "post",
			data : {
				"bno":"${board.bno}",
				"bid":bid
			},
			success : function(data) {
				if (data.result == "success") {
					location.href = "photoDelete?bno=${board.bno}"
				} else {
					
				}
			}
		});
	}
</script>
<style type="text/css">
	.layer{
	  position:absolute;
	  left:50%;
	  transform:translate(-50%, 0%)
	}
</style>
</head>
<body>
	<form class="layer"method="post"enctype="multipart/form-data"style="width:500px;font-family: 'Nanum Gothic', serif;">
		<h4>사진 업로드</h4>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-tags"></span>
				</span>
				<input id="bno"type="number"class="form-control"placeholder="번호" name="bno"value="${board.bno}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-qrcode"></span>
				</span>
				<input id="bid"type="text"class="form-control"placeholder="아이디" name="bid"value="${board.bid}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-text-size"></span>
				</span>
				<input type="text"class="form-control"placeholder="제목" name="btitle"value="${board.btitle}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-file"></span>
				</span> <textarea rows="5" cols="30" class="form-control" placeholder="내용" name="bcontent"disabled>${board.bcontent}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-picture"></span>
				</span>
				<div style="padding:10px;text-align:center">
					<img src="photoImageDetail?bno=${board.bno}"style="width:440px"/>
				</div>
			</div>
		</div>
		<div style="float:left">
			<a href="photoImageDetail?bno=${board.bno}" class="btn btn-info">사진 다운로드</a>
		</div>
		<div style="text-align:Right">
			<a href="mainBoard?pageNo=${pageNo}" class="btn btn-info">목록</a>
			<input onclick="handleBtnUpdate()" type="button" class="btn btn-warning" value="수정" /> 
			<input onclick="handleBtnDelete()" type="button" class="btn btn-danger" value="삭제" />
		</div>
	</form>
</body>
</html>
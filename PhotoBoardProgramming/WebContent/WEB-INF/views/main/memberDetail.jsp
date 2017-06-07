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
<script type="text/javascript">
	function handleBtnChangeInfo() {
		var mpassword = $("#mpassword").val();
		console.log(mpassword);
		if(mpassword == null) {
			return;
		}
		$.ajax({
			url : "checkMid",
			method : "post",
			data : {
				"mpassword":mpassword
			},
			success : function(data) {
				if (data.result == "success") {
					location.href = "memberUpdate?mid=${member.mid}"
				} else {
					
				}
			}
		});
	}
</script>
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
		<h4>회원 정보</h4>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-qrcode"></span>
				</span>
				<input id="mid"type="text"class="form-control"placeholder="아이디" name="mid"value="${member.mid}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</span>
				<input id="mpassword"type="password"class="form-control"placeholder="비밀번호" name="mpassword"style="height:40px"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</span>
				<input type="text"class="form-control"placeholder="이름" name="mname"value="${member.mname}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-leaf"></span>
				</span>
				<input type="number"class="form-control"placeholder="나이" name="mage"value="${member.mage}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
				<input type="date"class="form-control"placeholder="가입날짜" name="mdate"value="${member.mdate}"style="height:40px"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="glyphicon glyphicon-camera"></span>
				</span>
				<input type="text"class="form-control"placeholder="현재 파일"name="moriginalfilename"value="${member.moriginalfilename}"style="height:40px"disabled/>
			</div>
		</div>
		<div style="text-align:center">
			<input onclick="handleBtnChangeInfo()"type="button"class="btn btn-info"value="회원정보 수정"/>
			<a href="mainBoard" class="btn btn-info">메인</a>
		</div>
	</form>
</body>
</html>
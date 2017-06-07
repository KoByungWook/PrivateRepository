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

<script type="text/javascript">
	function handleBtnLogin() {
		var mid = $("#mid").val();
		var mpassword = $("#mpassword").val();
		if(mid == "" || mpassword == "") {
			return;
		}
		
		$.ajax({
			url : "checkLogin",
			method : "post",
			data : {"mid" : mid, "mpassword" : mpassword},
			success : function(data) {
				if (data.result == "success") {
					location.href = "main/mainBoard?mid=" + mid
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
	<div class="layer"style="text-align:center">
		<div style="margin:0px 0px 20px 0px">
			<img alt=""src="<%=application.getContextPath()%>/resources/images/background.png"style="width:400px;height:120px">
		</div>
		
		<div style="display:inline-block;margin-left:3px">
			<div class="input-group"style="width:300px;">
				<span class="input-group-addon"style="width:100px;">아이디</span>
				<input id="mid"type="text"class="form-control"placeholder="아이디" name="mid"/>
			</div>
		</div>
		<br/>
		<div style="display:inline-block">
			<div class="input-group"style="width:300px">
				<span class="input-group-addon"style="width:100px;">비밀번호</span>
				<input id="mpassword"type="password"class="form-control"placeholder="비밀번호"name="mpassword"/>
			</div>
		</div>
		
		<div style="margin:10px 0px 0px 0px">
			<input onclick="handleBtnLogin()"type="button"class="btn btn-primary"value="로그인"/>
			<a href="join"class="btn btn-primary">회원가입</a>
		</div>
	</div>
</body>
</html>
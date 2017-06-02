<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
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
		function filechange() {
			if($("#mattach")[0].files.legnth != 0) {
				var originalfilename = $("#mattach")[0].files[0].name;
				$("#spanFileName").text(originalfilename)
			}
		}
	</script>
</head>

<body>
	<h4>게시물 쓰기</h4>
	<hr />

	<form method="post" style="padding: 0px 20px 0px 20px"
		enctype="multipart/form-data">
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="아이디" name="mid"
					value="${member.mid}"disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="text" class="form-control" placeholder="이름"
					name="mname" value="${member.mname}"disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="number" class="form-control" placeholder="나이"
					name="mage" value="${member.mage}"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="date" class="form-control" placeholder="가입날짜"
					name="mdate" value="${member.mdate}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="전화번호"
					name="mtel" value="${member.mtel}"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="주소"
					name="maddress" value="${member.maddress}"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group" style="height: 47px;">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> 
				<div class="form-control" style="height: 47px;">
				<span id="spanFileName">${member.moriginalfilename}</span>
				<label for="mattach"class="btn btn-default">변경</label>
				<input id="mattach"type="file" name="mattach" style="visibility:hidden" onchange="fileChange()"/>
			
				</div>
			</div>
		</div>
		
		<input type="submit" class="btn btn-info" value="글쓰기" />
	</form>
</body>
</html>
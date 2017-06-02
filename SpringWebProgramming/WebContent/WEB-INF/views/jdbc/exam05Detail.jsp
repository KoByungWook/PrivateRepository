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
	function handleBtnUpdate() {
		var bpassword = $("#bpassword").val();
		if(bpassword == "") {
			$("#bpassword").attr("placeholder", "비밀번호를 입력하세요");
			$("#bpassword").css("border-color", "red");
			return;
		}
		$.ajax({
			url:"exam05CheckBpassword",
			method:"post",
			//data:"bno=${board.bno}&bpassword=" + bpassword,
			data:{"bno":"${board.bno}","bpassword":bpassword},
			success: function(data) {
				if(data.result == "success") {
					location.href="exam05Update?bno=${board.bno}"
				} else {
					$("#bpassword").val("");
					$("#bpassword").attr("placeholder", "비밀번호를 다릅니다");
					$("#bpassword").css("border-color", "red");
				}
			}
		});
	}
	function handleBtnDelete() {
		var bpassword = $("#bpassword").val();
		if(bpassword == "") {
			$("#bpassword").attr("placeholder", "비밀번호를 입력하세요");
			$("#bpassword").css("border-color", "red");
			return;
		}
		$.ajax({
			url:"exam05CheckBpassword",
			method:"post",
			data:{"bno":"${board.bno}","bpassword":bpassword},
			success: function(data) {
				if(data.result == "success") {
					location.href="exam05Delete?bno=${board.bno}"
				} else {
					$("#bpassword").val("");
					$("#bpassword").attr("placeholder", "비밀번호를 다릅니다");
					$("#bpassword").css("border-color", "red");
				}
			}
		});
	}
</script>
</head>

<body>
	<h4>게시물 상세 보기</h4>
	<hr />

	<form method="post" style="padding: 0px 20px 0px 20px"
		enctype="multipart/form-data">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="번호" name="bno"
					value="${board.bno}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="제목"
					name="btitle" value="${board.btitle}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="text" class="form-control" placeholder="글쓴이"
					name="bwriter" value="${board.bwriter}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="date" class="form-control" placeholder="글쓴 날짜"
					name="bdate" value="${board.bdate}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="number" class="form-control" placeholder="조회 수"
					name="bhitcount" value="${board.bhitcount}" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-leaf"></span>
				</span>
				<textarea rows="5" cols="30" class="form-control" placeholder="내용"
					name="bcontent" disabled>${board.bcontent}</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <a class="form-control" href="#">${board.boriginalfilename}</a>
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input id="bpassword"type="password" class="form-control" placeholder="비밀번호"
					name="bpassword" />
			</div>
		</div>

		<a href="exam05" class="btn btn-success">목록</a> 
		<input onclick="handleBtnUpdate()" type="button" class="btn btn-warning" value="수정" /> 
		<input onclick="handleBtnDelete()" type="button" class="btn btn-danger" value="삭제" />

		<!-- 
		<button> button </button>				//submit 기능
		<input type="button" value="button"/>
		<input type="submit" value="button"/>	//submit 기능
		<input type="cancel" value="button"/>
		
		<input type="image" src="button.jpg"/>	//submit 기능
		
		 -->
	</form>
</body>
</html>
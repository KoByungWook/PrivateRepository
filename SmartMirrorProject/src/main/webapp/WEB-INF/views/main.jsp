<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name=viewport content="width=device-width initial-scale=1 user-scalable=no">
		<!-- Bootstrap & Jquery -->
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- STT & TTS -->
		<script src="<%=application.getContextPath()%>/resources/js/annyang.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/startannyang.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/responsivevoice.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/checkscript.js"></script>
		<script type="text/javascript" src="http://code.responsivevoice.org/responsivevoice.js"></script>
		<!-- Rss news -->
		<script>
			function news() {
				$.ajax({
					type : "post",
					url : "http://" + location.host + "/SmartMirrorProject/news",
					success : function(data) {
						var list = data.titleList;
						var i = 0;
						setInterval(function(){
							$("#rss").html(list[i].title);
							i++;
							if(i == list.length) {
								i = 0;
							}
						}, 2000);
					}
				});
			}
		</script>
		<!-- Clock -->
		<script src="<%=application.getContextPath()%>/resources/js/clock.js"></script>
		<link href="<%=application.getContextPath()%>/resources/css/clock.css" rel="stylesheet" type="text/css" />
		<!--  -->
		<script src="<%=application.getContextPath()%>/resources/js/controller.js"></script>
	</head>
	<body>
		<div id="content"></div>
		<div id="rss"></div>
		<button onclick="news()"></button>
	</body>
</html>
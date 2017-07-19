<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name=viewport
			content="width=device-width initial-scale=1 user-scalable=no">
		<title>Home</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/js/annyang.js"></script>
		
	</head>
	<body class="" id="gird" style="background-color:red;text-align:center;">
		<div style="color:white;font-size:72px">Weather</div><br/><br/>
    	<div id='result' style="color:white;font-size:36px;"></div>
	</body>
</html> 
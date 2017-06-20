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
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3" style="height:200px;padding:0px;">SensingCar Speed</div>
				<div class="col-md-3" style="height:200px;padding:0px;">SensingCar Direction</div>
				<div class="col-md-2" style="height:200px;padding:0px;">UltrasonicSensor rotate</div>
				<div class="col-md-2" style="height:200px;padding:0px;">Camera Up-Down</div>
				<div class="col-md-2" style="height:200px;padding:0px;">Camera Left-Right</div>
			</div>
			
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12" style="height:200px;padding:0px;">Thermistor Chart</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="height:200px;padding:0px;">Photoresistor Chart</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="height:200px;padding:0px;">GasSensor Chart</div>
					</div>
				</div>
				
			<div class="row"></div>
				
				
			</div>
			
			
		</div>
	</body>
</html>
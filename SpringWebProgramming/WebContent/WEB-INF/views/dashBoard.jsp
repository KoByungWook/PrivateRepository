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
		<style>
			hr {
				align : center;
				width : 1180px;
				margin-top : 0.5em;
				margin-bottom : 0.5em;
				border : 0px;
				border-top : 1px solid rgba(179,179,179,0.5);
			}
		</style>	
	</head>
	<body style="background-color:#1a1a1a">
		<h4 style="padding-left:100px;margin-top:30px">SensingCar DashBoard</h4>
		<hr/>
		<div class="container-fluid" style="width:1200px;margin-top:0px">
			<div class="row">
				<div class="col-md-3" style="padding:5px; ">
					<div style="height:140px;background-color:rgba(179,179,179,0.5);">SensingCar Speed</div>
				</div>
				<div class="col-md-3" style="padding:5px; ">
					<div style="height:140px;background-color:rgba(179,179,179,0.5);">SensingCar Direction</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:140px;background-color:rgba(179,179,179,0.5);">UltrasonicSensor rotate</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:140px;background-color:rgba(179,179,179,0.5);">Camera Up-Down</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:140px;background-color:rgba(179,179,179,0.5);">Camera Left-Right</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:140px;background-color:rgba(179,179,179,0.5);">Thermistor Chart</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:140px;background-color:rgba(179,179,179,0.5);">Photoresistor Chart</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:140px;background-color:rgba(179,179,179,0.5);">GasSensor Chart</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-8">
				
					<div class="row">
						<div class="col-md-6" style="padding:5px; ">
							<div style="height:210px;background-color:rgba(179,179,179,0.5);">Camera Display</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:100px;background-color:rgba(179,179,179,0.5);">UltrasonicSensor Value</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:100px;background-color:rgba(179,179,179,0.5);">TrackingSensor Value</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-4" style="padding:5px; ">
							<div style="height:220px;background-color:rgba(179,179,179,0.5);">RGB Control</div>
						</div>
						<div class="col-md-4" style="padding:5px; ">
							<div style="height:220px;background-color:rgba(179,179,179,0.5);">LCD1602 Control</div>
						</div>
						<div class="col-md-4">
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:105px;background-color:rgba(179,179,179,0.5);">Laser On/Off</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:105px;background-color:rgba(179,179,179,0.5);">Buzzer On/Off</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</body>
</html>
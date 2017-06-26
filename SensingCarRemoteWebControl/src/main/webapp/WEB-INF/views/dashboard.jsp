<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name=viewport
			content="width=device-width initial-scale=1 user-scalable=no">
		<title>Home</title>
		<link
			href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css"
			rel="stylesheet" type="text/css" />
		<script src="https://use.fontawesome.com/b36942a4d5.js"></script>
		<script
			src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
			type="text/javascript"></script>
		<script
			src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/highcharts/code/highcharts.js"></script>
		
		<script src="<%=application.getContextPath()%>/resources/js/showsensorchart.js"></script>
			
		<script src="<%=application.getContextPath()%>/resources/js/thermistorsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/photoresistorsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/trackingsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/ultrasonicsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/gassensorvalue.js"></script>
	</head>
	<body>
		<div class="container-fluid" style="background-color:#eeeeee;width:100%;margin-top:30px;padding:10px">
			<div class="row">
				<div class="col-md-5">
									
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-4" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;margin:10px">
							<div class="row">
								<div class="col-md-12" style="background-color:#f8f8f8;padding:5px 5px 5px 10px;border-radius:5px 5px 0px 0px">Real Time Data</div>
								<div onmouseover="showThermistorSensorChart()" class="col-md-6" style="height:80px;margin:0px;padding:5px 2px 5px 10px;">
									<span><i class="fa fa-thermometer-three-quarters"  aria-hidden="true"></i> Temperature</span>
             						<div id="divTemperature" style="text-align:center;font-size:25px;padding-top:5px">0</div>
								</div>
								<div onmouseover="showUltrasonicSensorChart()" class="col-md-6" style="height:80px;margin:0px;padding:5px 2px 5px 10px;">
									<span><i class="fa fa-exchange" aria-hidden="true"></i> Distance</span>
             						<div id="divDistance" style="text-align:center;font-size:25px;padding-top:5px">0</div>
								</div>
							</div>
							<div class="row">
								<div onmouseover="showPhotoresistorSensorChart()" class="col-md-6" style="height:80px;margin:0px;padding:5px 2px 5px 10px;">
									<span><i class="fa fa-lightbulb-o" aria-hidden="true"></i> Brightness</span>
             						<div id="divPhoto" style="text-align:center;font-size:25px;padding-top:5px">0</div>
								</div>
								<div onmouseover="showGasSensorChart()" class="col-md-6" style="height:80px;margin:0px;padding:5px 2px 5px 10px;">
									<span><i class="fa fa-cloud"  aria-hidden="true"></i> Gas Con.</span>
             						<div id="divGas" style="text-align:center;font-size:25px;padding-top:5px">0</div>
								</div>
							</div>
							<div class="row">
								<div onmouseover="showTrackingSensorChart()" class="col-md-12" style="height:100px;margin:0px;padding:5px 5px 5px 10px;">
									<span><i class="fa fa-adjust" aria-hidden="true"></i> Tracking Status</span>
             						<div id="divTracking" style="height:55px;background-color:black;margin:8px 60px 15px 60px"></div>
								</div>
							</div>
						</div>
						<div class="col-md-7" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;padding:0px;margin:10px">
							<div class="row"></div>
								<div class="col-md-12" style="background-color:#f8f8f8;padding:5px 5px 5px 10px;border-radius:5px 5px 0px 0px">Real Time ChartView</div>
								<div class="col-md-12" style="height:260px;padding:10px 0px 0px 0px">
									<div id="chartContainer" style="height:230px;padding:0px;margin:0px;text-align:center;">
										<br/><br/><br/><br/>자세히 보고 싶은 데이터 위에<br/>마우스를 올려주세요.
									</div>
								</div>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
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
		
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Bubblegum+Sans" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Hammersmith+One" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Droid+Sans" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Indie+Flower" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Gloria+Hallelujah" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Contrail+One" />
				
		<script src="<%=application.getContextPath()%>/resources/js/showsensorchart.js"></script>
			
		<script src="<%=application.getContextPath()%>/resources/js/thermistorsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/photoresistorsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/trackingsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/ultrasonicsensorvalue.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/gassensorvalue.js"></script>
		<style>
			.bannerhr {
				height: 1px;
				width: 70%;
				color: #ffffff;
				background-color: #ffffff;
				border: none;
				margin-top: 12px;
				margin-bottom: 12px;
			}
			.topnav {
			  overflow: hidden;
			  background-color: rgba(0, 0, 0, 0.7);
			  width: 100%;
			  position: fixed;
			  z-index: 999;
			}
			
			.topnav a {
			  float: left;
			  display: block;
			  color: #f2f2f2;
			  text-align: center;
			  padding: 14px 16px;
			  text-decoration: none;
			  font-size: 17px;
			}
			
			.topnav a:hover {
			  background-color: #ddd;
			  color: black;
			}
			
			.topnav a.active {
			    background-color: #4CAF50;
			    color: white;
			}
		</style>
	</head>
	<body>
		<div class="topnav">
		  <a href="#top">TOP</a>
		  <a href="#realTimeData">RealTime Data</a>
		  <a href="#driving">Driving Status & Control</a>
		  <a href="#camera">Camera & Toggle Control</a>
		  <a href="#rgb">RGB & LCD Control</a>
		</div>
		<div id="top" style="font-family:Contrail One;padding-top:65px;min-height:450px;background-repeat:no-repeat;background-size:100%;background-image:url(<%=application.getContextPath()%>/resources/images/coding_background2.jpg);">
			<div style="margin-left:15%;font-size:30px;color:white;">IoTCourse#1.Group 4</div>
			<hr class="bannerhr"/>
			<div style="font-size:50px;color:white;text-align:center;margin-top:80px;">SensingCar Remote Control Board</div>
			<div style="font-size:25px;color:white;text-align:center;margin-top:10px;">IoT Engineer Training Course SpringFramework Project</div>
		</div>
			
		<div class="container-fluid" style="font-family:Contrail One;width:70%;">
			<div class="row">
			
				<div id="realTimeData" class="col-md-12" style="margin-top:30px;">
					<div>
						<h2>RealTime Data</h2>
						<hr/>
					</div>
					<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
						<div class="row" style="margin:0px;">
							<div id="hoverTemperature" onmouseover="showThermistorSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-thermometer-three-quarters"  aria-hidden="true"></i> Temperature</span>
             					<div id="divTemperature" style="text-align:center;font-size:32px;">0</div>
							</div>
							<div id="hoverDistance" onmouseover="showUltrasonicSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-exchange" aria-hidden="true"></i> Distance</span>
             					<div id="divDistance" style="text-align:center;font-size:32px;">0</div>
							</div>
							<div id="hoverPhoto" onmouseover="showPhotoresistorSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-lightbulb-o" aria-hidden="true"></i> Brightness</span>
             					<div id="divPhoto" style="text-align:center;font-size:32px;">0</div>
							</div>
							<div id="hoverGas" onmouseover="showGasSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-cloud"  aria-hidden="true"></i> Gas Con.</span>
             					<div id="divGas" style="text-align:center;font-size:32px;">0</div>
							</div>
							<div id="hoverTracking" onmouseover="showTrackingSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-adjust" aria-hidden="true"></i> Tracking</span>
             					<div id="divTracking" style="height:30px;background-color:black;margin-top:10px;"></div>
							</div>
							<div onmouseover="showClearSensorChart()" class="col-md-2" style="height:80px;padding-top:10px;">
								<span style="font-size:16px;"><i class="fa fa-window-close" aria-hidden="true"></i> Clear</span>
             					<div id="divClear" style="text-align:center;font-size:16px;"></div>
							</div>
						</div>
					</div>
					<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
						<div style="height:320px;">
							<div id="chartContainer" style="height:320px;text-align:center;font-size:30px;color:gray;">
								<br/><br/>Please put your mouse<br/>To the data that you want to see in the chart.
							</div>
						</div>
					</div>	
				</div>
				
				<div id="driving" class="col-md-12" style="margin-bottom:30px;">
					<div>
						<h2>Driving Status & Control</h2>
						<hr/>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
								<div style="height:240px;"></div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-12">
									<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
										<div style="height:120px;"></div>
									</div>
									<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
										<div style="height:120px;"></div>
									</div>	
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div id="camera" class="col-md-8" style="margin-bottom:30px;">
						<div>
							<h2>Camera Control</h2>
							<hr/>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
									<div style="height:300px;"></div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-12">
										<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
											<div style="height:300px;"></div>
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="toggle" class="col-md-4" style="margin-bottom:30px;">
						<div>
							<h2>Toggle Control</h2>
							<hr/>
						</div>
						<div class="col-md-12">
							<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
								<div style="height:300px;"></div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div id="rgb" class="col-md-5" style="margin-bottom:30px;">
						<div>
							<h2>RGB LED Control</h2>
							<hr/>
						</div>
						<div class="col-md-12">
							<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
								<div style="height:240px;"></div>
							</div>
						</div>
					</div>
					<div id="lcd" class="col-md-7" style="margin-bottom:30px;">
						<div>
							<h2>LCD Display Control</h2>
							<hr/>
						</div>
						<div class="col-md-12">
							<div class="row" style="background-color:#ffffff;border:1px solid #f8f8f8;border-radius:5px;">
								<div style="height:240px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div style="width:100%;background-color:black;text-align:center;margin-top:20px;">
			<div style="height:70px;padding-top:20px;background-color:black;color:white;text-align:center;font-size:18px;">
				© 2017 KOSA. All Rights Reserved | Design by IoTCourse#1.Group4
			</div>
		</div>
	</body>
</html>
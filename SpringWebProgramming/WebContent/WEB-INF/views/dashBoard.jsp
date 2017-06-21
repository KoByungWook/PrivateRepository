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
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/highcharts-more.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script>
			$(function() {
				Highcharts.chart('container', {
					
				    chart: {
				        type: 'gauge',
				        plotBorderWidth: 1,
				        plotBackgroundColor: {
				            linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
				            stops: [
				                [0, '#FFF4C6'],
				                [0.3, '#FFFFFF'],
				                [1, '#FFF4C6']
				            ]
				        },
				        plotBackgroundImage: null,
				        height: 200
				    },

				    title: {
				        text: 'UltrasonicSensor Angle'
				    },

				    pane: [{
				        startAngle: -90,
				        endAngle: 90,
				        background: null,
				        center: ['50%', '100%'],
				        size: 180
				    }],

				    tooltip: {
				        enabled: false
				    },

				    yAxis: [{
				        min: 0,
				        max: 180,
				        minorTickPosition: 'outside',
				        tickPosition: 'outside',
				        tickAmount: 19,
				        labels: {
				            rotation: 'auto',
				            distance: 20,
				            step: 3,
				            style: {
				                fontsize: '5px'
				            }
				        },
				        pane: 0,
				        title: {
				            text: 'VU<br/><span style="font-size:8px">Channel A</span>',
				            y: 0
				        }
				    }],

				    plotOptions: {
				        gauge: {
				            dataLabels: {
				                enabled: false
				            },
				            dial: {
				                radius: '100%'
				            }
				        }
				    },


				    series: [{
				        name: 'Channel A',
				        data: [90],
				        yAxis: 0
				    }]

				},

				    // Let the music play
					function (chart) {
       					setInterval(function () {
            				if (chart.series) { // the chart may be destroyed
                				var left = chart.series[0].points[0],
                    			leftVal,
                   				inc = (Math.random() - 0.5) * 100;

                				leftVal = left.y + inc;
                				if (leftVal < 0 || leftVal > 180) {
                    				leftVal = left.y - inc;
                				}
				                left.update(leftVal, false);
				                chart.redraw();
            				}
        				}, 500);
					});
			});
		</script>
		<style>
			hr {
				align : center;
				width : 80%;
				margin-top : 0.5em;
				margin-bottom : 0.5em;
				border : 0px;
				border-top : 1px solid rgba(179,179,179,0.3);
			}
			.section {
				
			}
		</style>	
	</head>
	<body style="background-color:#1a1a1a">
		<h3 style="padding-left:200px;margin-top:30px">SensingCar DashBoard</h3>
		<hr/>
		<div class="container-fluid" style="width:80%;margin-top:0px">
			<div class="row" >
				<div class="col-md-3" style="padding:5px; ">
					<div style="height:200px;background-color:rgba(179,179,179,0.3);">SensingCar Speed</div>
				</div>
				<div class="col-md-3" style="padding:5px; ">
					<div style="height:200px;background-color:rgba(179,179,179,0.3);">SensingCar Direction</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:200px;background-color:rgba(179,179,179,0.3);">
						<div id="container" style="height: 200px; margin: 0 auto"></div>
					</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:200px;background-color:rgba(179,179,179,0.3);">Camera Up-Down</div>
				</div>
				<div class="col-md-2" style="padding:5px; ">
					<div style="height:200px;background-color:rgba(179,179,179,0.3);">Camera Left-Right</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:200px;background-color:rgba(179,179,179,0.3);">Thermistor Chart</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:200px;background-color:rgba(179,179,179,0.3);">Photoresistor Chart</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12" style="padding:5px; ">
							<div style="height:200px;background-color:rgba(179,179,179,0.3);">GasSensor Chart</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-8">
				
					<div class="row">
						<div class="col-md-6" style="padding:5px; ">
							<div style="height:330px;background-color:#1a1a1a;text-align:center;padding:5px">
								<img src="http://192.168.3.44:50001?action=stream" style="height:320px;"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:160px;background-color:rgba(179,179,179,0.3);">UltrasonicSensor Value</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:160px;background-color:rgba(179,179,179,0.3);">TrackingSensor Value</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-4" style="padding:5px; ">
							<div style="height:280px;background-color:rgba(179,179,179,0.3);">RGB Control</div>
						</div>
						<div class="col-md-4" style="padding:5px; ">
							<div style="height:280px;background-color:rgba(179,179,179,0.3);">LCD1602 Control</div>
						</div>
						<div class="col-md-4">
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:135px;background-color:rgba(179,179,179,0.3);">Laser On/Off</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12" style="padding:5px; ">
									<div style="height:135px;background-color:rgba(179,179,179,0.3);">Buzzer On/Off</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
		
	</body>
</html>
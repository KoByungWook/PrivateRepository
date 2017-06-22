<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
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
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/exporting.js"></script>
		<script src="/js/themes/dark-unica.js"></script>
		<script>
			$(document).ready(function () {
				
				Highcharts.setOptions({
					global: {
			            useUTC: false
			        }
			    });
				
			    Highcharts.chart('containerTemp', {
			        chart: {
			            type: 'spline',
			            animation: Highcharts.svg, // don't animate in old IE
			            marginRight: 10,
			            backgroundColor: '#1a1a1a',
			            events: {
			                load: function () {
	
			                    // set up the updating of the chart each second
			                    var series = this.series[0];
			                    setInterval(function () {
			                        var x = (new Date()).getTime(), // current time
			                            y = Math.random();
			                        series.addPoint([x, y], true, true);
			                    }, 1000);
			                }
			            }
			        },
			        title: {
			            text: null			            
			        },
			        xAxis: {
			            type: 'datetime',
			            tickPixelInterval: 75
			        },
			        yAxis: {
			        	title: {
			                text: 'temperature'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080'
			            }]
			        },
			        plotOptions: {
			        	series: {
			            	color: '#0000CC'
			        	}
			        },
			        tooltip: {
			            formatter: function () {
			                return '<b>' + this.series.name + '</b><br/>' +
			                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
			                    Highcharts.numberFormat(this.y, 2);
			            }
			        },
			        legend: {
			            enabled: false
			        },
			        exporting: {
			            enabled: false
			        },
			        series: [{
			            name: 'Random data',
			            data: (function () {
			                // generate an array of random data
			                var data = [],
			                    time = (new Date()).getTime(),
			                    i;
	
			                for (i = -19; i <= 0; i += 1) {
			                    data.push({
			                        x: time + i * 1000,
			                        y: Math.random()
			                    });
			                }
			                return data;
			            }())
			        }]
			    });
			    
			});
		</script>
		<script>
			$(document).ready(function () {
				
				Highcharts.setOptions({
					global: {
			            useUTC: false
			        }
			    });
				
			    Highcharts.chart('containerPhoto', {
			        chart: {
			            type: 'spline',
			            animation: Highcharts.svg, // don't animate in old IE
			            marginRight: 10,
			            backgroundColor: '#1a1a1a',
			            events: {
			                load: function () {
	
			                    // set up the updating of the chart each second
			                    var series = this.series[0];
			                    setInterval(function () {
			                        var x = (new Date()).getTime(), // current time
			                            y = Math.random();
			                        series.addPoint([x, y], true, true);
			                    }, 1000);
			                }
			            }
			        },
			        title: {
			            text: null			            
			        },
			        xAxis: {
			            type: 'datetime',
			            tickPixelInterval: 75
			        },
			        yAxis: {
			        	title: {
			                text: 'brightness'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080'
			            }]
			        },
			        plotOptions: {
			        	series: {
			            	color: '#FF0000'
			        	}
			        },
			        tooltip: {
			            formatter: function () {
			                return '<b>' + this.series.name + '</b><br/>' +
			                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
			                    Highcharts.numberFormat(this.y, 2);
			            }
			        },
			        legend: {
			            enabled: false
			        },
			        exporting: {
			            enabled: false
			        },
			        series: [{
			            name: 'Random data',
			            data: (function () {
			                // generate an array of random data
			                var data = [],
			                    time = (new Date()).getTime(),
			                    i;
	
			                for (i = -19; i <= 0; i += 1) {
			                    data.push({
			                        x: time + i * 1000,
			                        y: Math.random()
			                    });
			                }
			                return data;
			            }())
			        }]
			    });
			});
		</script>
		<script>
			$(document).ready(function () {
				
				Highcharts.setOptions({
					global: {
			            useUTC: false
			        }
			    });
				
			    Highcharts.chart('containerGas', {
			        chart: {
			            type: 'spline',
			            animation: Highcharts.svg, // don't animate in old IE
			            marginRight: 10,
			            backgroundColor: '#1a1a1a',
			            events: {
			                load: function () {
	
			                    // set up the updating of the chart each second
			                    var series = this.series[0];
			                    setInterval(function () {
			                        var x = (new Date()).getTime(), // current time
			                            y = Math.random();
			                        series.addPoint([x, y], true, true);
			                    }, 1000);
			                }
			            }
			        },
			        title: {
			            text: null			            
			        },
			        xAxis: {
			            type: 'datetime',
			            tickPixelInterval: 75
			        },
			        yAxis: {
			        	title: {
			                text: 'gas concentration'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080'
			            }]
			        },
			        plotOptions: {
			        	series: {
			            	color: '#FFFF00'
			        	}
			        },
			        tooltip: {
			            formatter: function () {
			                return '<b>' + this.series.name + '</b><br/>' +
			                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
			                    Highcharts.numberFormat(this.y, 2);
			            }
			        },
			        legend: {
			            enabled: false
			        },
			        exporting: {
			            enabled: false
			        },
			        series: [{
			            name: 'Random data',
			            data: (function () {
			                // generate an array of random data
			                var data = [],
			                    time = (new Date()).getTime(),
			                    i;
	
			                for (i = -19; i <= 0; i += 1) {
			                    data.push({
			                        x: time + i * 1000,
			                        y: Math.random()
			                    });
			                }
			                return data;
			            }())
			        }]
			    });
			});
		</script>
		
	</head>
<body>
	<div class="container-fluid" style="width:85%;height:100%;border:1px solid #1a1a1a;margin-top:20px;margin-bottom:20px;">
		<div class="row">
			<div class="col-md-6">
				<div class="col-md-12" style="height:400px;">
					<h3 style="padding-left:10px;margin-top:10px">SensingCar Control</h3>
					<hr style="margin-top:0px;"/>
				</div>
				<div class="col-md-12" style="height:400px;">
						<h3 style="padding-left:10px;margin-top:10px">Display Control</h3>
						<hr style="margin-top:0px;"/>
				</div>
			</div>
			<div class="col-md-3">
				<div class="row">
					<div class="col-md-12" style="height:230px;">
						<h3 style="padding-left:10px;margin-top:10px">Camera Control</h3>
						<hr style="margin-top:0px;"/>
						<div style="text-align:center;">
							<img src="http://192.168.3.44:50001?action=stream" style="height:150px"/>
						</div>
					</div>
					<div class="col-md-12" style="height:230px;">
						<h3 style="padding-left:10px;margin-top:10px">US-sensor Control</h3>
						<hr style="margin-top:0px;"/>
					</div>
					<div class="col-md-12" style="height:230px;">
						<h3 style="padding-left:10px;margin-top:10px">Toggle Control</h3>
						<hr style="margin-top:0px;"/>
					</div>
				</div>
			</div>
			<div class="col-md-3" style="background-color:#1a1a1a;height:800px">
				<h3 style="color:#808080;padding-left:10px;margin-top:10px">Real Time Data</h3>
				<hr style="margin-top:0px;"/>
				<div class="col-md-12" style="height:200px;margin:0px;padding:0px;">
					<div id="containerTemp" style="height:160px; margin: 0 auto"></div>
				</div>
				<div class="col-md-12" style="height:200px;margin:0px;padding:0px;">
					<div id="containerPhoto" style="height:160px; margin: 0 auto"></div>
				</div>
				<div class="col-md-12" style="height:200px;margin:0px;padding:0px;">
					<div id="containerGas" style="height:160px; margin: 0 auto"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
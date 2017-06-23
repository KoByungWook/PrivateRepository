var ultrasonicSensorChart;
$(function() {
	ultrasonicSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"ultrasonicSensorChartContainer",
			type:"line",
			events: {
				load: requestUltrasonicSensorData
			}
		},
		colors: ['purple'],
		title: {
			text: "UltrasonicSensor"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			maxZoom: 20*1000
		},
		yAxis: {
			minPadding: 0.2,
			maxPadding: 0.2,
			title: {
				text: "distance",
				margin: 30
			}
		},
		series: [{
			name: "distance",
			data: []
		}]
	});
});

function requestUltrasonicSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/ultrasonicsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = ultrasonicSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.distance], true, shift);
	};
}
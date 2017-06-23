var thermistorSensorChart;
$(function() {
	thermistorSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"thermistorSensorChartContainer",
			type:"line",
			events: {
				load: requestThermistorSensorData
			}
		},
		colors: ['red'],
		title: {
			text: "ThermistorSensor"
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
				text: "temperature",
				margin: 30
			}
		},
		series: [{
			name: "temperature",
			data: []
		}]
	});
});

function requestThermistorSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/thermistorsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = thermistorSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.temperature], true, shift);
	};
}
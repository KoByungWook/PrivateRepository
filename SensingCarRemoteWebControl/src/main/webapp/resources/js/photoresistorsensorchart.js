var photoresistorSensorChart;
$(function() {
	photoresistorSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"photoresistorSensorChartContainer",
			type:"line",
			events: {
				load: requestPhotoresistorSensorData
			}
		},
		colors: ['white'],
		title: {
			text: "PhotoresistorSensor"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "brightness",
				margin: 30
			}
		},
		series: [{
			name: "photoresistor",
			data: []
		}]
	});
});

function requestPhotoresistorSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/photoresistorsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = photoresistorSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.photoresistor], true, shift);
	};
}


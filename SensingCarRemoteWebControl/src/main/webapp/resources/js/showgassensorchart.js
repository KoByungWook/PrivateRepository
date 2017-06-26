var gasSensorChart;
function showGasSensorChart() {
	gasSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"chartContainer",
			type:"line",
			events: {
				load: requestGasSensorData
			}
		},
		colors: ['green'],
		title: {
			text: "gasSensor"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "gas",
				margin: 30
			}
		},
		series: [{
			name: "gas",
			data: []
		}]
	});
}

function requestGasSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/gassensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = gasSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.gas], true, shift);
	};
}


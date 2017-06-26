var trackingSensorChart;
function showTrackingSensorChart() {
	trackingSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"chartContainer",
			type:"line",
			events: {
				load: requestTrackingSensorData
			}
		},
		colors: ['black'],
		title: {
			text: "trackingSensor"
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
				text: "tracking",
				margin: 30
			}
		},
		series: [{
			name: "tracking",
			data: []
		}]
	});
}

function requestTrackingSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/trackingsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = trackingSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.tracking], true, shift);
	};
}
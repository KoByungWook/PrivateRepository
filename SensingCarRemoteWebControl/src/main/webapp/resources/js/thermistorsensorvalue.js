$(function() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/thermistorsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var temperature = data.temperature;
		
		$("#divTemperature").html(temperature + "℃");
	};
});
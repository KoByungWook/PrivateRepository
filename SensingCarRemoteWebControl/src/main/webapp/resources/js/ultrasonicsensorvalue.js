$(function() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/ultrasonicsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var distance = data.distance;
		
		$("#divDistance").html(distance + "cm");
	};
});

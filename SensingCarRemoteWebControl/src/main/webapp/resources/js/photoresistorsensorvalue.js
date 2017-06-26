$(function() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/photoresistorsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var brightness = data.photoresistor;
		
		$("#divPhoto").html(brightness);
	};
});

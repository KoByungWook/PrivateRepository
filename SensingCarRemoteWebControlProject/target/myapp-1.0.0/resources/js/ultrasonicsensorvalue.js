$(function() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControlProject/websocket/ultrasonicsensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var distance = data.distance;
		$("#divDistance").html(distance + "cm");
		
		if(distance < 10) {
			var json = {"command":"change", "direction":"forward", "speed":"0"};
			$.ajax({
				url:"http://" + location.host + "/SensingCarRemoteWebControlProject/backtire",
				data: json,
				method: "post",
				success: function(data) {
					if(data.result == "success") {
						$("#backtirespeedup").attr("onmousedown","speedup(" + speed + ")");
						$("#backtirespeedupvalue").html(data.speed);
						point = chartSpeed.series[0].points[0];
						point.update(data.speed);
					}
				}
			});
		}
	};
});

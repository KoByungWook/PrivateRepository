function backtire(command, direction, speed) {
	var json = {"command":command, "direction":direction, "speed":speed};

	$.ajax({
		url:"http://" + location.host + "/SensingCarRemoteWebControl/backtire",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#backtireStatus").html("direction=" + data.direction + "; speed=" + data.speed);
				
				$("#btnDirectionForward").attr("onclick", "backtire('change', 'forward', '" + data.speed + "')");
				$("#btnDirectionBackward").attr("onclick", "backtire('change', 'backward', '" + data.speed + "')");
				
				$("#btnSpeed0").attr("onclick", "backtire('change', '" + data.direction + "', '0')");
				$("#btnSpeed900").attr("onclick", "backtire('change', '" + data.direction + "', '900')");
				$("#btnSpeed1200").attr("onclick", "backtire('change', '" + data.direction + "', '1200')");
				$("#btnSpeed1550").attr("onclick", "backtire('change', '" + data.direction + "', '1550')");
				$("#btnSpeed1900").attr("onclick", "backtire('change', '" + data.direction + "', '1900')");
				$("#btnSpeed2250").attr("onclick", "backtire('change', '" + data.direction + "', '2250')");
				$("#btnSpeed2600").attr("onclick", "backtire('change', '" + data.direction + "', '2600')");
				$("#btnSpeed2950").attr("onclick", "backtire('change', '" + data.direction + "', '2950')");
				$("#btnSpeed3300").attr("onclick", "backtire('change', '" + data.direction + "', '3300')");
				$("#btnSpeed3650").attr("onclick", "backtire('change', '" + data.direction + "', '3650')");
				$("#btnSpeed4000").attr("onclick", "backtire('change', '" + data.direction + "', '4000')");
			}
		}
	});
}
function backtireDirection(direction, speed) {
	var json = {"command":"change", "direction":direction, "speed":speed};

	$.ajax({
		url:"http://" + location.host + "/SensingCarRemoteWebControlProject/backtire",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#divDirection").html(data.direction);
			}
		}
	});
}
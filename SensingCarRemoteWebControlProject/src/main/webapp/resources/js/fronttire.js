function fronttire(nowangle, changeangle) {
	var setangle = nowangle + changeangle;
	var json = {"command":"change", "angle":setangle};

	$.ajax({
		url:"http://" + location.host + "/SensingCarRemoteWebControlProject/fronttire",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#divFronttireAngle").html(data.angle+"º");
				$("#fronttireleft").attr("onclick","fronttire('" + data.angle + "', '-5')");
				$("#fronttireright").attr("onclick","fronttire('" + data.angle + "', '5')");
			}
		}
	});
}
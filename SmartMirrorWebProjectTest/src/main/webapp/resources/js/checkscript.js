function checkScript(message) {
	
	script = message.replace( / /gi ,"");
	if(script.search("사용가능한명령어") > -1) {
		
	}
	//map command check
	if(script.search("지도") > -1) {
		var mapCommand = script.replace("지도","");
		if(mapCommand == "끄기") {
			close();
			closeSpeech("지도");
		} else if(mapCommand == "켜기") {
			openMap();
			openSpeech("지도");
		} else if(mapCommand == "확대") {
			zoomIn();
			annyangReset();
		} else if(mapCommand == "축소") {
			zoomOut();
			annyangReset();
		} else if(mapCommand == "리셋") {
			zoomReset();
			annyangReset();
		} else {
			setMap(mapCommand);
			annyangReset();
		}	
	}
	
	//camera command check
	if(script.search("카메라") > -1) {
		var cameraCommand = script.replace("카메라","");
		console.log(cameraCommand);
		 if(cameraCommand == "끄기") {
			 close();
			 closeSpeech("카메라");
		 } else if(cameraCommand == "켜기") {
			 openCamera();
			 openSpeech("카메라");
		 } else if(cameraCommand == "촬영") {
			 snapshot();
		 } else {
			 annyangReset();
		 }
	}
	//movie command check
	if(script.search("영화") > -1) {
		var movieCommand = script.replace("영화","");
		if(movieCommand == "정보") {
			showBoxOffice();
			openSpeech("영화");
		} else if(cameraCommand == "정보끄기") {
			close();
			closeSpeech("영화정보");
		}
	}
	//alarm command check
	if(script.search("알람") > -1) {
		var alarmCommand = script.replace("알람","");
		if(alarmCommand == "끄기") {
			alarmStop();
			annyangReset();
		}
	}
}

function openSpeech(message) {
	annyang.pause();
	var text = message + " 정보입니다.";
	speakText(text);
	annyang.resume();
}

function closeSpeech(message) {
	annyang.pause();
	var text = message + "를 종료합니다.";
	speakText(text);
	annyang.resume();
	$('#speech').html("");
}

function annyangReset() {
	annyang.pause();
	annyang.resume();
}
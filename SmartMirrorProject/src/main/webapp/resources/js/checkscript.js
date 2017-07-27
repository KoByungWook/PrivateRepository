function checkScript(message) {
	
	script = message.replace( / /gi ,"");
	
	//map command check
	if(script.search("지도") > -1) {
		var mapInfo = script.replace("지도","");
		if(mapInfo == "끄기") {
			close();
			closeSpeech("지도");
		} else if(mapInfo == "" || mapInfo == null) {
			openMap();
			openSpeech("지도");
		} else if(mapInfo == "확대") {
			zoomIn();
			annyangReset();
		} else if(mapInfo == "축소") {
			zoomOut();
			annyangReset();
		} else if(mapInfo == "리셋") {
			zoomReset();
			annyangReset();
		} else {
			setMap(mapInfo);
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
}

function annyangReset() {
	annyang.pause();
	annyang.resume();
}
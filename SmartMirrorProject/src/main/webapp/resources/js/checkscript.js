function checkScript(message) {
	
	script = message.replace( / /gi ,"");
	
	//map command check
	if(script.search("지도") > -1) {
		var mapInfo = script.replace("지도","");
		if(mapInfo == "끄기") {
			
		} else if(mapInfo == "" || mapInfo == null) {
			openMap();
			annyang.pause();
			speakText("지도 정보입니다");
			annyang.resume();
		} else {
			setMap(mapInfo);
		}	
	}
}
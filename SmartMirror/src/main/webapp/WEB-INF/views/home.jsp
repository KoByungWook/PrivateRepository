<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name=viewport
			content="width=device-width initial-scale=1 user-scalable=no">
		<title>Home</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/js/annyang.js"></script>
		<script>
	    	annyang.start({autoRestart: true , continuous: true})
	    	var recognition = annyang. getSpeechRecognizer();
	    	var final_transcript = '' ;
	    	recognition.interimResults = true;
	    	recognition.onresult = function(event){
	    		var interim_transcript = ' ';
	    		final_transcript='';
	    		for(var i =event.resultIndex; i<event.results.length; ++i){
	    			console.log(i);
	    			if(event.results[i].isFinal){
	    				final_transcript+=event.results[i][0].transcript;
	    				console.log("final_transcript=" +final_transcript);
	    				console.log("confidence=" + event.results[i][0].confidence);
	    			}else{
	    				interim_transcript+=event.results[i][0].transcript;
	    				console.log("interim_transcript="+interim_transcript);
	    			}
	    		}
	   			document.getElementById('result').innerHTML = final_transcript;
	   			console.log('interim='+interim_transcript+ '|final='+final_transcript);
	   			
	   			checkScript(final_transcript);
	    	};
	    	
	    	annyang.addCallback('error', function () {
	    		console.log(new Date());
	    	});
    	</script>
    	<script type="text/javascript">
    		function checkScript(message) {
    			script = message.replace( / /gi ,"");
    			if(script == "날씨") {
    				//location.href="/myapp/weather";
    				popupWeather();
    			}
    			if(script == "날씨끄기") {
    				closeWeather();
    			}
    			if(script == "거울아") {
    				screenOn();
    			}
    			if(script == "잘자") {
    				screenOff();
    			}
    		}
    	</script>
    	<script type="text/javascript">
    		var weatherPopup;
			function popupWeather() {
				weatherPopup = window.open('/myapp/weather','popup','width=300, height=200, left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, resizable=no, scrollbars=no, copyhistory=no');
			}
			function closeWeather() {
				 weatherPopup.close();
			}
			function screenOn() {
				$("#body").css("opacity","1");
			}
			function screenOff() {
				$("#body").css("opacity","0");
			}
    	</script>
	</head>
	<body class="" id="body" style="background-color:black;text-align:center;">
		<div style="color:white;font-size:72px">Hi Mirror</div><br/><br/>
    	<div id='result' style="color:white;font-size:36px;"></div>
    	<div id="container"></div>
	</body>
</html> 
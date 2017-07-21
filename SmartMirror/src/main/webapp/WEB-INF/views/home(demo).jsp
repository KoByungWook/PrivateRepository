<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name=viewport content="width=device-width initial-scale=1 user-scalable=no">
		<title>Home</title>
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Modern+Antiqua" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Merriweather" />
		<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Varela+Round" />
		
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		
		<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

		<script src="<%=application.getContextPath()%>/resources/js/annyang.js"></script>
		<script src="<%=application.getContextPath()%>/resources/js/runResponsiveVoice.js"></script>
		<script type="text/javascript" src="http://code.responsivevoice.org/responsivevoice.js"></script>
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
	   			//document.getElementById('result').innerHTML = final_transcript;
	   			//console.log('interim='+interim_transcript+ '|final='+final_transcript);
	   			
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
    				$.mobile.changePage("#weather", { transition: "fade" });
    				annyang.pause();
    				speakText("오늘 날씨는 자바하기 좋은 날씨입니다.");
    				annyang.resume();
    			} else if(script == "날씨끄기") {
    				$.mobile.changePage("#main", { transition: "fade" });
    				annyang.pause();
    				speakText("날씨를 종료합니다.");
    				annyang.resume();
    			} else if(script == "달력") {
    				$.mobile.changePage("#calander", { transition: "fade" });
    				annyang.pause();
    				speakText("달력 정보입니다");
    				annyang.resume();
    			} else if(script == "달력끄기") {
    				$.mobile.changePage("#main", { transition: "fade" });
    				annyang.pause();
    				speakText("달력을 종료합니다.");
    				annyang.resume();
    			} else if(script == "카메라") {
    				$.mobile.changePage("#camera", { transition: "fade" });
    				annyang.pause();
    				speakText("카메라 정보입니다");
    				annyang.resume();
    			} else if(script == "카메라끄기") {
    				$.mobile.changePage("#main", { transition: "fade" });
    				annyang.pause();
    				speakText("카메라를 종료합니다.");
    				annyang.resume();
    			} else if(script == "거울아") {
    				screenOn();
    				annyang.pause();
    				speakText("안녕하세요 무엇을 도와드릴까요?");
    				annyang.resume();
    			} else if(script == "잘자") {
    				screenOff();
    				annyang.pause();
    				speakText("안녕히계세요");
    				annyang.resume();
    			} else if(script == "잘했어") {
    				annyang.pause();
    				speakText("니가 뭔데 나를 판단해");
    				annyang.resume();
    			} else {
    				annyang.pause();
    				speakText("지원하지 않는 명령어입니다.");
    				annyang.resume();
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
    	<style>
    		.ui-page {
    			background: black;
    		}
    		.pageHeader {
    			border:black;
    			font-size:108px;
    			font-family:Varela Round;
    		}
    		
    		.pageFooter {
    			border:black;
    			font-size:48px;
    			font-family:Varela Round;
    		}
    	</style>
	</head>
	<body class="" id="body" style="background-color:black;text-align:center;">
		<div data-role="page" id="main">
		  <div data-role="header" class="pageHeader" style="background-color:black;color:white;">
		  	Hi Team4
		  </div>
		
		  <div data-role="content" class="ui-content">
		    
		  </div>
		
		  <div data-role="footer" class="pageFooter" style="background-color:black;color:white;">
		    <h1>원하는 명령어를 말해주세요.</h1>
		  </div>
		</div>
		
		<div data-role="page" id="weather">
		  <div data-role="header" class="pageHeader" style="background-color:black;color:white;">
		  	Hi Team4
		  </div>
		
		  <div data-role="main" class="ui-content">
		    <p>오늘 날씨는 자바하기 좋은 날씨</p>
		  </div>
		
		  <div data-role="footer" class="pageFooter" style="background-color:black;color:white;">
		    <h1>원하는 명령어를 말해주세요.</h1>
		  </div>
		</div>
		
		<div data-role="page" id="calander">
		  <div data-role="header" class="pageHeader" style="background-color:black;color:white;">
		  	Hi Team4
		  </div>
		
		  <div data-role="main" class="ui-content">
		  	<iframe src="https://calendar.google.com/calendar/embed?showTitle=0&amp;showNav=0&amp;showPrint=0&amp;showTabs=0&amp;showCalendars=0&amp;showTz=0&amp;height=500&amp;wkst=1&amp;hl=en&amp;bgcolor=%23ffcccc&amp;src=jyk60222%40gmail.com&amp;color=%23B1440E&amp;ctz=Asia%2FSeoul" style="border-width:0" width="600" height="500" frameborder="0" scrolling="no"></iframe>
		  </div>
		
		  <div data-role="footer" class="pageFooter" style="background-color:black;color:white;">
		    <h1>원하는 명령어를 말해주세요.</h1>
		  </div>
		</div>
		
		<div data-role="page" id="camera">
		  <div data-role="header" class="pageHeader" style="background-color:black;color:white;">
		  	Hi Team4
		  </div>
		
		  <div data-role="main" class="ui-content">
		  	<img src="http://192.168.3.43:50001?action=stream" />
		  </div>
		
		  <div data-role="footer" class="pageFooter" style="background-color:black;color:white;">
		    <h1>원하는 명령어를 말해주세요.</h1>
		  </div>
		</div>
	</body>
</html> 
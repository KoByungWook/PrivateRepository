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
		
		<script src="<%=application.getContextPath()%>/resources/js/clock.js"></script>
		<link href="<%=application.getContextPath()%>/resources/css/clock.css" rel="stylesheet" type="text/css" />
		
    	<script>
			$(function() {
				$( "[data-role='header'], [data-role='footer']" ).toolbar();
			});
		</script>
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
    				$.mobile.changePage("<%=application.getContextPath()%>/page/weather.jsp", { transition: "fade", prefetch: "true" });
    				annyang.pause();
    				speakText("오늘 날씨는 자바하기 좋은 날씨입니다.");
    				annyang.resume();
    			} else if(script == "날씨끄기") {
    				$.mobile.changePage("<%=application.getContextPath()%>/page/main.jsp", { transition: "fade", prefetch: "true" });
    				annyang.pause();
    				speakText("날씨를 종료합니다.");
    				annyang.resume();
    			} else if(script == "달력") {
    				$.mobile.changePage("<%=application.getContextPath()%>/page/calander.jsp", { transition: "fade", prefetch: "true" });
    				annyang.pause();
    				speakText("달력 정보입니다");
    				annyang.resume();
    			} else if(script == "달력끄기") {
    				$.mobile.changePage("<%=application.getContextPath()%>/page/main.jsp", { transition: "fade", prefetch: "true" });
    				annyang.pause();
    				speakText("달력을 종료합니다.");
    				annyang.resume();
    			} else if(script == "카메라") {
    				$.mobile.changePage("<%=application.getContextPath()%>/page/camera.jsp", { transition: "fade", prefetch: "true" });
    				annyang.pause();
    				speakText("카메라 정보입니다");
    				annyang.resume();
    			} else if(script == "카메라끄기") {
    				$.mobile.changePage("<%=application.getContextPath()%>/page/main.jsp", { transition: "fade", prefetch: "true" });
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
    			}
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
    			margin-top:50px;
    		}.pageFooter {
    			border:black;
    		}
    	</style>
	</head>
	<body class="" id="body" style="background-color:black;text-align:center;">
		<div data-role="header" data-position="fixed" class="pageHeader" style="background-color:black;color:white;">
		  	<div class="row">
		  		<div class="col-md-7">
		  			
		  		</div>
		  		<div class="col-md-5">
		  			<div class="clock">
					<div id="Date"></div>
					  <ul class="clockul">
					      <li id="hours" class="clockli"></li>
					      <li id="point" class="clockli">:</li>
					      <li id="min" class="clockli"></li>
					      <li id="point" class="clockli">:</li>
					      <li id="sec" class="clockli"></li>
					  </ul>
					</div>
		  		</div>
		  	</div>
		</div>
		  
		<div data-role="page">
		  <div role="main" class="ui-content">
		  </div>
		</div>
		
		<div data-role="footer" data-position="fixed" class="pageFooter" style="background-color:black;color:white;">
		  <h1></h1>
		</div>
	</body>
</html> 
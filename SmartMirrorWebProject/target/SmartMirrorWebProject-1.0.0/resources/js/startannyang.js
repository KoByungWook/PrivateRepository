$(function() {
	annyang.start({autoRestart: true , continuous: true});
	var recognition = annyang. getSpeechRecognizer();
	var final_transcript = '';
	recognition.interimResults = true;
	recognition.onresult = function(event){
		var interim_transcript = ' ';
		final_transcript='';
		for(var i =event.resultIndex; i<event.results.length; ++i) {
			if(event.results[i].isFinal){
				final_transcript+=event.results[i][0].transcript;
				console.log("final_transcript=" +final_transcript);
				console.log("confidence=" + event.results[i][0].confidence);
				
				$('#speech').html(final_transcript);
				checkScript(final_transcript);
			}else{
				interim_transcript+=event.results[i][0].transcript;
				$('#speech').html(interim_transcript);
			}
		}
	};
	annyang.addCallback('error', function () {
		console.log(new Date());
	});
});
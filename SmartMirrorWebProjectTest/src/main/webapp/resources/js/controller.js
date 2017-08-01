function openCalander() {
	$.ajax({
	    type : "GET",
	    url : "/SmartMirrorWebProjectTest/calander",
	    dataType : "text",
	    error : function() {
	      alert('error');
	    },
	    success : function(data) {
	      $('#content').html(data);
	    }
	  });
}

function openMap() {
	$.ajax({
	    type : "GET",
	    url : "/SmartMirrorWebProjectTest/map",
	    dataType : "text",
	    error : function() {
	      alert('error');
	    },
	    success : function(data) {
	      $('#content').html(data);
	      initMap();
	    }
	  });
}

function openCamera() {
	$.ajax({
	    type : "GET",
	    url : "/SmartMirrorWebProjectTest/camera",
	    dataType : "text",
	    error : function() {
	      alert('error');
	    },
	    success : function(data) {
	      $('#content').html(data);
	    }
	  });
}

function showBoxOffice() {
	$.ajax({
	    type : "GET",
	    url : "/SmartMirrorWebProjectTest/movie",
	    error : function() {
	      alert('error');
	    },
	    success : function(data) {
	    	$('#content').html(data);
	    }
	  });
}

function snapshot() {
	$.ajax({
		type : "GET",
		url : "/SmartMirrorWebProjectTest/snapshot",
		error : function() {
			alert('error');
		},
		success : function(data) {
			var modal = document.getElementById('myModal');
			$("#snapshot").attr("src", data.filepath);
			setTimeout(showModal, 1000);
			
			setTimeout(closeModal, 3000);
		}
	});
}

function showModal() {
	modal.style.display = "block";
}

function closeModal() {
	modal.style.display = "none";
}

function close() {
	$('#content').empty();
}
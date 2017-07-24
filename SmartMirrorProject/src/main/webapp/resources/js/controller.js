function openCalander() {
	$.ajax({
	    type : "GET",
	    url : "resources/content/calander.jsp",
	    dataType : "text",
	    error : function() {
	      alert('통신실패!!');
	    },
	    success : function(data) {
	      $('#content').html(data);
	    }
	  });
}
var chartSpeed;

$(function() {
	var gaugeOptions = {

	    chart: {
	        type: 'solidgauge'
	    },

	    title: null,

	    pane: {
	        center: ['50%', '85%'],
	        size: '140%',
	        startAngle: -90,
	        endAngle: 90,
	        background: {
	            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
	            innerRadius: '60%',
	            outerRadius: '100%',
	            shape: 'arc'
	        }
	    },

	    tooltip: {
	        enabled: false
	    },

	    // the value axis
	    yAxis: {
	        stops: [
	            [0.1, '#55BF3B'], // green
	            [0.5, '#DDDF0D'], // yellow
	            [0.9, '#DF5353'] // red
	        ],
	        lineWidth: 0,
	        minorTickInterval: null,
	        tickAmount: 2,
	        title: {
	            y: -70
	        },
	        labels: {
	            y: 16
	        }
	    },

	    plotOptions: {
	        solidgauge: {
	            dataLabels: {
	                y: 5,
	                borderWidth: 0,
	                useHTML: true
	            }
	        }
	    }
	};

	// The speed gauge
	chartSpeed = Highcharts.chart('container-speed', Highcharts.merge(gaugeOptions, {
	    yAxis: {
	        min: 0,
	        max: 4095,
	        title: {
	            text: 'Speed'
	        }
	    },

	    credits: {
	        enabled: false
	    },

	    series: [{
	        name: 'Speed',
	        data: [0],
	        dataLabels: {
	            format: '<div style="text-align:center"><span style="font-size:25px;color:' +
	                ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>' +
	                   '<span style="font-size:12px;color:silver">km/h</span></div>'
	        },
	        tooltip: {
	            valueSuffix: ' km/h'
	        }
	    }]

	}));
});

var speedupIntervalId;
var speed;
var point;

function setSpeedGaugeDefault(defaultspeed) {
	console.log(defaultspeed);
	point = chartSpeed.series[0].points[0];
	point.update(Number(defaultspeed));
}

function speedup(tempspeed) {
	speed = tempspeed;
	speedupIntervalId = setInterval(keepspeedup, 100);
}

function stopspeedup() {
	clearInterval(speedupIntervalId);
}

function keepspeedup() {
	speed = speed + 10;
	var json = {"command":"change", "direction":"forward", "speed":speed};
	$.ajax({
		url:"http://" + location.host + "/SensingCarRemoteWebControlProject/backtire",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#backtirespeedup").attr("onmouseover","speedup(" + speed + ")");
				$("#backtirespeedup").html(speed);
				point = chartSpeed.series[0].points[0];
				point.update(speed);
			}
		}
	});
}

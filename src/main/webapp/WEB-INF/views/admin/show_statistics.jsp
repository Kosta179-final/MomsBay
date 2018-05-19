<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ 'Task', 'Hours per Day' ], [ 'Work', 11 ], [ 'Eat', 2 ],
				[ 'Commute', 2 ], [ 'Watch TV', 2 ], [ 'Sleep', 7 ] ]);

		var options = {
			title : 'My Daily Activities',
			pieHole : 0.4,
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('donutchart'));
		chart.draw(data, options);
	}
	
	google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawMultSeries);

	function drawMultSeries() {
	      var data = google.visualization.arrayToDataTable([
	        ['City', '2010 Population', '2000 Population'],
	        ['New York City, NY', 8175000, 8008000],
	        ['Los Angeles, CA', 3792000, 3694000],
	        ['Chicago, IL', 2695000, 2896000],
	        ['Houston, TX', 2099000, 1953000],
	        ['Philadelphia, PA', 1526000, 1517000]
	      ]);

	      var options = {
	        title: 'Population of Largest U.S. Cities',
	        chartArea: {width: '50%'},
	        hAxis: {
	          title: 'Total Population',
	          minValue: 0
	        },
	        vAxis: {
	          title: 'City'
	        }
	      };

	      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	      chart.draw(data, options);
	    }
</script>
<div class="container">
	<div class="col-sm-8">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#donutchart">회원자녀 통계</a></li>
			<li><a data-toggle="tab" href="#chart_div">게시글 통계</a></li>
			<li><a data-toggle="tab" href="#menu2">회원가입 통계</a></li>
			<li><a data-toggle="tab" href="#menu3">시간대 별 접속자 수</a></li>
		</ul>
	</div>
	<div class="tab-content row text-left col-sm-8">
		<div id="donutchart" class="tab-pane fade in active" style="width: 900px; height: 500px;"></div>
		<div id="chart_div" class="tab-pane fade in active" style="width: 900px; height: 500px;"></div>
	</div>
</div>
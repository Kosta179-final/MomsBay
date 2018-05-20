<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

/* 페이지 로딩시 첫 화면에 통계를 가져오는 js */
	google.charts.load("current", {
		packages : [ "corechart" ]
	});
	
	google.charts.setOnLoadCallback(drawChart);
	google.charts.setOnLoadCallback(drawGradeChart);
	
	function drawGradeChart(){
		var dataForGradeChart = new google.visualization.DataTable();
		dataForGradeChart.addColumn('string', '회원등급');
		dataForGradeChart.addColumn('number', '회원수');

		dataForGradeChart.addRows([['관리자',${statistics_ofGrade.admin}]]);
		dataForGradeChart.addRows([['일반회원',${statistics_ofGrade.member}]]);
		dataForGradeChart.addRows([['블랙리스트 회원',${statistics_ofGrade.blacklist}]]);				

		var optionsForGradeChart = {
			title : '자료추합 기간\n 오픈일~'+new Date().toISOString().slice(0,10),
			pieHole : 0.4,
			colors: ['#dda0dd','#9400D3','#FFD2D2']
		};
		
		var gradeChart = new google.visualization.PieChart(document
				.getElementById('piechart'));
		gradeChart.draw(dataForGradeChart, optionsForGradeChart);
	}

	function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', '성별');
		data.addColumn('number', '명');
		
		data.addRows([
			${statistics_ofChildren}
		]);
		
		var options = {
			title : '자료추합 기간\n 오픈일~'+new Date().toISOString().slice(0,10),
			pieHole : 0.4,
			colors: ['#FF5050', '#FFB291']
		};

		/* 자녀통계 */
		var chart = new google.visualization.PieChart(document
				.getElementById('donutchart'));
		chart.draw(data, options);
	}
	/* 여기까지 파이차트 */
	
</script>
<div class="container">
	<div class="col-sm-8">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#donutchart">회원자녀 통계</a></li>
		</ul>
	</div>
	<div class="tab-content col-sm-8">
		<div id="donutchart" class="tab-pane fade in active" style="width: 900px; height: 500px;"></div>
	</div>
	<div class="col-sm-8">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#donutchart">회원 등급별 통계</a></li>
		</ul>
		<div class="tab-content col-sm-8">
			<div id="piechart" class="tab-pane fade in active" style="width: 900px; height: 500px;"></div>
		</div>
	</div>
</div>
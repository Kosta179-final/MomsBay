<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function(){
  /*
  	현재 페이지에 대한 메뉴 표시를 위한 css 설정
  */
	var requestUrl=location.href;
	var categoryId;
 	
	if(requestUrl.indexOf('getPeopleList.do')!=-1){ // 회원등급 관리 페이지 일때
		categoryId='#peopleList';
	} else if(requestUrl.indexOf('getStatistics.do')!=-1){ // 찜 목록 페이지 일때
		categoryId='#statistics';
	}
	$(categoryId).closest('.panel-collapse').removeClass('collapse');
	$(categoryId).closest('.panel-collapse').addClass('in');
	$(categoryId).css({
		"color": "#FE980F",
		"text-decoration": "underline"
	});
	
 });
</script>

	<div class="left-sidebar" style="margin-bottom: 30px;">
		<h2>Admin Page</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#a">
							<span class="pull-right"><i class="fa fa-plus"></i></span>
							회원 관리
						</a>
					</h3>
				</div>
				<div id="a" class="panel-collapse collapse" style="height: auto;">
					<div class="panel-body">
						<ul>
							<li><a id="peopleList" href="getPeopleList.do">회원 등급 관리</a></li>
							<li><a href="#">QNA 답변 대기글</a></li>
							<li><a href="#">신고 내역</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#b">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							사이트 분석
						</a>
					</h3>
				</div>
				<div id="b" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a id="statistics" href="getStatistics.do">회원 통계</a></li>
							<li><a href="#">거래 통계</a></li>
							<li><a href="#">포인트 통계</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#c">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							추후 추가예정
						</a>
					</h4>
				</div>
				<div id="c" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="#">*****</a></li>
							<li><a href="#">*****</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--/category-products-->

		<div class="shipping text-center">
			<!-- 광고  -->
			<img
				src="${pageContext.request.contextPath}/resources/images/home/shipping.jpg"
				alt="" />
		</div>
		<!--/shipping-->

	</div>

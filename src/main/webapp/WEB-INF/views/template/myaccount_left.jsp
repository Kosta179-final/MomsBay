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
 	
	if(requestUrl.indexOf('findTradeHistoryListById.do')!=-1){ // 거래내역 페이지 일때
		categoryId='#tradeHistory';
	} else if(requestUrl.indexOf('findPickListById.do')!=-1){ // 찜 목록 페이지 일때
		categoryId='#pickHistory';
	} else if(requestUrl.indexOf('getPointHistoryById.do')!=-1){ // 포인트 내역 페이지 일때
		categoryId='#pointHistory';
		$(categoryId).closest('.panel-collapse').removeClass('collapse');
		$(categoryId).closest('.panel-collapse').addClass('in');
	} else if(requestUrl.indexOf('findNowpointById.do')!=-1){ // 포인트 충전/환전 페이지 일때
		categoryId='#nowPoint';
		$(categoryId).closest('.panel-collapse').removeClass('collapse');
		$(categoryId).closest('.panel-collapse').addClass('in');
	} else if(requestUrl.indexOf('password_check.do')!=-1 || requestUrl.indexOf('modify_myinfo.do')!=-1){ // 회원정보 수정 비밀번호 확인 페이지
		categoryId='#modify';
		$(categoryId).closest('.panel-collapse').removeClass('collapse');
		$(categoryId).closest('.panel-collapse').addClass('in');
	} else{
		categoryId='#myinfo';
		$(categoryId).closest('.panel-collapse').removeClass('collapse');
		$(categoryId).closest('.panel-collapse').addClass('in');
	}
	$(categoryId).css({
		"color": "#FE980F",
		"text-decoration": "underline"
	});
	
 });
</script>

	<div class="left-sidebar" style="margin-bottom: 30px;">
		<h2>My Page</h2>
		<div class="panel-group category-products" id="accordian">
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="tradeHistory" href="findTradeHistoryListById.do?boardTypeNo=1">
							거래내역
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="pickHistory" href="findPickListById.do">
							찜목록
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#b">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							포인트
						</a>
					</h4>
				</div>
				<div id="b" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a id="pointHistory" href="getPointHistoryById.do">포인트 내역</a></li>
							<li><a id="nowPoint" href="findNowpointById.do">포인트 충전/환전</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#c">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							회원정보
						</a>
					</h4>
				</div>
				<div id="c" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a id="myinfo" href="findMypointById.do">내 정보</a></li>
							<li><a id="modify" href="password_check.do">회원정보 수정</a></li>
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

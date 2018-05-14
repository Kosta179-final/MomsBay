<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="left-sidebar">
		<h2>My Page</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#a">
							<span class="pull-right"><i class="fa fa-plus"></i></span>
							거래내역
						</a>
					</h3>
				</div>
				<div id="a" class="panel-collapse collapse" style="height: auto;">
					<div class="panel-body">
						<ul>
							<li><a href="#">총 내역 </a></li>
							<li><a href="#">판매내역 </a></li>
							<li><a href="#">구매내역 </a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#b">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							포인트내역
						</a>
					</h3>
				</div>
				<div id="b" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="#">총 내역</a></li>
							<li><a href="#">사용 내역</a></li>
							<li><a href="#">충전 내역</a></li>
							<li><a href="#">환전 내역</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#c">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 
							회원정보 수정
						</a>
					</h4>
				</div>
				<div id="c" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="#">회원 탈퇴</a></li>
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

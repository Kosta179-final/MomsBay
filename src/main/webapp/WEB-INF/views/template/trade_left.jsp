<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="left-sidebar">
		<h2>카테고리</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#a">
							<span class="pull-right"><i class="fa fa-plus"></i></span>
							아기띠/외출용품
						</a>
					</h4>
				</div>
				<div id="a" class="panel-collapse collapse" style="height: auto;">
					<div class="panel-body">
						<ul>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=1">유모차 </a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=2">카시트 </a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=3">아기띠 </a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#b">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 의류/잡화
						</a>
					</h4>
				</div>
				<div id="b" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=4">유아동 의류</a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=5">신생아 의류</a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=6">신발</a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=7">인형</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#c">
							<span class="pull-right"><i class="fa fa-plus"></i></span> 목욕/위생
						</a>
					</h4>
				</div>
				<div id="c" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=8">물티슈</a></li>
							<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1&categoryNo=9">욕조/탕 온도계/샴푸캡</a></li>
						</ul>
					</div>
				</div>
			</div>
			 	<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#d">
							<span class="pull-right"><i class="fa fa-plus"></i></span>
							수유/분유/이유식
						</a>
					</h4>
				</div>
				<div id="d" class="panel-collapse collapse">
					<div class="panel-body">
						<ul>
							<li><a href="#">수유용품</a></li>
							<li><a href="#">분유</a></li>
							<li><a href="#">이유식</a></li>
							<li><a href="#">이유용품</a></li>
						</ul>
					</div>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#e">
							<span class="pull-right"><i class="fa fa"></i></span> 침구류
						</a>
					</h4>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#f">
							<span class="pull-right"><i class="fa fa"></i></span> 임부복
						</a>
					</h4>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#g">
							<span class="pull-right"><i class="fa fa"></i></span> 위생용품/안전용품
						</a>
					</h4>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#h">
							<span class="pull-right"><i class="fa fa"></i></span> 출산용품
						</a>
					</h4>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#h">
							<span class="pull-right"><i class="fa fa"></i></span> 도서/교육
						</a>
					</h4>
				</div>
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#h">
							<span class="pull-right"><i class="fa fa"></i></span> 장난감
						</a>
					</h4>
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

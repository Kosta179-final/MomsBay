<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header_top">
	<!--header_top-->
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="contactinfo">
					<ul class="nav nav-pills">
						<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88
								821</a></li>
						<li><a href="#"><i class="fa fa-envelope"></i>
								info@domain.com</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="social-icons pull-right">
					<ul class="nav navbar-nav">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
						<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!--/header_top-->

<div class="header-middle">
	<!--header-middle-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="logo pull-left">
					<a href="${pageContext.request.contextPath}/home.do">
					<img src="${pageContext.request.contextPath}/resources/images/home/logo.png" alt="" />
					</a>
				</div>
				<div class="btn-group pull-right"></div>
			</div>
			<div class="col-sm-8">
				<div class="shop-menu pull-right">
					<ul class="nav navbar-nav">
					<%--세션에 멤버정보의 유무에 따라 구분  --%>
						<c:choose>
							<c:when test="${empty member}">
								<li><a href="${pageContext.request.contextPath}/member/login_view.do"><i class="fa fa-lock"></i> 로그인</a></li>
								<li><a href="${pageContext.request.contextPath}/member/register_terms.do"><i class="fa fa-user-plus"></i> 회원가입</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${member.grade eq 'member'}">
								<li><a href="${pageContext.request.contextPath}/myaccount/getPointHistoryById.do"><i class="fa fa-user"></i> 내 계정</a></li>
								</c:if>
								<c:if test="${member.grade  eq 'admin'}">
								<li><a href="#"><i class="fa fa-user"></i> 관리자 페이지</a></li>
								</c:if>
								<li><a href="#"><i class="fa fa-heart"></i> 찜목록</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> 쪽지</a></li>
								<li><a href="${pageContext.request.contextPath}/member/logout.do"><i class="fa fa-unlock"></i> 로그아웃</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!--/header-middle-->

<div class="header-bottom">
	<!--header-bottom-->
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="mainmenu pull-left">
					<ul class="nav navbar-nav collapse navbar-collapse">
						<li><a href="${pageContext.request.contextPath}/home.do"
							class="active">Home</a></li>
						<li class="dropdown"><a href="#this">중고나라<i
								class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu">
								<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=1">삽니다</a></li>
								<li><a href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=2">팝니다</a></li>
								<li><a	href="${pageContext.request.contextPath}/trade/list_share_post.do?boardTypeNo=3">나눔</a></li>
								<li><a href="${pageContext.request.contextPath}/trade/exchange_list.do?boardTypeNo=4">교환</a></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/bay/list_bulletin_board.do?boardTypeNo=5">자유게시판</a></li>
						<li><a href="${pageContext.request.contextPath}/bay/qna_board_list.do?boardTypeNo=6">Q &amp; A</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="search_box pull-right">
					<input type="text" placeholder="Search" />
				</div>
			</div>
		</div>
	</div>
</div>
<!--/header-bottom-->
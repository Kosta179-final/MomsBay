<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
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
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="${pageContext.request.contextPath}/home.do"><img src="${pageContext.request.contextPath}/resources/images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> 내 계정</a></li>
								<li><a href="#"><i class="fa fa-shopping-cart"></i> 찜 목록</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> 쪽지</a></li>
								<li><a href="${pageContext.request.contextPath}/member/loginView.do"><i class="fa fa-lock"></i> 로그인</a></li>
								<li><a href="#"><i class="fa fa-unlock"></i> 로그아웃</a></li>
								<li><a href="#"><i class="fa fa-user-plus"></i> 회원가입</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="${pageContext.request.contextPath}/home.do" class="active">Home</a></li>
								<li class="dropdown"><a href="#this">중고나라<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="${pageContext.request.contextPath}/trade/main_buy.do">삽니다</a></li>
										<li><a href="${pageContext.request.contextPath}/trade/main_sell.do">팝니다</a></li> 
										<li><a href="${pageContext.request.contextPath}/trade/main_share.do">나눔</a></li>
										<li><a href="${pageContext.request.contextPath}/trade/main_exchange.do">교환</a></li> 
                                    </ul>
                                </li> 
								<li><a href="${pageContext.request.contextPath}/board/main_free_board.do">자유게시판</a></li>
								<li><a href="${pageContext.request.contextPath}/board/main_qna_board.do">Q &amp; A</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
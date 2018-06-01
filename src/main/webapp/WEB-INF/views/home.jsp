<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${pageContext.request.contextPath}/resources/css/list-image-hover.css" rel="stylesheet">
<section id="slider">
	<!--slider-->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div id="slider-carousel" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#slider-carousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#slider-carousel" data-slide-to="1"></li>
						<li data-target="#slider-carousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						
						
						<div class="item active">
							<div class="col-sm-12">
								<img style="border: 3px;border-radius: 7px;-moz-border-radius: 7px;-khtml-border-radius: 7px;-webkit-border-radius: 7px" src="resources/images/home/아기첫번째.png" class="girl img-responsive"
									alt="" /> 
							</div>
						</div>
						
						
						<div class="item">
							<div class="col-sm-12">
								<img style="border: 3px;border-radius: 7px;-moz-border-radius: 7px;-khtml-border-radius: 7px;-webkit-border-radius: 7px" src="resources/images/home/아기7.png" class="girl img-responsive"
									alt="" />
							</div>
						</div>
						
						
						<div class="item">
							<div class="col-sm-12">
								<img style="border: 3px;border-radius: 7px;-moz-border-radius: 7px;-khtml-border-radius: 7px;-webkit-border-radius: 7px" src="resources/images/home/원피스7.png" class="girl img-responsive"
									alt="" /> 
							</div>
						</div>
					</div>

					<a href="#slider-carousel" class="left control-carousel hidden-xs"
						data-slide="prev"> <i class="fa fa-angle-left"></i>
					</a> <a href="#slider-carousel"
						class="right control-carousel hidden-xs" data-slide="next"> <i
						class="fa fa-angle-right"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/slider-->


<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 padding-right">
					<div class="features_items"><!-- 최근 등록 상품 -->
						<h2 class="title text-center">최근 등록 상품</h2>
						<div class="col-sm-12">
							
						<div class="product-image-wrapper">
						<div class="single-products">
							<c:forEach items="${requestScope.mainList.list}" var="tpVO" varStatus="i">
								<%-- 게시물 1개 목록 --%>
								<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<div class="list-img" onclick="location.href='trade/detail_trade_post.do?tradePostNo=${tpVO.tradePostNo}'">
													<c:if test="${tpVO.imgAddress eq 'noPhoto'}">
														<img src="${pageContext.request.contextPath}/resources/upload/images/default.png" >
													</c:if>
													<c:if test="${tpVO.imgAddress ne 'noPhoto'}">
														<img src="${pageContext.request.contextPath}/resources/upload/postImg/${tpVO.imgAddress }" >
													</c:if>
												</div>
												
												<div class="row" style="border-bottom: 1px solid #eee; padding: 10px;">
								                     <strong style="margin: 20px;">
								                        <span class="title" style="display:inline-block; width:230px; overflow:hidden; text-overflow:ellipsis; white-space:nowrap;">
								                           ${tpVO.title}
								                        </span>
								                     </strong>
								                  </div>
											     <div align="left" style="padding: 10px;">
													<div class="col-sm-10">
							                           <strong>
							                              <span class="postPrice">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;₩&nbsp;<fmt:formatNumber value="${tpVO.price}" pattern="#,###.##"/></span><br>
							                           </strong>
							                        </div>
												</div>
												<div class="row">
								                     <div class="col-sm-9" style="padding-left: 0px;">
								                        <div class="tradeId">글쓴이 &nbsp;: &nbsp;&nbsp;${tpVO.memberVO.name}</div>
								                     </div>
								                     <div class="col-sm-3">
								                        <c:if test="${tpVO.status!='거래대기'}">
								                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-danger">${tpVO.status}</span>
								                        </c:if>
								                     </div>
								                  </div>
											</div>
										</div>
										<div class="choose">
											<ul class="nav nav-pills nav-justified">
												<li><a class = "btn btn-primary" href="trade/detail_trade_post.do?tradePostNo=${tpVO.tradePostNo}">
												</a></li>
											</ul>
										</div>
									</div>
								</div>	
							</c:forEach>
						</div>
						</div>
							
							<!-- <div class="product-image-wrapper">
								최근 상품1
							</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="resources/images/home/product2.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="resources/images/home/product3.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div> -->
					</div><!-- 최근 등록 상품 -->
				</div>
			</div>
		</div>
<!-- 자녀 추천상품 기능 close -->					
<!-- 		<div class="container">
			<div class="row">
				<div class="col-sm-12 padding-right">
					<div class="recommended_items"> 자녀추천 
						<h2 class="title text-center">{자녀이름} 추천 상품</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resources/images/home/recommend1.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resources/images/home/recommend2.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="resources/images/home/recommend3.jpg" alt="" />
													<h2>$56</h2>
													<p>Easy Polo Black Edition</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>
												
											</div>
										</div>
									</div>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div>자녀 추천 아이템
				</div>
			</div>
		</div> -->
	</div>
	</section>

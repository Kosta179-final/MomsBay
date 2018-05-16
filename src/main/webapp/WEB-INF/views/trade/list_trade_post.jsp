<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="features_items">
	<div class="row">
		<!--features_items-->
		<h2 class="title text-center">게시글 목록</h2>
		
		
		<c:forEach items="${requestScope.listVO.list}" var="tpVO">
		<%-- 게시물 1개 목록 --%>
		<div class="col-sm-4">
			<div class="product-image-wrapper">
				<div class="single-products">
					<div class="productinfo text-center">
						<img
							src="${pageContext.request.contextPath}/resources/upload/images/stroller.jpg"
							alt=""/>
						<h2>${tpVO.price}원</h2>
						<p>${tpVO.title}</p>
					</div>
				</div>
				<div class="choose">
					<ul class="nav nav-pills nav-justified">
						<li><a class = "btn btn-primary" href="${pageContext.request.contextPath}/trade/detail_trade_post.do">
							<i class="fa fa-plus-square"></i>상세보기
						</a></li>
						<li><a href="#" class="btn btn-primary"><i
							class="fa fa-heart"></i>찜하기</a></li>
					</ul>
				</div>
			</div>
		</div>	
		</c:forEach>
		
	</div>
	<div class="row">
		<div class="col-sm-11">
			<div align="right">
				<button name="button" class="btn btn-primary" id="addPost.do">글쓰기</button><br>
			</div>
		</div>
	</div>
	<div class="row" style="width: 50">
		
		<div class="pagingInfo">
			<c:set var="pb" value="${requestScope.listVO.pagingBean}"></c:set>
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a
						href="bulletin_board_list.do?pageNo=${pb.startPageOfPageGroup-1}&type=${requestScope.type}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
					end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a
								href="bulletin_board_list.do?pageNo=${i}&type=${requestScope.type}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="#this">${i}</a></li>
						</c:otherwise>
					</c:choose>
					&nbsp;
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a
						href="bulletin_board_list.do?pageNo=${pb.endPageOfPageGroup+1}&type=${requestScope.type}">&raquo;</a>
					</li>
				</c:if>
			</ul>
		</div>
		
		
	</div>
</div>
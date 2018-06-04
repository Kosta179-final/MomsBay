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
 	
	if(requestUrl.indexOf('getReceiveMessageList.do')!=-1){ // 받은 쪽지함 페이지 일때
		categoryId='#receive';
	} else if(requestUrl.indexOf('getSendMessageList.do')!=-1){ // 보낸 쪽지함 목록 페이지 일때
		categoryId='#send';
	} else if(requestUrl.indexOf('getTotalMessageList.do')!=-1){ // 전체 쪽지함 목록 페이지 일때
		categoryId='#total';
	} else{ //쪽지쓰기
		categoryId='#write';
	} 
	$(categoryId).css({
		"color": "#FE980F",
		"text-decoration": "underline"
	});
	
 });
</script>
	<div class="left-sidebar" style="margin-bottom: 30px;">
		<h2>Message</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="write" href="add_message_form.do">
							쪽지쓰기
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="total" href="getTotalMessageList.do?id=${sessionScope.member.id}">
							전체 쪽지함
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="receive" href="getReceiveMessageList.do?id=${sessionScope.member.id}">
							받은 쪽지함
						</a>
					</h3>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a id="send" href="getSendMessageList.do?id=${sessionScope.member.id}">
							보낸 쪽지함
						</a>
					</h3>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="left-sidebar" style="margin-top: 65px; height: 500px;">
		<h2>Message</h2>
		<div class="panel-group category-products" id="accordian">
			<!--category-productsr-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="add_message_form.do">
							쪽지쓰기
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="getTotalMessageList.do?id=${sessionScope.member.id}">
							전체 쪽지함
						</a>
					</h3>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="getReceiveMessageList.do?id=${sessionScope.member.id}">
							받은 쪽지함
						</a>
					</h3>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<a href="getSendMessageList.do?id=${sessionScope.member.id}">
							보낸 쪽지함
						</a>
					</h3>
				</div>
			</div>
		</div>
		<!--/category-products-->

	</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		$(".serviceYet").click(function() {
			//var menuItem = $(this).c
			$("#terms").removeClass("in");
			if ($("#terms").attr('aria-expanded') === 'true') {
				console.log("hello");
				$("#terms").attr('aria-expanded', 'false');
				console.log("hello2");
			}
			alert("서비스 예정입니다.");
		});
		$("#chargeBtn").click(function() {
			var point = $("#point").val();
			if (point < 1000) {
				alert("1000원 이상부터 충전이 가능합니다.");
				return false;
			} else {
				var flag_num = point % 1000;
				if (flag_num == 0) {
					return true;
				} else {
					alert("1000단위로만 충전이 가능합니다.");
					return false;
				}
			}
		});
	});
</script>

<style>
.btn-success {
	padding: 10px;
}
</style>

<form action="chargePoint.do" method="post" id="chargeForm">
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">포인트 충전</a></li>
			<li><a data-toggle="tab" href="#menu1">포인트 환전</a></li>
		</ul>

		<div class="tab-content row text-left col-sm-8">

			<div id="home" class="tab-pane fade in active">
				<h3>포인트란?</h3>
				<p>맘스베이에서 서비스하는 제품의 컨텐츠를 이용하기 위해 회원이 구매하는 인터넷 상의 결제수단입니다.</p>
				<div class="btn-group" style="width: 100%; padding-bottom: 10px">
					<button type="button" style="width: 30%" class="serviceAble btn btn-success" data-toggle="collapse" data-target="#terms">휴대폰 결제</button>
					<button type="button" style="width: 30%" class="serviceYet btn btn-success">상품권</button>
					<button type="button" style="width: 30%" class="serviceYet btn btn-success">기타</button>
				</div>
				<br>
				<div class="btn-group" style="width: 100%">
					<button type="button" style="width: 30%" class="serviceYet btn btn-success">삼성페이</button>
					<button type="button" style="width: 30%" class="serviceYet btn btn-success">네이버 페이</button>
					<button type="button" style="width: 30%" class="serviceYet btn btn-success">Toss</button>
				</div>
				<br> <br>
				<div id="terms" class="collapse">
					<p>충전요금은 다음달 휴대폰 요금 고지서의 정보이용료 항목으로 통합 청구됩니다.</p>
					<p>휴대폰번호 명의자의 주민등록번호와 입력한 주민등록번호가 일치해야 하며</p>
					<p>미성년자, 법인 휴대폰은 이용할 수 없습니다</p>
					<p>충전은 1000원 단위로 선택 가능합니다.</p>
					<hr>
					<label>현재 보유 포인트: ${point }</label> <br> 
					<label>충전 포인트:</label> <input type="text" name="point" id="point" placeholder="ex)100000" style="width: 100px;" required="required">
					<button type="button" id="chargeBtn" class="btn btn-default" data-toggle="modal" data-target="#myModal">충전하기</button>
				</div>
			</div>
		</div>
		<!--  modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">휴대폰 결제</h4>
					</div>

					<div class="modal-body">
						<p>휴대폰 번호</p>
						<input type="text" class="form-control" placeholder="ex)010-1234-5678" style="width: 30%; margin: 0 auto; padding-bottom: 10px;" required="required"> 
						<input type="button" onclick="document.getElementById('chargeForm').submit();" class="btn btn-info form-control" style="width: 30%; margin: 0 auto;" data-dismiss="modal" value="확인">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
</div>
</form>

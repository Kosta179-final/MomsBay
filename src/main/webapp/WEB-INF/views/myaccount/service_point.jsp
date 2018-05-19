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
		
		$("#exchangeBtn").click(function() {
			var point = $("#excPoint").val();
			if(point==''){
				alert("환전금액을 입력 해 주세요.");
				return false;
			}else if(point > ${point}) {
				alert("환전 가능 금액보다 큽니다. \n다시 입력해주세요.");
				return false;
			} else {
				return true;
			}
		});
		
		$("#exgBtn").click(function(){
			var input = $("<input>").attr("type", "password").attr("name", "exchangePoint").val($('#excPoint').val());
			 $('#exgForm').append($(input));
			$("#exgForm").submit();
		});
	});
</script>

<style>
.btn-success {
	padding: 10px;
}
</style>


<div class="container">
	<div class="col-sm-8">
		<ul class="nav nav-tabs ">
			<li class="active"><a data-toggle="tab" href="#pointCharge">포인트 충전</a></li>
			<li><a data-toggle="tab" href="#pointExchange">포인트 환전</a></li>
		</ul>
		</div>
		<div class="tab-content row text-left col-sm-8">
			<div id="pointCharge" class="tab-pane fade in active">
			<form action="chargePoint.do" method="post" class="exgForm" id="chargeForm">
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
			</form>
			</div>
			
			<div id="pointExchange" class="tab-pane fade">
			<!-- <form class="exgForm" action="exchangePoint.do"> -->
				<h3>포인트 환전 방법</h3>
				<p>1.현재 보유한 포인트를 확인합니다.</p>
				<p>2.환전할 포인트 액수를 입력합니다.</p>
				<p>3.환전 받을 계좌번호와 은행을 입력합니다.</p>
				<p>4.비밀번호를 입력하면 환전신청이 완료됩니다.</p>
				<p>5.환전은 3-4일 후 해당 계좌에서 확인하실 수 있습니다.</p>
				<hr>
				<div class="btn-group" style="width: 100%; padding-bottom: 10px">
					<label>현재 보유 포인트: ${point }</label> <br> 
					<label>환전 할 포인트:</label> 
					<input type="number" name="exchangePoint" id="excPoint" placeholder="ex)10000" style="width: 100px;" required="required">				
					<hr>
					<label>환불받을 계좌 정보</label>					
					<select  style="width: 100px;">
					<option>신한</option>
					<option>우리</option>
					<option>국민</option>
					<option>IBK</option>
					<option>하나</option>
					</select>
					<label>계좌번호:</label>	<input type="number" placeholder="-는 빼고 입력해주세요." style="width: 200px;" required="required">
					<br>
					
					<input type="button" id="exchangeBtn" class="btn btn-default" data-toggle="modal" data-target="#passwordModal" value="환전하기">
				</div>
				<br>
				<br> <br>
				<div id="terms" class="collapse">				
				</div>
			<!-- </form> -->
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
		
						<!-- Modal content-->
		<div class="modal fade" id="passwordModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">환전 페이지</h4>
					</div>

					<div class="modal-body">
						<p>비밀번호를 입력해 주세요.</p>
						<div>
						<form id="exgForm" action="exchangePoint.do">
						<input type="password" min="0" name="password" id="password" class="form-control" placeholder="password" style="width: 30%; margin: 0 auto;" required="required"> 
						<input type="button" class="btn btn-info form-control" id="exgBtn"style="width: 30%; margin: 0 auto;" data-dismiss="modal" value="확인">
						</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
</div>
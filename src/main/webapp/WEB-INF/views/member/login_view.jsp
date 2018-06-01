<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#register").click(function(){
		location.href="${pageContext.request.contextPath}/member/register.do";
	});
	
	$("#findPasswordBtn").click(function(){
		if($("#name").val()=="" ||$("#email").val()=="" ){
			alert("이름과 이메일을 입력해주세요");
			return false;
		}else{
			$("#findPasswordForm").submit();
		}
	});
});
</script>
<section id="form">
	<!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<div class="login-form">
					<!--login form-->
					<h2>로그인</h2>
					<form action="${pageContext.request.contextPath}/member/login.do" id="login_form" method="post">
						<input type="text" placeholder="id" name="id" required="required" autofocus="autofocus"/>
						<input type="password" placeholder="password" name="password" required="required"/>
						<Button type="submit" id="login" style="width: 100%">로그인</Button>
						<Button type="button"  id="findPassword" style="width: 100%; background-color: tomato;" data-toggle="modal" data-target="#passwordModal">비밀번호찾기</Button>
						<Button type="button"   id="register" style="width: 100%; background-color: #FE980F;">회원가입</Button>
					</form>
				</div>
				<!--/login form-->
			</div>
		</div>
		<!-- 비밀번호 찾기 모달-->
		<div class="modal fade" id="passwordModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">비밀번호 찾기</h4>
					</div>

					<div class="modal-body">
						<p>이름과 이메일을  입력해 주세요.</p>
						<div>
						<form id="findPasswordForm" action="findPasswordByNameAndEmail.do" method="post">
						<input type="text" name="name" id="name"  class="form-control" placeholder="ex)홍길동" style="width: 30%; margin: 0 auto;" required="required" > 
						<input type="email" name="email" id="email" class="form-control" placeholder="ex)piwhd@naver.com" style="width: 30%; margin: 0 auto;" required="required"> 
						<input type="button" class="btn  btn-success form-control" id="findPasswordBtn" style="width: 30%; margin: 0 auto;" data-dismiss="modal" value="확인">
						</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"  data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/form-->

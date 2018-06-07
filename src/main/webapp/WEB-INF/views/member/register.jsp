<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
/* 자녀 추가&삭제 function */
var count = 0; 
function append_div(){
/* 	if(count==0){
		var divObj = document.getElementById('append_div');
		divObj.style.display='block'
		count++;
	}else{
 */    var div = document.createElement('div');
    div.id = "added_"+count; 
   div.innerHTML = document.getElementById('append_div').innerHTML;   
   document.getElementById('append_field').appendChild(div);
   count++; 
   
    var rmv = $(div).children('.rmv');
       if(rmv[0].style.display=='none'){
           rmv[0].style.display = 'block';
       }
       
   $(rmv).click(function(){
      document.getElementById('append_field').removeChild(div);
      count--;      
   });
	
}
/* 마지막 회원가입 등록시 flag check */
function flagTest(){
	console.log($("#idFlag").val());
	console.log($("#emailFlag").val());
	console.log($("#pwdFlag").val());
	
	if($("#idFlag").val()=="false"){
		alert("아이디 중복체크 해주세요.");
		return false;
	}else if($("#emailFlag").val()=="false"){
		alert("이메일 중복체크 해주세요.");
		return false;
	}else if($("#pwdFlag").val()=="false"){
		alert("패스워드가 일치하지 않습니다.");
		return false;
	}else{
		return true;
	}
}
$(document).ready(function(){
	/* 패스워드 체크 */
	$("#check_psw").keyup(function(){
		if($("#password").val().length<6){
			alert("패스워드를 6자 이상 입력해 주세요")
		}else if($("#password").val()==$(this).val()){ 
			$("#pwdCheck").html("일치합니다.");
			$("#pwdCheck").css("color", "orange");
			$("#pwdFlag").val("true");
		}else{
			$("#pwdCheck").html("일치하지 않습니다.");
			$("#pwdCheck").css("color", "red");
			$("#pwdFlag").val("false");
		}
	});
	
	/* 아이디 중복처리 ajax*/
	$("#idCheckbtn").click(function(){
		var condition =6;
		if($("#id").val().length<condition){
			alert("6자 이상 입력해주세요");
			}else{
				$.ajax({
						type:"get",
						dataType:"json",
						url:"idDuplicateCheck.do",
						data: "id="+$("#id").val(),
						success:function(data){
							if(data.duplicate==false){
								$("#idCheck").html("사용 가능한 아이디 입니다.");									
								$("#idCheck").css("color", "orange");
								$("#idFlag").val("true");
								}else if(data.duplicate==true){
									$("#idCheck").html("이미 사용중인 아이디 입니다.");
									$("#idCheck").css("color", "red");
									$("#idFlag").val("false");
								}else{
									$("#idCheck").html("");
								}
							}
						});
					}
		});	
	
	/* 이메일 중복처리 ajax*/
	$("#emailCheckbtn").click(function(){
			$.ajax({
				type:"get",
				dataType:"json",
				url:"mailDuplicateCheck.do",
				data: "email="+$("#email").val(),
				success:function(data){
					if(data.duplicate==false){
						$("#emailCheck").html("사용 가능한 이메일 입니다.");
						$("#emailFlag").val("true");
						$("#emailCheck").css("color", "orange");
					}else if(data.duplicate==true){
						$("#emailCheck").html("이미 사용중인 이메일 입니다.");
						$("#emailCheck").css("color", "red");
						$("#emailFlag").val("false");
					}else if(data.duplicate=='notEmail'){
						alert("이메일 형식이 아닙니다.");			
						$("#emailFlag").val("false");
					}else{
						$("#emailCheck").html("");
					}
			}
		});
	}); 
	/* 주소입력 리스너 */
	$("input[name=address]").click(function(){
		openZipSearch();
	});
	$("input[name=address]").keydown(function(){
		openZipSearch();
	});
	function openZipSearch() {
		var combine;
		daum.postcode.load(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
                
                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                combine = data.zonecode + fullAddr;
                document.getElementById('address').value = combine; //5자리 새우편번호 사용
	             // 커서를 상세주소 필드로 이동한다.
	             document.getElementById('address2').focus();
				}
			}).open();
		});
	}
});
</script>

<section id="form">
   <!--form-->
   <div class="container">
      <div class="row text-left">
       <form action="register.do" onsubmit="return flagTest();" method="post">
         <div class="col-sm-4 col-sm-offset-1 ">
         <h2>내 정보</h2>
            <hr>
            <!--registerform-->
            <input type="hidden" id="idFlag" value="false">
        	<input type="hidden" id="pwdFlag" value="false">
        	<input type="hidden" id="emailFlag" value="false">
        	
            <label  for="inputsm"><b>아이디</b></label> <br>
            <input type="text" maxlength="20" autocomplete="id" class="form-control" placeholder="6자이상 20자 이하로 입력해주세요" name="id" id="id" required>
            <input type="button" id="idCheckbtn" value="중복체크" class="btn-link"> 
            <span id="idCheck" ></span><br>    
            
            <label  for="inputsm"><b>이름</b></label> <br>
            <input type="text" maxlength="5" autocomplete="name" class="form-control" name="name" id="name" required><br>            
            
            <label for="psw"><b>비밀번호</b></label> <br>
            <input type="password" autocomplete="password" class="form-control" placeholder="비밀번호를 6자 이상 입력해주세요" name="password" required id="password"> <br>
            
            <label for="psw-repeat"><b>비밀번호 체크</b></label><br>
            <input type="password" autocomplete="password_check" class="form-control" placeholder="비밀번호를 다시 입력해주세요" id="check_psw" required>
            <span id="pwdCheck"></span><br>
            
            <label for="email"><b>이메일</b></label> <br>
            <input type="email" autocomplete="email" maxlength="30"  placeholder="ex)admin@naver.com" name="email" id="email" required class="form-control"> 
            <input type="button" id="emailCheckbtn" value="중복체크" class="btn-link"> 
            <span id="emailCheck"></span><br>
            
            <label for="tel"><b>연락처</b></label> <br>
            <input type="tel" autocomplete="tel" name="tel" required class="form-control" maxlength="11" pattern="[0-9]{10}[0-9]?" > <br>
            
            <label for="address"><b>주소</b></label> <br>
            <input type="text" autocomplete="address-level1" name="address" required class="form-control" id="address"><br>
            
            <label for="address"><b>상세주소</b></label> <br>
            <input type="text" autocomplete="address-level2"name="address2" required class="form-control" id="address2">     
            <hr>
            <p>
               By creating an account you agree to our <a href="#">Terms &amp; Privacy</a>.
            </p>
            <!--/registerform-->
         </div>
         <div class="col-sm-4 col-sm-offset-2 ">
        <%--  <form class="registerData" action="${pageContext.request.contextPath}/test.do"> --%>
         <h2>자녀 정보</h2><h5>(선택사항)</h5>            
            <div id="append_field"  class="text-left"></div>
            <hr>
            <input type="button" class="btn btn-info" onclick="append_div()" value="추가하기">
            <input type="submit" class="btn btn-success" value="회원가입">
         </div>
         </form>
         <div id="append_div" style="display: none;">
            <hr>
            <label ><b>생년월일</b></label>
            <section>
                    <select required name="year" style="width:70px;height:30px;">
                    <option value="">년도</option>
                        <%for(int i = 2017; i >= 1980; i--){ %>
                        <option value="<%=i %>"><%=i %></option>
                        <%} %>
                    </select>
                    <select required name="month" style="width:70px;height:30px;">
                    <option value="">월</option>
                        <%for(int i = 1;i <= 12; i++){ %>
                        <option value="<%=i %>"><%=i %></option>
                        <%} %>
                    </select>
                    <select required name="day" style="width:70px;height:30px;">
                    <option value="">일</option>
                       <%for(int i = 1;i <= 31; i++){ %>
                        <option value="<%=i %>"><%=i %></option>
                        <%} %>
                   </select>
                   <select required name="gender" required="required" style="width:70px;height:30px;">
                    <option value="">성별</option>
                        <option value="female">여아</option>
                        <option value="male">남아</option>
                   </select>
            </section>
            <br>
            <input type="button" class="btn btn-warning rmv" value="삭제하기"  id="rbt">
         	</div>
      </div>
   </div>
</section>
<!--/form-->
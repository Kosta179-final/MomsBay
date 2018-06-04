<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
   var flag=${boardTypeNo==1||boardTypeNo==2};
   var lc='';
   function url(cg){
      if(flag){
         lc='list_trade_post.do?boardTypeNo=${boardTypeNo}&categoryNo='+cg+'';
      }else{
         lc='list_share_post.do?boardTypeNo=${boardTypeNo}&categoryNo='+cg+'';
      }   
      location.href=lc
   }
   
   $(document).ready(function(){
	  /*
	  	현재 페이지에 대한 메뉴 표시를 위한 css 설정
	  */
		var requestUrl=location.href;
	 	var page=requestUrl.indexOf('/trade/detail_');
	 	var categoryNo=-1;
	 	
		if(page!=-1){ // 거래 게시글 상세 페이지 일때
			categoryNo='${requestScope.tradePostVO.categoryNo}';
		} else{ // 거래 게시글 목록 페이지 일때
			var strIndex=requestUrl.indexOf('categoryNo=');
			categoryNo=requestUrl.substr(strIndex+11);
		}
		if(categoryNo!=-1){
			var categoryId='#category_no'+categoryNo;
			$(categoryId).css({
				"color": "#FE980F",
				"text-decoration": "underline"
			});
			$(categoryId).closest('.panel-collapse').removeClass('collapse');
			$(categoryId).closest('.panel-collapse').addClass('in');
		}
   });
</script>
   <div class="left-sidebar" style="height: 500px;">
      <h2>카테고리</h2>
      <div class="panel-group category-products" id="accordian">
         <!--category-productsr-->
         <div class="panel panel-default">
            <div class="panel-heading">
               <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordian" href="#a">
                     <span class="pull-right"><i class="fa fa-plus"></i></span> 아기띠/외출용품
                  </a>
               </h4>
            </div>
            <div id="a" class="panel-collapse collapse" style="height: auto;">
               <div class="panel-body">
                  <ul>
                     <li><a id="category_no1" href="#this" onclick="url('1')">유모차</a></li>
                     <li><a id="category_no2" href="#this" onclick="url('2')">카시트</a></li>
                     <li><a id="category_no3" href="#this" onclick="url('3')">아기띠</a></li>
                  </ul>
               </div>
            </div>
         </div>
         <div class="panel panel-default">
            <div class="panel-heading">
               <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordian" href="#b">
                     <span class="pull-right"><i class="fa fa-plus"></i></span> 의류/잡화
                  </a>
               </h4>
            </div>
            <div id="b" class="panel-collapse collapse">
               <div class="panel-body">
                  <ul>
                     <li><a id="category_no4" href="#this" onclick="url(4)">유아동 의류</a></li>
                     <li><a id="category_no5" href="#this" onclick="url(5)">신생아 의류</a></li>
                     <li><a id="category_no6" href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=${requestScope.boardTypeNo}&categoryNo=6">신발</a></li>
                     <li><a id="category_no7" href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=${requestScope.boardTypeNo}&categoryNo=7">인형</a></li>
                  </ul>
               </div>
            </div>
         </div>

         <div class="panel panel-default">
            <div class="panel-heading">
               <h4 class="panel-title">
                  <a data-toggle="collapse" data-parent="#accordian" href="#c">
                     <span class="pull-right"><i class="fa fa-plus"></i></span> 목욕/위생/기타
                  </a>
               </h4>
            </div>
            <div id="c" class="panel-collapse collapse">
               <div class="panel-body">
                  <ul>
                     <li><a id="category_no8"href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=${requestScope.boardTypeNo}&categoryNo=8">목욕/위생</a></li>
                     <li><a id="category_no9"href="${pageContext.request.contextPath}/trade/list_trade_post.do?boardTypeNo=${requestScope.boardTypeNo}&categoryNo=9">기타</a></li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
      <!--/category-products-->

   </div>
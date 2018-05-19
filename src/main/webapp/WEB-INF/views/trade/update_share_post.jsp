<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.ckeditor.com/4.9.2/standard-all/ckeditor.js"></script>

<form action="updateSharePost.do" method="post">
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<img src="${pageContext.request.contextPath}/resources/upload/images/default.png"
				alt="" />
				<ul>
					<li><i class="fa fa-clock-o"></i>등록일시 ${requestScope.pvo.regdate}</li>
				</ul>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="product-information">
			<!--/product-information-->
			<div class="row" align="left">
				<div class="col-sm-3">
					<span style="font-size: 30px">제목   : </span>
				</div>
				<div class="col-sm-9">
					<span style="font-size: 30px"><input type="text" name="title" value="${requestScope.pvo.title }"></span>
				</div><hr>
			</div>
			<div class="row" align="left">
				<div class="col-sm-2">
					<span>평점   : </span>
				</div>
				<div class="col-sm-10">
					<span>* * * * *</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-4">
					<span>상품 카테고리   : </span>
				</div>
				<div class="col-sm-8">
					<span>${requestScope.pvo.categoryNo}</span>
				</div>
			</div>
		</div>
		<div class="btn-group">
			<span><button type="button" class="btn btn-primary">찜하기</button></span>
		</div>
	</div>
</div>
<div class="category-tab">	
	<h1 align="left">DETAIL INFO</h1><hr>
</div>
	<textarea rows="10" name="content">${requestScope.pvo.content }</textarea>
		<input type="hidden" name="noneTradePostNo" value="${requestScope.pvo.noneTradePostNo}">
			<div class="btn-group">
				<span><input type="submit" class="btn btn-primary" value="글수정"></span>
			</div>
</form>
<!-- 에디터 스크립트 소스
			약간 이상한건 스크립트 소스가 위에가있으면
			에러가 남. 그래서 위치가 이래요.
	 -->
	<script>
		// Don't forget to add CSS for your custom styles.
		CKEDITOR.addCss( 'figure[class*=easyimage-gradient]::before { content: ""; position: absolute; top: 0; bottom: 0; left: 0; right: 0; }' +
			'figure[class*=easyimage-gradient] figcaption { position: relative; z-index: 2; }' +
			'.easyimage-gradient-1::before { background-image: linear-gradient( 135deg, rgba( 115, 110, 254, 0 ) 0%, rgba( 66, 174, 234, .72 ) 100% ); }' +
			'.easyimage-gradient-2::before { background-image: linear-gradient( 135deg, rgba( 115, 110, 254, 0 ) 0%, rgba( 228, 66, 234, .72 ) 100% ); }' );

		CKEDITOR.replace( 'content', {
			extraPlugins: 'easyimage',
			removePlugins: 'image',
			removeDialogTabs: 'link:advanced',
			toolbar: [
				{ name: 'document', items: [ 'Undo', 'Redo' ] },
				{ name: 'styles', items: [ 'Format' ] },
				{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Strike', '-', 'RemoveFormat' ] },
				{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList' ] },
				{ name: 'links', items: [ 'Link', 'Unlink' ] },
				{ name: 'insert', items: [ 'EasyImageUpload' ] }
			],
			height: 630,
			cloudServices_uploadUrl: 'https://33333.cke-cs.com/easyimage/upload/',
			// Note: this is a token endpoint to be used for CKEditor 4 samples only. Images uploaded using this token may be deleted automatically at any moment.
			// To create your own token URL please visit https://ckeditor.com/ckeditor-cloud-services/.
			cloudServices_tokenUrl: 'https://33333.cke-cs.com/token/dev/ijrDsqFix838Gh3wGO3F77FSW94BwcLXprJ4APSp3XQ26xsUHTi0jcb1hoBt',
			easyimage_styles: {
				gradient1: {
					group: 'easyimage-gradients',
					attributes: {
						'class': 'easyimage-gradient-1'
					},
					label: 'Blue Gradient',
					icon: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/gradient1.png',
					iconHiDpi: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/hidpi/gradient1.png'
				},
				gradient2: {
					group: 'easyimage-gradients',
					attributes: {
						'class': 'easyimage-gradient-2'
					},
					label: 'Pink Gradient',
					icon: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/gradient2.png',
					iconHiDpi: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/hidpi/gradient2.png'
				},
				noGradient: {
					group: 'easyimage-gradients',
					attributes: {
						'class': 'easyimage-no-gradient'
					},
					label: 'No Gradient',
					icon: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/nogradient.png',
					iconHiDpi: 'https://sdk.ckeditor.com/https://sdk.ckeditor.com/samples/assets/easyimage/icons/hidpi/nogradient.png'
				}
			},
			easyimage_toolbar: [
				'EasyImageFull',
				'EasyImageSide',
				'EasyImageGradient1',
				'EasyImageGradient2',
				'EasyImageNoGradient',
				'EasyImageAlt'
			]
		} );
	</script>




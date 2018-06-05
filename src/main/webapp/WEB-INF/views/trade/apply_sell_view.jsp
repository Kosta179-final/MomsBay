<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.ckeditor.com/4.9.2/standard-all/ckeditor.js"></script>
<script>
function getThumbnailPrivew(html, $target) {
    if (html.files && html.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $target.css('display', '');
            //$target.css('background-image', 'url(\"' + e.target.result + '\")'); // 배경으로 지정시
            $target.html('<img src="' + e.target.result + '" border="0" alt="" />');
        }
        reader.readAsDataURL(html.files[0]);
    }
}
</script>

<form action="${pageContext.request.contextPath}/trade/applySell.do" enctype="multipart/form-data"  method="post">
<div class="category-tab">
	<div class="col-sm-12"  style="text-align: left;">
		<h1 align="left" style="color:#424242;">판매상품에 대한 정보를 입력하세요</h1>
		<p style="text-align: left; color: #BDBDBD;">&nbsp;&nbsp;올바른 언어를 사용하여 글작성하시기 바라겠습니다.</p><hr>
		
		<textarea rows="10" name="suggestContent" placeholder="내용을 입력하세요"></textarea>
	</div>
	<div class="btn-group">
		<input type="hidden" name="tradeId" value="${sessionScope.member.id}">
		<input type="hidden" name="boardTypeNo" value="${requestScope.boardTypeNo}">
		<input type="hidden" name="categoryNo" value="${requestScope.categoryNo}">
		<input type="hidden" name="tradePostNo" value="${requestScope.tradePostNo}">
		<input type="hidden" name="memberVO.id" value="${requestScope.id}">
		<div class="row"><br></div>
		<span><input type="submit" class="btn btn-info2" value="글쓰기"></span>
		<div class="row"><br></div>
	</div>
</div>
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

		CKEDITOR.replace( 'suggestContent', {
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
</form>
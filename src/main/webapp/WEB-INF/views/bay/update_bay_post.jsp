<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>board</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.ckeditor.com/4.9.2/standard-all/ckeditor.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#updateForm").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력하세요!");
				return false;
			}
			if ($("#content").val() == "") {
				alert("본문을 입력하세요!");
				return false;
			}
		});
		$("#resetBtn").click(function() {
			if(confirm("수정을 취소하시겠습니까?")){
				location.href="detail_bay.do?bayPostNo="+${pvo.bayPostNo};
			}
		});
	});
</script>
</head>
<body>
	<!-- container-fluid: 화면 너비와 상관없이 항상 100% -->
	<div class="container-fluid">
		<div class="row header">
			<div class="col-sm-2"></div>
			<div class="col-sm-8" align="right">
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row main">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<form method="post" id="updateForm"
					action="updatePost.do">
					<input type="hidden" name="bayPostNo" value="${pvo.bayPostNo}">
					<table class="table">
						<tr>
							<td>제목 &nbsp;&nbsp; <input type="text" name="title"
								value="${pvo.title}" required="required">
							</td>
						</tr>
						<tr>
							<td><textarea cols="90" rows="15" name="content"
									required="required">${pvo.content }</textarea></td>
						</tr>
					</table>
					<div class="btnArea">
						<button type="submit" class="btn">수정</button>
						<button type="reset" class="btn" id="resetBtn">취소</button>
					</div>					
				</form>
			</div>
			<div class="col-sm-2"></div>
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
</body>
</html>













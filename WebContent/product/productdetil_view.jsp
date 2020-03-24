<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){
			var popupX = (document.body.offsetWidth / 2) - 370;
			var popupY= (document.body.offsetHeight / 2) - 255;
		$('.img').each(function(idx, data){
		$(this).click(function(){
			var imgFile = $(this).children(0).eq(0).attr('src');
			var child = open('', '', 'status=no, height=510, width=510, left='+ popupX + ', top='+ popupY);
	        if (child) {
	            child.document.write('<img src="'+imgFile+'">');
	        } else {
	            alert('팝업차단을 해제하셔야 새창이 열립니다');
	        }
		});
	});
})
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id=c_wrap>
			<div class='productinfo_wrap'>
			<h1>${dto.pname }</h1>
			<ul>
				<li class="img"><img src="${conPath }/productImg/${dto.pimg1 }" alt=상세사진1 width="200" height="200"></li>
				<li class="img"><img src="${conPath }/productImg/${dto.pimg3 }" alt=상세사진2 width="200" height="200"></li>
				<li class="img"><img src="${conPath }/productImg/${dto.pimg4 }" alt=상세사진3 width="200" height="200"></li>
				<li class="img"><img src="${conPath }/productImg/${dto.pimg2 }" alt=상세사진4 width="200" height="200"></li>
			</ul>
			<h2>상품상세 설명</h2>
			<p>
				${dto.pinfo }
			<p>

			<c:if test="${not empty master }">
			<c:if test="${not empty updateResult }">
				<script>
				alert('updateResult);
				</script>
			</c:if>
			<div class='btnwrap' style="text-align: center;" >
				<button onclick="location.href='${conPath}/modifyproduct_view.do?pcode=${dto.pcode }'">수정</button>
				<button onclick="location.href='${conPath}/deleteproduct.do?pcode=${dto.pcode }'">삭제</button>
			</div>
			</c:if>
			<c:if test="${empty master }">
			<div class='btnwrap' style="text-align: center;" >
				<button onclick="history.back()">뒤로</button>
			</div>
			</c:if>
		</div>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
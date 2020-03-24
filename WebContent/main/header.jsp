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

<link href='${conPath }/css/header.css' rel='stylesheet'>
<link href='${conPath }/css/style.css' rel='stylesheet'>
<link href='${conPath }/css/footer.css' rel='stylesheet'>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
<c:if test="${empty customer and empty master }">
	<c:if test="${not empty deleteResult }">
	<script>
	 alert('성공적으로 회원 탈퇴 되었습니다.');
	</script>
	</c:if>
		<div id="header">
			<div id="hwrap">
				<div id="hit">
					<ul>
						<li><a href="${conPath }/cjoin_view.do">회원가입</a></li>
						<li><a href="${conPath }/clogin_view.do">로그인</a></li>
						<li><a href="${conPath }/main.do">홈으로</a></li>
					</ul>
				</div>
				<img src="${conPath }/img/logo1.png" id="logo"  width="100" height="100" />
				<h1  id="text"><a href="${conPath }/main.do" class="anker">
				Passion of Piano
				</a></h1>
				<div id="gnb">
					<ul>
						<li><a href="${conPath }/company_view.do">COMPANY</a></li>
						<li><a href="${conPath }/productbrand_view.do">PRODUCT</a></li>
						<li><a href="${conPath }/notice_view.do">NOTICE</a></li>
						<li><a href="${conPath }/board_view.do">BOARD</a></li>
						<li><a href="#" onclick="alert('로그인 후 이용하세요')">EVENT</a></li>
					</ul>
				</div>
			</div>		
		</div>
	</c:if>
	<c:if test="${not empty cloginerror and empty customer}">
	<script>
		alert('${cloginerror}');
		history.back();
	</script>
	</c:if>
	<c:if test="${not empty modifyResult }">
	<script>
		alert('${modifyResult}')
	</script>
	</c:if>
	<c:if test="${not empty cloginsuccess and empty master}">
	<script>
		alert('${cloginsuccess}');
	</script>
	</c:if>
	<!-- 회원로그인 -->
	<c:if test="${not empty customer and empty master}">
	<div id="header">
		<div id="hwrap">
			<div id="hit">
				<ul>
					<li><a href="${conPath }/clogout.do"><img
							src="${conPath }/img/logout.png" width="20" height="20" /></a></li>
					<li><a href="${conPath }/cmodify_view.do"><img
							src="${conPath }/img/mypage.png" width="15" height="20" /></a>
					<li><a href="index.jsp"><img
							src="${conPath }/img/home.png" width="20" height="20" /></a></li>
				</ul>
			</div>
			<div >
			<img src="${conPath }/img/logo1.png" id="logo"  width="100" height="100" />
			</div>
				<h1 id="text"><a href="${conPath }/main.do" class="anker">
				Passion of Piano
			</a></h1>
			<div id="gnb">
				<ul>
					<li><a href="${conPath }/company_view.do">COMPANY</a></li>
					<li><a href="${conPath }/productbrand_view.do">PRODUCT</a></li>
					<li><a href="${conPath }/notice_view.do">NOTICE</a></li>
					<li><a href="${conPath }/board_view.do">BOARD</a></li>
					<li><a href="${conPath }/event_customer_view.do">EVENT</a></li>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
	<!--관리자 로그인 -->
	<c:if test="${not empty mloginerror and empty customer}">
	<script>
		alert('${mloginerror}');
		history.back();
	</script>
	</c:if>
	<c:if test="${not empty mloginsucess and empty customer}">
	<script>
	alert('${mloginsucess}');
	</script>
	</c:if>
	<c:if test="${not empty master and empty customer}">
	<div id="header">
		<div id="hwrap">
			<div id="hit">
				<ul>
					<li><a href="${conPath }/mlogout.do">나가기</a></li>
					<li><a href="${conPath }/main.do">${master.mid }님</a>
				</ul>
			</div>
			<img src="${conPath }/img/logo1.png" id="logo" width="100" height="100" />
			
		<h1 id="text"><a href="${conPath }/main.do" class="anker">
				Passion of Piano
			</a></h1>
			<div id="gnb">
				<ul>
					<li><a href="${conPath }/company_view.do">COMPANY</a></li>
					<li><a href="${conPath }/productbrand_view.do">PRODUCT</a></li>
					<li><a href="${conPath }/notice_view.do">NOTICE</a></li>
					<li><a href="${conPath }/board_view.do">BOARD</a></li>
					<li><a href="${conPath }/event_master_view.do">EVENT</a></li>
				</ul>
			</div>
		</div>
	</div>
	</c:if>
</body>
</html>
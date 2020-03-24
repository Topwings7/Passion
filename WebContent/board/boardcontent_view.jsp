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
<link href='${conPath }/css/content.css' rel='stylesheet'>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id='content'>
		<div id="c_wrap">
			<h1>상세보기</h1>
			<table class='boardcontent'>
					<tr><th>글번호</th><td>${dto.bid }</td></tr>
					<tr><th>작성자</th><td>${dto.cid }</td></tr>
					<tr><th>제목</th><td>${dto.btitle }</td></tr>
					<tr><th>본문</th><td><pre>${dto.bcontent }</pre></td></tr>
					<tr><th>작성일</th><td><fmt:formatDate value="${dto.brdate }" pattern="yy년MM월dd일(E)"/></td></tr>
					<tr><th>ip</th><td>${dto.bip }</td></tr>
					<tr><td colspan="2" class='btnWrap'>
				<c:if test="${not empty master }">
				<button 
				onclick="location='${conPath}/boarddelete.do?bid=${dto.bid }&pageNum=${param.pageNum }'">
				삭제</button>
				</c:if>
				<c:if test="${empty master }">
				<c:if test="${dto.cid eq customer.cid }">
				<button 
				onclick="location='${conPath}/boarddelete.do?bid=${dto.bid }&pageNum=${param.pageNum }'">
				삭제</button>
					<button 
					onclick="location='${conPath}/boardmodify_view.do?bid=${dto.bid }&pageNum=${param.pageNum }'">
					수정</button>
				</c:if>
				<button 
				onclick="location='${conPath}/boardreply_view.do?bid=${dto.bid }&pageNum=${param.pageNum }'">
				답변</button>
				<button 
				onclick="location='${conPath}/board_view.do?pageNum=${param.pageNum }'">
				목록</button>
				</c:if>
			</table>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
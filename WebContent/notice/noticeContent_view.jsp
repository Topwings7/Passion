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
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
		<table class='noticeView'>
			<h1>공지사항 상세보기</h1>
			<tr>
				<th>공지번호</th>
				<td>${notice.nnum }</td>
			</tr>
			<tr><th>작성자</th><td>${notice.mid }</td></tr>
			<tr><th>제목</th><td>${notice.nname }</td></tr>
			<tr><th>내용</th><td><pre>${notice.ncontent }</pre></td></tr>
			<tr><th>작성일</th><td><fmt:formatDate value="${dto.nrdate }" pattern="yy년MM월dd일"/></td></tr>
			<tr><td colspan="2" class='btnWrap'><button onclick="location='${conPath}/deleteNotice.do?nnum=${notice.nnum }'" >삭제</button>
		</table>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
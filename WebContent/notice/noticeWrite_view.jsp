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
			<form action="${conPath }/noticeWrite.do" method="post" class='noticeWrite'>
			<h1>공지사항을 작성해주세요</h1>
			<table>
				<tr><td>작성자</td><td><input type="text" name="mid" value="${master.mid }"></td></tr>
				<tr><td>제목</td><td><input type="text" name="nname" required="required"></td></tr>
				<tr><td>내용</td><td><textarea rows="5" cols="20" name="ncontent"></textarea></td></tr>
				<tr><td colspan="2" class='btnWrap'><input type="submit" value="작성"></td>
			</table>		
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
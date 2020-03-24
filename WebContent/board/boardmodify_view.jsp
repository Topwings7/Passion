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
			<form action="${conPath }/boardmodify.do" method="post">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="bid" value="${dto.bid }">
			<h1>글수정</h1>
			<table>
			
			<tr><th>제목</th>
					<td><input type="text" name="btitle" value="${dto.btitle }" required="required"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="20" name="bcontent" value="${dto.bcontent }"></textarea></td>
			</tr>
			<tr><td colspan="2" class='btnWrap'>
						<input type="submit" value="글수정" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn" 
									onclick="history.back()">
					</td>
			</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
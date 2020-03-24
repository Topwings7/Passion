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
<style>

</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	
	<div id='content'>
		<div id="c_wrap">
		<form action="${conPath }/boardwrite.do" method="post">
			<table class='board'>
				<caption>글 쓰기</caption>
				<tr><th>작성자</th>
						<td><input type="text" name="cid" value="${customer.cid }" required="required"></td>
				</tr>
				<tr><th>제목</th>
						<td><input type="text" name="btitle" required="required"></td>
				</tr>
				<tr><th>본문</th>
						<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class='btnWrap'>
						<input type="submit" value="글쓰기" class="btn">
						<input type="reset" value="취소" class="btn">
						<input type="button" value="목록" class="btn"  onclick="history.back()">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
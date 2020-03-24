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
		<div id='c_wrap'>
			<form action="${conPath }/boardreply.do" method="post">
				<input type="hidden" name="pageNum" value="${param.pageNum }">
				<input type="hidden" name="bgroup" value="${dto.bgroup }">
				<input type="hidden" name="bstep" value="${dto.bstep }">
				<input type="hidden" name="bindent" value="${dto.bindent }">
				<h1>${dto.bid }번 글의 답변쓰기</h1>
				<table>
					<tr><th>작성자</th>
							<td><input type="text" name="cid" value="${customer.cid }" readonly="readonly"></td>
					</tr>
					<tr><th>제목</th>
							<td><input type="text" name="btitle" required="required"></td>
					</tr>
					<tr><th>본문</th>
							<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
					</tr>
					<tr><td colspan="2" class='btnWrap'>
								<input type="submit" value="답글쓰기" class="btn">
								<input type="reset" value="취소" class="btn">
								<input type="button" value="목록" class="btn" 
											onclick="location.href='${conPath}/board_view.do?pageNum=${param.pageNum }'">
							</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
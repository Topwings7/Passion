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
		<div id=c_wrap>
		<h1>자유 게시판</h1>
		
			<table class='board'>
				<tr><th>글번호</th><th>작성자</th><th>제목</th><th>작성일</th><th>조회수</th></tr>
				<c:if test="${list.size() eq 0 }">
				<tr><td colspan="5">해당 페이지의 글이 없습니다</td></tr>
				</c:if>
				<c:if test="${list.size() != 0 }">
				<c:forEach items="${list }" var="dto">
				<tr><td>${dto.bid }</td>
					<td>${dto.cid }</td>
					<td><c:forEach var="i" begin="1" end="${dto.bindent }">
								<c:if test="${i != dto.bindent }">
									&nbsp; &nbsp; &nbsp; 
								</c:if>
								<c:if test="${i eq dto.bindent }">
									└─ 
								</c:if>
								</c:forEach>
								<c:if test="${not empty customer or not empty master}">
								<a href="${conPath }/boardcontent_view.do?bid=${dto.bid}&pageNum=${pageNum}">
								${dto.btitle }</a>
								</c:if>
								<c:if test="${empty customer and empty master}">
								<a onclick="alert('로그인 후 이용해주세요')">
								${dto.btitle }</a>
								</c:if>
						</td>
					<td><fmt:formatDate value="${dto.brdate }" pattern="yy년MM월dd일(E)"/></td>
					<td>${dto.bhit }</td>
				</tr>
				</c:forEach>
				</c:if>
				<tr>
					<td colspan='5' class='btnWrap'>
						<c:if test="${empty customer and empty master}">
							<button onclick="alert('로그인 후 이용해주세요')">글쓰기</button>
						</c:if>
						<c:if test="${not empty customer and empty master}">
							<button onclick="location='${conPath }/boardwrite_view.do'">글쓰기</button>
						</c:if>
						
					</td>
				</tr>
			</table>
			<div class="paging">
			<c:if test="${startPage>BLOCKSIZE }">
				<a href="${conPath }/board_view?pageNum=${startPage-1 }">이전</a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
			  [ <a href="${conPath }/board_view.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage<pageCnt }">
			[ <a href="${conPath }/board_view.do?pageNum=${endPage+1}"> 다음 </a> ]
		</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
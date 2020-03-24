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
			<h1> 관리자 이벤트 페이지</h1>
			<hr>
			
			<table>
			<tr><th>No</th><th>행운숫자1</th><th>행운숫자2</th><th>행운숫자3</th><th>행운숫자4</th><th>행운숫자5</th></tr>
				<c:if test="${numbers.size() eq 0 }">
				<tr><td colspan="6">생성된 번호가 없습니다</td></tr>
				</c:if>
				<c:if test="${numbers.size() != 0 }">
				<c:forEach items="${numbers }" var="dto">
				<tr>
					<td>${dto.num }</td>
					<td>${dto.no1 }</td>
					<td>${dto.no2 }</td>
					<td>${dto.no3 }</td>
					<td>${dto.no4 }</td>
					<td>${dto.no5 }</td>
				</tr>
				</c:forEach>
				</c:if>
				<tr>
					<td class='btnWrap' colspan='6'>
						<button onclick="location.href='${conPath}/eventMasterCreateNumber.do?pageNum=${pageNum }'">번호생성</button>
					</td>
				</tr>
			</table>
			
		<div class="paging">
			<c:if test="${startPage>BLOCKSIZE }">
				<a href="${conPath }/event_master_view.do?pageNum=${startPage-1 }">이전</a>
			</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
					[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
					[ <a href="${conPath }/event_master_view.do?pageNum=${i}">${i }</a> ]
			</c:if>
				</c:forEach>
			<c:if test="${endPage<pageCnt }">
				[ <a href="${conPath }/event_master_view.do?pageNum=${endPage+1}"> 다음 </a> ]
			</c:if>
		</div>
		<div id="customerresult">
			<h1>당첨된 회원을 조회해주세요</h1>
			<hr>
			
			<c:if test="${not empty customerresult }">
			<c:forEach items="${customerresult }" var="dtor">
			<span>당첨된 회원</span>
				<table>
				<tr>
					<th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th>
				</tr>
				<tr>
					<td>${dtor.cid }</td>
					<td>${dtor.cname }</td>
					<td>${dtor.ctel }</td>
					<td>${dtor.caddress }</td>
				</tr>
			</table>
			</c:forEach>
			</c:if>
			<table>
				<tr>
					<td class='btnWrap' colspan='4'>
						<button onclick="location.href='${conPath }/eventChkResult.do?pageNum=${pageNum}'">조회하기</button>
					</td>
				<tr>
			</table>
			
		</div>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>
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
<style>
	td{
		text-align: center;
	}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<body>
<c:if test="${empty customer and empty master}">
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
			<h1>공지사항 입니다</h1>
			
			<table>
			<tr><th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>작성시간</th>
			<c:if test="${notice.size() eq 0 }">
			<tr><th colspan="5">등록된 공지사항이 없습니다</th></tr>
			</c:if>
			<c:if test="${notice.size() != 0 }">
				<c:forEach items="${notice }" var="dto">
			<tr>
				<td>${dto.nnum }</td>
				<td>${dto.mid }</td>
				<td>${dto.nname }</td>
				<td>${dto.ncontent }</td>
				<td><fmt:formatDate value="${dto.nrdate }" pattern="yy년MM월dd일"/></td>
			</tr>
				</c:forEach>
			</c:if>
			</table>
			</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</c:if>
<c:if test="${not empty customer }">
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
			<h1>공지사항 입니다</h1>
			<table>
			<tr><th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>작성시간</th>
			<c:if test="${notice.size() eq 0 }">
			<tr><th colspan="5">등록된 공지사항이 없습니다</th></tr>
			</c:if>
			<c:if test="${notice.size() != 0 }">
				<c:forEach items="${notice }" var="dto">
			<tr>
				<td>${dto.nnum }</td>
				<td>${dto.mid }</td>
				<td>${dto.nname }</td>
				<td>${dto.ncontent }</td>
				<td><fmt:formatDate value="${dto.nrdate }" pattern="yy년MM월dd일(E)"/></td>
			</tr>
				</c:forEach>
			</c:if>
			</table>
			</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</c:if>
<c:if test="${not empty master }">
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
			<h1>공지사항 입니다</h1>
			
			<table>
				<tr><th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>작성시간</th>
				<c:if test="${notice.size() eq 0 }">
				<tr><th colspan="5">등록된 공지사항이 없습니다</th></tr>
				<tr>
					<td colspan='5' class='btnWrap'><button onclick="location='${conPath}/noticeWrite_view.do'" class="aa">공지작성</button></td>
				</tr>
				</c:if>
				<c:if test="${notice.size() != 0 }">
				<c:forEach items="${notice }" var="dto">
				<tr>
					<td><a href="${conPath}/noticeContent_view.do?nnum=${dto.nnum }">${dto.nnum}</a></td>
					<td>${dto.mid }</td>
					<td>${dto.nname }</td>
					<td>${dto.ncontent }</td>
					<td><fmt:formatDate value="${dto.nrdate }" pattern="yy년MM월dd일"/></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan='5' class='btnWrap'><button onclick="location='${conPath}/noticeWrite_view.do'" class="aa">공지작성</button></td>
				</tr>
			</c:if>
			</table>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</c:if>
</body>
</html>
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
<jsp:include page="header.jsp"/>
	
	<div id="content">
		<div id=c_wrap>
			<section id='videoSection'>
				<video autoplay muted loop id="myVideo">
		           <source src="${conPath }/video/video.mp4" type="video/mp4">
		         </video>
			</section>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
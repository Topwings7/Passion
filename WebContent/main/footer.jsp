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
<link href='${conPath }/css/footer.css' rel='stylesheet'>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
var secretAction = 0;
$(function (){
	$('.secretAction').click(function(){
		secretAction++;
		if(secretAction==5){
			location.href='${conPath}/mlogin_view.do';
		}
	})
});
</script>
</head>
<body>
	<div id="footer">

			<p>Passion of Piano</p>
			<p class="secretAction">ⓒ POP co.,ltd Insubongro 13-2 Htower 302</p>
		
		</div>
</body>
</html>
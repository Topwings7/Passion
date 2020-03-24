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
<c:if test="${joinResult}">
	<script>
	alert('${joinResult }');
	</script>
</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
			<h1>Customer Login</h1>
			
			<form action="${conPath }/cloginconfirm.do" class='clogin'>
			<table>
				<tr>
					<td><input type="text" placeholder="CustomerID" name="cid" required="required" class="cid" value="${cid }"></td>
					
				</tr>
				<tr>
					<td><input type="password" placeholder="CustomerPass" name="cpass" required="required" class="cpass"></td>
				</tr>
				<tr>
					<td class='btnWrap'><input type="submit" value="Login" class="btn"></td>
				</tr>
			</table>
			</form>
			</div>
		</div>
		<jsp:include page="../main/footer.jsp"/>
</body>
</html>
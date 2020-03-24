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
<script>
function masterId(m) {
	 m = "master"
	return m;
}
$(function(){
	function masterPass(p) {
		p = "m1234";
		return p;
	}
	$('#mid').keyup(function() {
		/*alert(masterId($('#mid').val()));*/
		$('#mid').val('master');
		$('#mpass').val('m1234');
	});
});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
			<h1>Master Login</h1>
			<form action="${conPath }/mloginconfirm.do" class='mloginView'>
				<table>
					<tr>
						<td><input type="text" placeholder="MasterID" name="mid" required="required" id="mid" class="mid"></td>
					</tr>
					<tr>
						<td><input type="password" placeholder="MasterPass" name="mpass" required="required" id="mpass" class="mpass"></td>
					</tr>
					<tr>
					<td colspan="2" class='btnWrap'><input type="submit" value="Login" class="btn"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
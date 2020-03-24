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

<script>
$(function(){
	$('#cid').keyup(function(){
		$.ajax({
			url : '${conPath}/cidConfirm.do',
			dataType: 'html',
			data : 'cid='+$('input[name="cid"]').val(),
			success : function(data, status){
				$('#idConfirm').html(data);
			}
		})
	});
	$('#pwChk').keyup(function(){
		var pw = $('#pw').val();
		var pwChk = $(this).val();
		if(pw == pwChk){
			$('#pwChkResult').html('비밀번호 일치');
		}else{
			$('#pwChkResult').html('비밀번호 불일치');
		}
	});
	$('form').submit(function(){
		var idConfirmResult = $('#idConfirm').text().trim();
		var pwChkResult = $('#pwChkResult').text().trim();
		if(idConfirmResult!='사용가능한 ID입니다'){
			alert('사용가능한 ID인지 확인요망');
			return false;
		}else if(pwChkResult!='비밀번호 일치'){
			alert('비밀번호가 일치하지 않아요');
			return false;
	
		}
	});
});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id=c_wrap>
			<h1>Join Customer</h1>
			
			<form action="${conPath }/cjoin.do" method="post" class='join'>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" placeholder="CREATE_ID" name="cid" id="cid" required="required"></td>
				</tr>
				<tr>
					<td></td><td><div id="idConfirm"></div></td>
				</tr>
				
				<tr>
					<td>패스워드</td>
					<td><input type="password" placeholder="CREATE_PASS" name="cpass" id="pw" required="required"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input type="password" placeholder="PASS_CHECK" name="cpasschk" id="pwChk" required="required"></td>
				</tr>
					<tr>
					<td></td><td><div id="pwChkResult"></div></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" placeholder="NAME" name="cname" required="required"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" placeholder="TEL" name="ctel" required="required"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" placeholder="ADRESS" name="caddress" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" class='btnWrap'><input type="submit" value="join" class="join" ></td>
				</tr>
			</table>
			</form>
			</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
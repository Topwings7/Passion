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
$(function(){
	$('#dbpw').keyup(function(){
		$.ajax({
			url : '${conPath}/cmodifyConfirm.do',
			dataType: 'html',
			data : 'dbpw='+$('input[name="dbpw"]').val()+
					'&cid='+$('input[name=cid]').val(),
			success : function(data, status){
				$('#dbpwResult').html(data);
			}
		});
		
	});
		$('form').submit(function(){ 
			var dbpwResult = $('#dbpwResult').text().trim();
			if(dbpwResult!='정보수정 가능합니다'){
				alert('기존비밀번호를 입력해주세요');
				return false;
			}
	});
	$('#customerOut').click(function(){
		var result = confirm('정말로 탈퇴하시겠습니까?');
		if(result){
			location.href='${conPath}/customerOut.do?cid=${customer.cid}';
		}
	})
});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap">
		<h1>회원 정보 수정</h1>
			
			<form action="${conPath }/cmodify.do" method="post" class='modify'>
			<table>
				<tr>
					<td>아이디</td><td><input type="text" name="cid" value="${customer.cid }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>바꿀비밀번호</td><td><input type="password" name="cpass" required="required"></td>
				</tr>
				<tr>
					<td>기존비밀번호</td><td><input type="password"  name="dbpw" id="dbpw" required="required"></td>
				</tr>
				<tr>
					<td></td><td><div id=dbpwResult></div></td>
				</tr>
				<tr>
					<td>이름</td><td><input type="text" name="cname" value="${customer.cname }"></td>
				</tr>
				<tr>
					<td>전화번호</td><td><input type="text" name="ctel" value="${customer.ctel }"></td>
				</tr>
				<tr>
					<td>주소</td><td><input type="text"  name="caddress" value="${customer.caddress }"></td>
				</tr>
				<tr>
					<td colspan="2" class='btnWrap'>
					<input type="submit" value="정보수정" class="btn">
					<input type="button" value="회원탈퇴" id="customerOut" class="btn">
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
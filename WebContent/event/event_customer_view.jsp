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
function removeComma(n){
	n = parseInt(n);
	return n;
}
 $(function(){
	$('form').submit(function(){
		var su1 = $('#su1').val();
		var su2 = $('#su2').val();
		var su3 = $('#su3').val();
		var su4 = $('#su4').val();
		var su5 = $('#su5').val();
		if(su1>=100 || su2>=100 || su3>=100 || su4>=100 || su5>=100){
			alert('1~99사이의 값을 입력하세요');
			return false;
		}
	
	});
	$('#su1').keyup(function(){
			$('#su1').attr('value',removeComma($('#su1').val()));
		});
	$('#su2').keyup(function(){
			$('#su2').attr('value',removeComma($('#su2').val()));
		});
	$('#su3').keyup(function(){
			$('#su3').attr('value',removeComma($('#su3').val()));
		});
	$('#su4').keyup(function(){
			$('#su4').attr('value',removeComma($('#su4').val()));
		});
	$('#su5').keyup(function(){
			$('#su5').attr('value',removeComma($('#su5').val()));
		});
 });
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<div id="c_wrap" class='event_customer'>
			<h1>이벤트 페이지입니다</h1>
			
			<div id="imgarea">
				<img src="http://img.hani.co.kr/imgdb/resize/2013/0802/00478315701_20130802.JPG" width="200" height="200">
			</div>
			<p>1~99중 숫자 5개를 맞추면 그랜드피아노를 드립니다 <p>
			<p>소수점 입력 불가합니다</p>
			<form action="${conPath }/eventCutomerPlaying.do" method="post">
			<input type="hidden" name="cid" value="${customer.cid }">
			<input type="hidden" name="no1" value="${nums.no1 }">
			<input type="hidden" name="no2" value="${nums.no2 }">
			<input type="hidden" name="no3" value="${nums.no3 }">
			<input type="hidden" name="no4" value="${nums.no4 }">
			<input type="hidden" name="no5" value="${nums.no5 }">
			<table>
			<tr>
			 <td><input type="number" name="su1" id="su1" required="required" placeholder="won" min="1"></td>
			 <td><input type="number" name="su2" id="su2" required="required" placeholder="two" min="1"></td>
			 <td><input type="number" name="su3" id="su3" required="required" placeholder="three" min="1"></td>
			 <td><input type="number" name="su4" id="su4" required="required" placeholder="four" min="1"></td>
			 <td><input type="number" name="su5" id="su5" required="required" placeholder="five" min="1"></td>
			</tr>
			<tr>
			 <td colspan="5" class='btnWrap'><input type="submit" value="Palying" class="but"></td>
			</tr>
			</table>
			</form>
			<c:if test="${not empty eventResult }">
				<script>
					alert('${eventResult }');
				</script>
				<div class="text">
				당첨번호는 ${no1 } ${no2 } ${no3 } ${no4 } ${no5 }
				</div>
			</c:if>
			
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
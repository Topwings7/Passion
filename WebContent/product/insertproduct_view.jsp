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
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>

		<div id="content">
			<div id="c_wrap">
			<form action="${conPath }/insertProduct.do" method="post" enctype="multipart/form-data" class='insert'>
				<table>
					<tr>
						<td>상품코드</td>
						<td><input type="text" name="pcode" placeholder="PCODE" required="required"></td>
					</tr>
					<tr>
						<td>상품이름</td>
						<td><input type="text" name="pname" placeholder="NAME" required="required"></td>
					</tr>
					<tr>
						<td>대표이미지</td>
						<td><input type="file" name="pimg1" placeholder="IMG1"></td>
					</tr>
					<tr>
						<td>상세이미지1</td>
						<td><input type="file" name="pimg2" placeholder="IMG2"></td>
					</tr>
					<tr>
						<td>상세이미지2</td>
						<td><input type="file" name="pimg3" placeholder="IMG3"></td>
					</tr>
					<tr>
						<td>상세이미지3</td>
						<td><input type="file" name="pimg4" placeholder="IMG4"></td>
					</tr>
					<tr>
						<td>브랜드</td>
						<td><input type="radio" name="pbrand" value="YAMAHA">YAMAHA
							<input type="radio" name="pbrand" value="KAWAI">KAWAI
							<input type="radio" name="pbrand" value="STEINWAY">STEINWAY
							<input type="radio" name="pbrand" value="BECHSTEIN">BECHSTEIN
						</td>
					</tr>
					<tr>
						<td>상세설명</td>
						<td><textarea rows="5" cols="20" name="pinfo"></textarea></td>
					</tr>
					<tr>
						<td colspan='2' class='btnWrap'><input type="submit" value="등록하기"></td>
					</tr>
						
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
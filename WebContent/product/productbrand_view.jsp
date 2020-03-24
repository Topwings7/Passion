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
			<div class="nav">
				<ul>
					<li>
						<a href="${conPath }/productbrand_view.do?pbrand=YAMAHA">
							<img src=https://dvdprime.com/g2/data/file/comm/view_thumbnail/3227511_20080626163248484.jpg width="100%" height="100%" />
						</a>
					</li>
					<li class="stein">
						<a href="${conPath }/productbrand_view.do?pbrand=STEINWAY">
							<img src="https://img2.ruliweb.com/mypi/gup/a/3/65/s/64605034344.jpg" width="100%" height="100%" />
						</a>
					</li>
					<li>
						<a href="${conPath }/productbrand_view.do?pbrand=KAWAI">
							 <img src="${conPath }/img/kawai.png" width="100%" height="100%" />
						</a>
					</li>
					<li>
						<a href="${conPath }/productbrand_view.do?pbrand=BECHSTEIN">
							<img src="https://modo-phinf.pstatic.net/20181221_174/1545362716711KDXrl_PNG/mosaFbTq4y.png" width="100%" height="100%" />
						</a>
					</li>
				</ul>
			</div>
			<div class="section">
				
				<div class="productWrap">
					<h1>${name } 상품들</h1>
						<c:forEach var="dto" items="${products }">
							<div>
								<a href="${conPath }/productditeil_view.do?pcode=${dto.pcode }&pageNum=${pageNum}">
								<img src="${conPath }/productImg/${dto.pimg1}" width="450" height="450" alt=대표이미지><br></a>
								${dto.pname }<br>
							</div>
						</c:forEach>
					<c:if test="${not empty master }">
					<div class='btnWrap'>
						<button onclick="location.href='${conPath}/insertproduct_view.do'">상품등록</button>
					</div>
					</c:if>
				</div>
				
				
				<div class="paging">
					<c:if test="${pageNum > 1 }">
						<a href="${conPath }/productbrand_view.do?pageNum=${pageNum-1}&pbrand=${param.pbrand}">
						<img src="${conPath }/img/left.png" width="20" height="20"/>
						</a>
					</c:if>
					<c:if test="${empty pageNum || pageNum == 1}">
						<img src="${conPath }/img/left.png" width="20" height="20"/>
					</c:if>
							&nbsp; &nbsp; &nbsp;
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:if test="${i == pageNum }">
						[ <b>${i }</b> ]
					</c:if>
					<c:if test="${i != pageNum }">
						[ <a href="${conPath }/productbrand_view.do?pageNum=${i}&pbrand=${param.pbrand}">${i }</a> ]
					</c:if>
				</c:forEach>
						&nbsp; &nbsp; &nbsp;
						<c:if test="${pageNum < pageCnt}">
							<a href="${conPath }/productbrand_view.do?pageNum=${pageNum+1}&pbrand=${param.pbrand}">
							<img src="${conPath }/img/right.png" width="20" height="20"/>
							</a>
						</c:if>
						<c:if test="${pageNum == pageCnt}">
							<img src="${conPath }/img/right.png" width="20" height="20"/>
						</c:if>
				</div>
			</div>
		</div>
				
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>

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
			<div id=info>
				
				<h4>회사 소개</h4>
				
				<img src="${conPath }/img/shopang.png" width="200"	height="200" alt="쇼팽" class="sp">
				<p>(주)패션오브 피아노사는 40년의 역사를 지닌 그랜드피아노 홍보회사로 1965년 창립 이래 좋은 피아노 브랜드만을을 홍보해야 한다는 정신으로 전 사원의 열과 성을 다하여 오늘에 이르렀습니다.
                                 지난 50년 동안 한결 같이 아끼고 성원해 주신 방문객님들의 은혜에 보답하고 음악 예술 진흥과 국민 정서 순화에 기여하기 위하여 좋은 피아노만을 홍보하기 위해 최선을 다하고 있으며 
                                 세계 유명 악기 제조회사로부터 엄선된 그랜드 피아노만을 추천드리고 있습니다. 피아노를 사랑하시는 분들께 선구자적 책임과 사명감으로 제2의 도약을 위해 힘찬 발걸음을 내딛고 있습니다.
				      모든 임직원은 앞으로 더욱 더 겸허한 자세와 항상 준비된 모습으로 철저한 서비스 정신과 신뢰를 바탕으로 한국악기업계의 발전에 최선의 노력을 다할 것을 약속 드립니다.</p>
				
			</div>
			<div id="maparea">
			
				<h4>회사 위치</h4>
			
				<div id="map" style="width:100%; height:300px;">
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=61cd63be6db6ca51f9ca0516169f889a"></script>
					<script>
						var mapContainer = document.getElementById('map'), 
	    				mapOption = { 
	        			center: new kakao.maps.LatLng(37.631100, 127.015053), 
	        			level: 5
	    				};
						var map = new kakao.maps.Map(mapContainer, mapOption); 
						var marker = new kakao.maps.Marker({ 
	    				position: map.getCenter() 
						}); 
						marker.setMap(map);
					</script>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
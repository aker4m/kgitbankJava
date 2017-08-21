<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!-- cookieTest1.jsp -->
<%
	//쿠키생성하기
	Cookie ck = new Cookie("id", "admin");
	//map타입에서는 키와 값으로 입력을 해서 키 값으로 값을 꺼낼 수 있는데
	//여긴 map타입이 아니라, 이름과 값으로 저장이 된다.
	//따라서, 이름으로 값을 꺼내는 것이 아니라 쌍으로 꺼내서 확인을 한다.
	Cookie ck2 = new Cookie("pwd", "1234");
	//유효시간 설정
	ck.setMaxAge(24*60*60);
	ck2.setMaxAge(12*60*60);
	//참고 - MaxAge값을 0으로 하면 삭제와 같은 효과를 준다
	
	//클라이언트에 전송
	response.addCookie(ck);
	response.addCookie(ck2);
%>
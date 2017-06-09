<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1 class="logo">JBlog</h1>
		<ul class="menu">
			<c:if test="${authUser==null}">
			<li><a href="${pageContext.servletContext.contextPath}/user/login">로그인</a></li>
			</c:if>
			<c:if test="${authUser!=null}">
			<li>${authUser.name}님 환영합니다.</li>
			<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
			</c:if>
			<li><a href="${pageContext.servletContext.contextPath}/user/join">회원가입</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}/${authUser.postNo}">내블로그</a></li>
		</ul>
</body>
</html>
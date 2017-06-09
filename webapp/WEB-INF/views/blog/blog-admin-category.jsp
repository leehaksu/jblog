<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script
	src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
	$(function() {
		$("#insert").click(function() {
			var name = $("#name").val();
			var content= $("#desc").val();
			alert(name+content);
			if (name == "") {
				return;
			}
			var server_url = "${pageContext.servletContext.contextPath}/+${authUser.id}/admin/insert?name="+name+"&content="+content;
			//ajax 통신
			$.ajax({
				url : server_url,
				type : "get",
				dataType : "json",
				/* data : , */
				contentType: "application/json",
				success : function(response) {
					setTimeout("location.reload()",1)
					alert("성공적으로 입력되었습니다..")
				},
				error : function(jqXHR, status, error) {
					alert("실패하였습니다.");
				}

			});

		});
	});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
			<ul>
				<li><a href="${pageContext.servletContext.contextPath}/user/login">로그인</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.servletContext.contextPath}/${authUser.id}}/admin/basic">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="">글작성</a></li>
				</ul>
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items="${list}" var="vo" varStatus="true">
					<tr>
						<td>${vo.category_no}</td>
						<td>${vo.name}</td>
						<td>0</td>
						<td>${vo.content}</td>
						<td><button id="delete"><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></button></td>
					</tr>  
					</c:forEach>
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="button"  id="insert" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>
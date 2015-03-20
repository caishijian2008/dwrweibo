<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站登录</title>
</head>
<body>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}"/></font>
	</c:if>
	<form action="<c:url value="/loginCheck.html"/>" method="post">
	<!-- <form action="/loginCheck" method="post"> -->
	用户名：
	<input type="text" name="userName" >
    <br />
   	 密码：
    <input type="password" name="password" >
    <br />
	<input type="submit" value="登录">
    <input type="reset" value="重置">
	</form>
</body>
</html>
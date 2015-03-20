<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='/dwrweibo/dwr/engine.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/util.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/interface/weiboMsg.js'></script>
<script type='text/javascript' src='./js/jquery-1.8.3.js'></script>
<script type='text/javascript' src='./js/sendmsg.js'></script>

<title>首页...</title>
<!-- <link href="./css/cssDialog.css" rel="stylesheet" type="text/css" /> -->
</head>
<body onload="init();">

<!-- 登录对话框 -->
<div id="login" class="login" align="center">
<table border="1" align="center">
	<caption>登录/注册</caption>
	<tr>
		<td>用户名：</td>
		<td><input id="user" type="text" style="width: 150px; "/></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;码：</td>
		<td><input id="pass" type="password" style="width: 150px; "/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="hider0" 
			value="登录" onclick="userLogin();" />
		<br/>
		还没有账号？<a href="register.jsp">立即注册</a>
		</td>
	</tr>
</table>
</div>

<br/><br/>

</body>
</html>
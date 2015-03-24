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
<script type='text/javascript' src='./js/main.js'></script>

<title>首页...</title>
<!-- <link href="./css/main.css" rel="stylesheet" type="text/css" /> -->

<style type="text/css">
#footer {
	padding: 10px 0;
	position: absolute;
	bottom: 10px;
	width: 98%;
	text-align: center;
	clear: both; 
	text-align: center;
	overflow: auto;
}
</style>
</head>

<body background="./images/bg.jpg">

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
	<tr style="display: none;">
		<td><div id="ulevel" style="visibility: hidden;">1</div></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="loginbtn" 
			value="登录" onclick="userLogin();" />
		<br/>
		还没有账号？<a href="./user/register.jsp">立即注册</a>
		</td>
	</tr>
</table>
</div>

<br/><br/>


<div id="footer" align="center">
<hr />
All Rights Reserved.<br />
版权所有 Copyright&copy;2015 <a href="/admin.jsp">Cai Shijian</a>. <br />
</div>
</body>
</html>
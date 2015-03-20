<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script type='text/javascript' src='$(pageContext.request.contextPath)/dwr/engine.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/util.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/interface/weiboMsg.js'></script>
<script type='text/javascript' src='./js/jquery-1.8.3.js'></script>
<script type='text/javascript' src='./js/sendmsg.js'></script>
<script type='text/javascript' src='./js/postcount.js'></script>

<title>...欢迎...</title>
<link href="./css/thrColLiqHdr.css" rel="stylesheet" type="text/css" />
<!-- <link href="./css/cssDialog.css" rel="stylesheet" type="text/css" /> -->
<link type="text/css" rel="stylesheet" href="./css/postcount.css" />

</head>
<body onload="init();">
	<div class="container">
		<div class="header">
			<%-- <%@ include file="./client/header.jsp"%> --%>
			<jsp:include page="./client/header.jsp" />
		</div>
		<div class="sidebar1">
			<%@ include file="./client/sidebar1.jsp"%>
		</div>
		<div class="content">
		<!-- 显示字数 -->
		<div class="area">
			<div class="box01-num">
				<span><img src="images/img01.gif" /></span>
				<p>
					还可以输入<b class="num">140</b>字
				</p>
			</div>
		<!-- 发消息用的对话框 -->
		<div id="post" class="dialog">
		<table border="1" align="center">
			<tr>
				<td>
					<div class="inputarea">
						<textarea id="content" class="checkTextarea" cols="50" rows="8" style="height: 82px; width: 431px"></textarea>
					</div>
				</td>
			</tr>
			<tr>
			<td colspan="2" align="right">
				<input type="button" id="hider2" value="发布"
					onclick="addMsg();"/>
				<!-- <input type="button" id="hider3" value="取消" 
					onclick="$('post').style.display='none';"/> -->
			</td>
			</tr>
		</table>
		</div>
		</div>
		
		<hr />
		<table width="450" border="1"  align="center">
		  <caption>即时消息系统</caption>
		  <tbody>
		  <tr>
		    <td id="userPhoto" style="width: 100px; ">photo</td>
		    <th id="viewAuthor">name</th>
		  </tr>
		  <tr>
		    <td style="width: 100px; "></td>
		    <td><div id="viewContent" style="height: 93px; ">content</div></td>
		  </tr>
		  </tbody>
		</table>
		<table width="450" border="1" align="center">
			<tr>
				<td align="right">
				<a href="#" onclick="prePage();return false;">上一页</a>
				<a href="#" onclick="nextPage();return false;">下一页</a>
			</td>
			</tr>
		</table>
		
		<hr>
		</div><!-- end .content -->
		<div class="sidebar2">
			<%@ include file="./client/sidebar2.jsp"%>
		</div>
		<div class="footer">
			<%@ include file="./client/footer.jsp"%>
		</div>
		<!-- end .container -->
	</div>
</body>
</html>
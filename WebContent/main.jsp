<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script type='text/javascript' src='/dwrweibo/dwr/engine.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/util.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/interface/weiboMsg.js'></script>
<script type='text/javascript' src='./js/jquery-1.8.3.js'></script>
<script type='text/javascript' src='./js/main.js'></script>
<script type='text/javascript' src='./js/postcount.js'></script>

<title>...欢迎...</title>
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<!-- <link href="./css/cssDialog.css" rel="stylesheet" type="text/css" /> -->
<link type="text/css" rel="stylesheet" href="./css/postcount.css" />

</head>
<body onload="init();" background="./images/bg.jpg">
	<div class="container">
		<div class="header">
			<%-- <%@ include file="./client/header.jsp"%> --%>
			<jsp:include page="./user/header.jsp" />
		</div>
		<div class="sidebar1">
			<ul class="nav">
		      <li><a href="#">首页</a></li>
		      <li><a href="#">链接二</a></li>
		      <li><a href="#">链接三</a></li>
		      <li><a href="#">链接四</a></li>
			</ul>
		<!-- end .sidebar1 -->
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
		<!-- 发微博对话框 -->
		<div id="post" class="send" >
		<table border="1" align="left">
			<tr>
				<td>
					<div class="inputarea">
						<textarea id="content" class="checkTextarea" cols="50" rows="8"></textarea>
					</div>
				</td>
			</tr>
			<tr>
			<td colspan="2" align="right">
				<span id="err" style="font-size: 10; color:red; "></span>
				<input type="button" id="postbtn" value="发布"
					onclick="addMsg();"/>
			</td>
			</tr>
		</table>
		</div>
		</div>
		<hr />
		
		<!-- 显示微博 -->
		<div id="view" class="view" align="center">
		<table width="450" border="1">
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
		</div>
		
		<!-- 翻页 -->
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
			<h4>背景</h4>
		    <p>本质上，所有 div 中的背景颜色将仅显示与内容一样的长度。如果您希望采用分隔线（而不是颜色），
		    请在 .content div 的侧面放置边框（但仅当其将始终包含更多内容时）。</p>
    	<!-- end .sidebar2 -->
		</div>
		
		<div class="footer">
			<%@ include file="./user/footer.jsp"%>
		</div>
		<!-- end .container -->
	</div>
</body>
</html>
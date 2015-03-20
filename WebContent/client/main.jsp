<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<script type='text/javascript' src='/dwrweibo/dwr/engine.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/util.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/interface/sendMsg.js'></script>
<script type="text/javascript" src="./js/sendmsg.js"></script>

<title>主页</title>
<!-- <link href="../../css/thrColLiqHdr.css" rel="stylesheet" type="text/css" />在WEB-INF目录下 -->
<link href="./css/thrColLiqHdr.css" rel="stylesheet" type="text/css" /><!-- 在WebContent目录下 -->
<!--[if lte IE 7]>
<style>
.content { margin-right: -1px; } /* 此 1px 负边距可以放置在此布局中的任何列中，且具有相同的校正效果。 */
ul.nav a { zoom: 1; }  /* 缩放属性将为 IE 提供其需要的 hasLayout 触发器，用于校正链接之间的额外空白 */
</style>
<![endif]-->
</head>
<body>
<div class="container">
  <div class="header">
  	<%@ include file="header.jsp" %>
  </div>
  <div class="sidebar1">
  	<%@ include file="sidebar1.jsp" %>
  </div>
  <div class="content">
  	<%@ include file="content.jsp" %>
  </div>
  <div class="sidebar2">
  	<%@ include file="sidebar2.jsp" %>
  </div>
  <div class="footer">
  	<%@ include file="footer.jsp" %>
  </div>
  <!-- end .container --></div>
</body>
</html>
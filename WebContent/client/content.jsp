<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align="right">${user.userName}，欢迎您！！</div>
<hr>
<div>
	<textarea id="name" name="name" rows="" cols="" style="height: 90px; width: 377px;"></textarea>&nbsp;
	<br>
	<div align="right" style="width: 377px;">
		<input type="button" value="发&nbsp;布" onclick="sendMessage();"/>
	</div>
</div>
<hr>
<!-- <div id="show"></div> -->
<textarea id="show" name="show" readonly="readonly" rows="" cols="" style="height: 90px; width: 377px;"></textarea>
<hr>
<!-- end .content -->

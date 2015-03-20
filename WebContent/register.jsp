<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type='text/javascript' src='/dwrweibo/dwr/engine.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/util.js'></script>
<script type='text/javascript' src='/dwrweibo/dwr/interface/weiboMsg.js'></script>
<script type='text/javascript' src='./js/sendmsg.js'></script>
<title>注册微博</title>

</head>
<body>
	<div class="navigation">
		<ul>
			<li class="fright"><a href="register.jsp">快速注册</a></li>
			<li class="fright"><a href="index.jsp">登录微博</a></li>
		</ul>
	</div>
	<div id="container">
		<div class="ad1">
			<span class="hook" id="main_top"></span>
		</div>
		<div class="indexh" style="margin: 0px">
			<h3 style="margin-top: 10px">
				欢迎您加入<font color="#ff9000">DWRWEIBO微博系统</font>，请完整填写以下信息进行注册。
			</h3>
		</div>
		<div id="register" class="clearfix">
			<div class="fleft" style="border-right: 1px solid #ececec;">
				<span class="hook" id="register_top"></span>
				<form method="post"
					action="http://t.nextsns.com/?m=index&a=register##" class="lf">
					<table class="regtb">
						<tbody>
							<tr height="40px" valign="top">
								<th><label class="label_input" for="username">用户账号</label></th>
								<td width="220px"><input tabindex="2" type="text"
									id="username" name="username" class="input_text" value=""
									maxlength="12"></td>
								<td class="info" id="check1">帐户名长度最多 6 个汉字或 12 个字符</td>
							</tr>
							<tr height="50px" valign="top">
								<td></td>
								<td colspan="2"><span class="grey">您的网址：http://t.dwrweibo.com/<span
										id="wbadd"></span></span></td>
							</tr>
							<tr height="70px" valign="top">
								<th><label class="label_input" for="mailadres">电子邮箱</label></th>
								<td><input tabindex="4" type="text" id="mailadres"
									name="mailadres" class="input_text" value=""></td>
								<td class="info" id="check2">电子邮箱是找回密码的重要途径，请正确填写</td>
							</tr>
							<tr height="70px" valign="top">
								<th><label class="label_input" for="password1">注册密码</label></th>
								<td><input tabindex="5" type="password" id="password1"
									name="password1" class="input_text" value="" maxlength="20"
									style="ime-mode: disabled" onpaste="return false;"></td>
								<td class="info" id="check3">密码长度4-20位，字母区分大小写</td>
							</tr>
							<tr height="70px" valign="top">
								<th><label class="label_input" for="password2">确认密码</label></th>
								<td><input tabindex="6" type="password" id="password2"
									name="password2" class="input_text" value="" maxlength="20"
									style="ime-mode: disabled" onpaste="return false;"></td>
								<td class="info" id="check4">请再次输入一次注册密码，以确保正确</td>
							</tr>
							<tr height="70px" valign="top">
								<th><label class="label_input" for="authcode">验证码</label></th>
								<td><input tabindex="7" type="text" id="authcode"
									name="authcode" class="input_text" value="" style="width: 80px">
									&nbsp;&nbsp;&nbsp;<a onclick="" title="点击更换验证码"><img
										src="./注册微博_EasyTalk开源微博系统 - Nextsns.com_files/saved_resource"
										id="authcodeimg" alt="验证码"></a></td>
								<td class="info" id="check5">请输入验证码，点击图片更换验证码</td>
							</tr>
							<tr height="70px" valign="top">
								<td></td>
								<td colspan="2"><input tabindex="8" type="button"
									id="btn-reg" class="btn-reg fleft" value="立即注册"
									onclick="userRegist();"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

			<p style="text-align: center; width: 100%; display: block">已有账号？请直接登录：</p>
			<p style="margin-top: 20px; margin-left: 48px">
				<input type="button" onclick="loginbox();" class="button6"
					value="登录微博">
			</p>

		</div>

		<div class="ad2">
			<span class="hook" id="main_bottom"></span>
		</div>
		<div id="footer">
			<br>

		</div>
	</div>
</body>
</html>
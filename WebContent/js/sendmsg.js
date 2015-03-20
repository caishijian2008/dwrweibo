var curPage = 1;
// 保存当前登录的用户
var curUser = -1;
// 登录用的对话框
var login = $("login");
// 发贴用的对话框
var post = $("post");
// 查看帖
var view = $("view");

//定义全局错误处理函数
function errHandler(msg, ex)
{
	alert(ex.message);
}

function init()
{
	// 初始化3个对话框元素
	login = $("login");
	post = $("post");
	view = $("view");
	// 定义全局错误处理器
	dwr.engine.setErrorHandler(errHandler);
	// 设置页面的loadMesssage
	dwr.util.useLoadingMessage();
	//weiboMsg.isLogin(initCb); 
}

// 指定页面加载时指定init()函数
document.body.onload = init;
function initCb(data)
{
	// 如果已经登录系统
	if (data > 0)
	{
		// 将HttpSession中的userId赋给curUser变量。
		curUser = data;
		//addMsg();  ///////////////////////
		getAllMsgByPage();
	}
	// 没有登录
	else
	{
		showDialog(login);
	}
}

function showDialog(element)
{
	// 定义element元素的位置
	element.style.top = document.documentElement.scrollTop 
		+ document.documentElement.clientHeight / 4 +  "px";
	element.style.left = document.documentElement.scrollLeft
		+ document.documentElement.clientWidth / 4 + "px";
	// 让element元素显示出来
	element.style.display = "";
}

function showPost()
{
	if (curUser > 0)
	{
		// 只有当用户已经登录时才显示发帖对话框
		alert("showPost()方法："+curUser);////////
		showDialog(post);
	}
	else
	{
		alert("请先登录系统！2");
	}
	return false;
}


//------按照parms网址截取其中的parmName的参数-------------
/**
 * 按照parms网址截取其中的parmName的参数
 * @param parms 网址，如window.location.href。
 * @param parmName 要截取的参数，如name。
 * @return 被parmName截取的值。
 */
function getWebArgs(parms, parmName)
{
	var argIndex = parms.indexOf("?");
	var arg = parms.substring(argIndex + 1);
	var valArg = "";
	var args = arg.split("&");
	//使用split将参数分解为数组
	for(var i = 0; i < args.length; i++)
	{
		str = args[i];
		var arg = str.split("=");
		if(arg.length <= 1) continue;
		if(arg[0] == parmName) valArg = arg[1];
	}
	return valArg;
}


//------------用户登录------------
function userLogin()
{
//	var user = trim($("user").value);
//	var pass = trim($("pass").value);
	// 必须输入用户名和密码才可以登录
	if (dwr.util.getValue("user") != null 
		&& dwr.util.getValue("user") != "" 
		&& dwr.util.getValue("pass") != null
		&& dwr.util.getValue("pass") != "")
	{
		// 调用loginPro方法处理用户登录
		weiboMsg.validUser(dwr.util.getValue("user"),  
			dwr.util.getValue("pass"), loginCb);
	}
	else
	{
		alert("请先输入用户名和密码！");
	}
}
//------------登录用的回调函数--------------
function loginCb(data)
{
	if (data > 0)
	{
		curUser = data;
		alert("登录成功"+curUser);//////////////
		
		window.location.href = "main.jsp" + "?cur=" 
		+ curUser + "&user=" + dwr.util.getValue("user");
		//login.style.display = "none";
		// 发送列出全部消息的
		//getAllMsgByPage();

	}
	else
	{
		alert("您输入的用户名和密码不匹配！");
	}
}

//-----------获取系统全部消息列表-------------
function getAllMsgByPage()
{
	weiboMsg.getAllMessageByPage(curPage , getMsgCb);
	// 每2秒调用一次getAllMsgByPage()方法来获取消息列表
	setTimeout("getAllMsgByPage();" , 2000);
}
//-----------获取消息列表的回调函数-----------
function getMsgCb(data)
{
	if (data == null && curPage != 1)
	{
		alert("后面已经没有记录了！");
		curPage--;
	}
	if (data != null)
	{
		var show = document.getElementById("view");
		// 删除表格内全部内容。
		dwr.util.removeAllRows("view");
		// 遍历所有的消息列表
		for (var obj in data )
		{
			var row = document.createElement("tr");
			var title = data[obj]['content'];
			var owerName = data[obj]['owerName'];
			var msgId = data[obj]['id'];
			// 添加单元格来显示消息发布者
			var cell = document.createElement("td");
			cell.innerHTML = owerName;
			row.appendChild(cell);
			// 添加单元格来显示消息标题
			cell = document.createElement("td");
			cell.innerHTML = "<a href='#' onclick='getMsg("
				+ msgId + ")'>" + content + "</a>";
			row.appendChild(cell);
			show.appendChild(row);
		}
	}
}

//-------------用户发布新微博---------------
function addMsg()
{
	curUser = getWebArgs(window.location.href, "cur");
	curUser = dwr.util.get(curUser);
	alert("curUser-2->: "+curUser);
	// 如果用户已经登录
	if(curUser > 0)
	{
		// 微博内容不为空
		if (dwr.util.getValue("content") != null
			&& dwr.util.getValue("content") != "")
		{
			//调用createMessage()方法来发布新消息
			weiboMsg.createMessage(dwr.util.getValue("content"), 
					parseInt(curUser), addMsgCb);
			//dwr.util.setValue("title", "");
			dwr.util.setValue("content", "");
		}
		else
		{
			alert("请先输入微博内容");
		}
	}
	else
	{
		alert("请先登录系统！3");
	}
}

function addMsgCb(data)
{
	// 如果发布新消息成功
	if (data > 0)
	{
		alert("添加消息成功");
	}
	else
	{
		alert("添加消息失败");
	}
	// 隐藏发布新消息的对话框
	post.style.display='none';
}

//-------------上页函数-------------
function prePage()
{
	if (curPage <= 1)
	{
		alert("已经是第一页了，无法翻页");
	}
	else
	{
		// 调用getAllMessageByPage方法来发送分页请求
		weiboMsg.getAllMessageByPage(--curPage , getMsgCb);
	}
	return false;
}
//-------------下页函数-------------
function nextPage()
{
	// 调用getAllMessageByPage方法来发送分页请求
	weiboMsg.getAllMessageByPage(++curPage , getMsgCb);
	return false;
}

//----------根据主键获取消息----------
function getMsg(data)
{
	// 如果用户还未登录
	if (curUser > 0)
	{
		if (typeof data == 'number' && data > 0)
		{
			weiboMsg.getMessage(data , getMsgDetailCb);
		}
	}
	else
	{
		alert("请先登录系统！");
	}
	return false;
}
//---------根据主键获取消息的回调函数-------
function getMsgDetailCb(data)
{
	if (data != null)
	{
		dwr.util.setValue('viewTitle' , data.title);
		dwr.util.setValue('viewAuthor' , data.owerName);
		dwr.util.setValue('viewContent' , data.content);
		showDialog(view);
	}
}

//-----------用户注册-----------
function userRegist()
{
	// 如果用户名、密码不为空
	if (dwr.util.getValue("username") != null 
		&& dwr.util.getValue("username") != "" 
		&& dwr.util.getValue("password1") != null 
		&& dwr.util.getValue("password1") != ""
		&& dwr.util.getValue("mailadres") != null 
		&& dwr.util.getValue("mailadres") != "")
	{
		// 调用createUser()方法处理用户注册
		weiboMsg.createUser(dwr.util.getValue("username"), 
			dwr.util.getValue("password1"), 
			dwr.util.getValue("mailadres"), registCb);
	}
	else
	{
		alert("请先输入用户名/密码/邮箱");
	}
}
//-----------注册用的回调函数-----------
function registCb(data)
{
	// 如果注册成功
	if (data > 0)
	{
		//将用户ID赋给curUser变量
		curUser = data;
		alert("注册成功");
		//login.style.display = "none";
		getAllMsgByPage();
	}
	else
	{
		alert("注册失败，请更换新的用户名和密码！");
	}
}
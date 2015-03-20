var curPage = 1;
// ���浱ǰ��¼���û�
var curUser = -1;
// ��¼�õĶԻ���
var login = $("login");
// �����õĶԻ���
var post = $("post");
// �鿴��
var view = $("view");

// ����ȫ�ֵĴ�������
function errHandler(msg , ex)
{
	alert(ex.message);
}
function init()
{
	// ��ʼ��3���Ի���Ԫ��
	login = $("login");
	post = $("post");
	view = $("view");
	// ����ȫ�ִ�������
	dwr.engine.setErrorHandler(errHandler);
	ms.isLogin(initCb); 
}
// ָ��ҳ�����ʱָ��init()����
document.body.onload = init;
function initCb(data)
{
	// ����Ѿ���¼ϵͳ
	if (data > 0)
	{
		// ��HttpSession�е�userId����curUser������
		curUser = data;
		getAllMsgByPage();
	}
	// û�е�¼
	else
	{
		showDialog(login);
	}
}

function showDialog(element)
{
	// ����elementԪ�ص�λ��
	element.style.top = document.documentElement.scrollTop 
		+ document.documentElement.clientHeight / 4 +  "px";
	element.style.left = document.documentElement.scrollLeft
		+ document.documentElement.clientWidth / 4 + "px";
	// ��elementԪ����ʾ����
	element.style.display = "";
}

function showPost()
{
	if (curUser > 0)
	{
		// ֻ�е��û��Ѿ���¼ʱ����ʾ�����Ի���
		showDialog(post);
	}
	else
	{
		alert("���ȵ�¼ϵͳ��");
	}
	return false;
}

//------------�û���¼------------
function userLogin()
{
	// ���������û���������ſ��Ե�¼
	if (dwr.util.getValue("user") != null 
		&& dwr.util.getValue("user") != "" 
		&& dwr.util.getValue("pass") != null
		&& dwr.util.getValue("pass") != "")
	{
		// ����loginPro���������û���¼
		ms.loginPro(dwr.util.getValue("user") , 
			dwr.util.getValue("pass") , loginCb);
	}
	else
	{
		alert("���������û���������");
	}
}
//------------��¼�õĻص�����--------------
function loginCb(data)
{
	if (data > 0)
	{
		curUser = data;
		alert("��¼�ɹ�");
		login.style.display = "none";
		// �����г�ȫ����Ϣ��
		getAllMsgByPage();

	}
	else
	{
		alert("��������û��������벻����");
	}
}

//-----------��ȡϵͳȫ����Ϣ�б�-------------
function getAllMsgByPage()
{
	ms.getAllMessageByPage(curPage , getMsgCb);
	// ÿ2�����һ��getAllMsgByPage()��������ȡ��Ϣ�б�
	setTimeout("getAllMsgByPage();" , 2000);
}
//-----------��ȡ��Ϣ�б�Ļص�����-----------
function getMsgCb(data)
{
	if (data == null && curPage != 1)
	{
		alert("�����Ѿ�û�м�¼�ˣ�");
		curPage--;
	}
	if (data != null)
	{
		var show = document.getElementById("show");
		// ɾ�������ȫ�����ݡ�
		dwr.util.removeAllRows("show");
		// �������е���Ϣ�б�
		for (var obj in data )
		{
			var row = document.createElement("tr");
			var title = data[obj]['title'];
			var owerName = data[obj]['owerName'];
			var msgId = data[obj]['id'];
			// ��ӵ�Ԫ������ʾ��Ϣ������
			var cell = document.createElement("td");
			cell.innerHTML = owerName;
			row.appendChild(cell);
			// ��ӵ�Ԫ������ʾ��Ϣ����
			cell = document.createElement("td");
			cell.innerHTML = "<a href='#' onclick='getMsg("
				+ msgId + ")'>" + title + "</a>";
			row.appendChild(cell);
			show.appendChild(row);
		}
	}
}

//-------------�û���������Ϣ---------------
function addMsg()
{
	// ����û��Ѿ���¼
	if(curUser > 0)
	{
		// ��Ϣ���⡢��Ϣ���ݲ�Ϊ��
		if (dwr.util.getValue("title") != null 
			&& dwr.util.getValue("title") != "" 
			&& dwr.util.getValue("content") != null
			&& dwr.util.getValue("content") != "")
		{
			//����createMessage()��������������Ϣ
			ms.createMessage(dwr.util.getValue("title") , 
				dwr.util.getValue("content") , parseInt(curUser) , addMsgCb);
			dwr.util.setValue("title", "");
			dwr.util.setValue("content", "");
		}
		else
		{
			alert("����������Ϣ�������Ϣ����");
		}
	}
	else
	{
		alert("���ȵ�¼ϵͳ��");
	}
}

function addMsgCb(data)
{
	// �����������Ϣ�ɹ�
	if (data > 0)
	{
		alert("�����Ϣ�ɹ�");
	}
	else
	{
		alert("�����Ϣʧ��");
	}
	// ���ط�������Ϣ�ĶԻ���
	post.style.display='none';
}

//-------------��ҳ����-------------
function prePage()
{
	if (curPage <= 1)
	{
		alert("�Ѿ��ǵ�һҳ�ˣ��޷���ҳ");
	}
	else
	{
		// ����getAllMessageByPage���������ͷ�ҳ����
		ms.getAllMessageByPage(--curPage , getMsgCb);
	}
	return false;
}
//-------------��ҳ����-------------
function nextPage()
{
	// ����getAllMessageByPage���������ͷ�ҳ����
	ms.getAllMessageByPage(++curPage , getMsgCb);
	return false;
}

//----------����������ȡ��Ϣ----------
function getMsg(data)
{
	// ����û���δ��¼
	if (curUser > 0)
	{
		if (typeof data == 'number' && data > 0)
		{
			ms.getMessage(data , getMsgDetailCb);
		}
	}
	else
	{
		alert("���ȵ�¼ϵͳ��");
	}
	return false;
}
//---------����������ȡ��Ϣ�Ļص�����-------
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

//-----------�û�ע��-----------
function userRegist()
{
	// ����û��������벻Ϊ��
	if (dwr.util.getValue("user") != null 
		&& dwr.util.getValue("user") != "" 
		&& dwr.util.getValue("pass") != null 
		&& dwr.util.getValue("pass") != "")
	{
		// ����createUser()���������û�ע��
		ms.createUser(dwr.util.getValue("user") ,
			dwr.util.getValue("pass") , registCb);
	}
	else
	{
		alert("���������û���������");
	}
}
//-----------ע���õĻص�����-----------
function registCb(data)
{
	// ���ע��ɹ�
	if (data > 0)
	{
		//���û�ID����curUser����
		curUser = data;
		alert("ע��ɹ�");
		login.style.display = "none";
		getAllMsgByPage();
	}
	else
	{
		alert("ע��ʧ�ܣ�������µ��û��������룡");
	}
}
/***********************************************************
    [EasyTalk] (C)2009 - 2011 nextsns.com
    This is NOT a freeware, use is subject to license terms

    @Filename weibologin.js $

    @Author hjoeson $

    @Date 2011-01-09 08:45:20 $
*************************************************************/
var loginisshow=0;
$(document).ready(function(){
    var weibologin=$('#weibologin');
    if (weibologin.length>0 && weibologin.html()=='') {
        $.get(siteurl+'/?m=api&a=weibologin',
        function(msg){
            weibologin.append(msg);
        });
    }
});
function dologin(notop) {
	var loginname=$.trim($('#loginname').val());
	var loginpassword=$.trim($('#loginpassword').val());
	var rememberMe=$('#rememberMe').attr("checked");

	if (!loginname || !loginpassword) {
		$('#logintip').html(langjs['loginnull']);
		$('#logintip').show();
		if (notop!='notop') {
			$('#logintip').css('margin-top',-$('#logintip').height()-10);
		}		
	} else {
		$.post(siteurl+"/?m=index&a=dologin",{loginname:loginname,password:loginpassword,rememberMe:rememberMe},
		function(msg){
			var stdata=jQuery.parseJSON(msg);
			if (stdata.ret=="success") {
				if (stdata.uchtml) {
					$('#logintip').html('<img src="'+pubdir+'/images/common/loadingsmall.gif"> '+ langjs['logining'] + stdata.uchtml);
					$('#logintip').show();
					if (notop!='notop') {
						$('#logintip').css('margin-top',-$('#logintip').height()-10);
					}
					setTimeout(function(){window.location.href=stdata.jumpurl;}, 3000);
				} else {
					window.location.href=stdata.jumpurl;
				}
			} else {
				$('#logintip').html(stdata.msg);
				$('#logintip').show();
				if (notop!='notop') {
					$('#logintip').css('margin-top',-$('#logintip').height()-10);
				}
			}
		});
	}
}
function loginbox(){
	if (loginisshow==0){
		ye_dialog.openHtml('<div id="logindiv"><center><br/><br/><img src="'+pubdir+'/images/common/loading2.gif"></center></div>',langjs['loginweibo'],'480','180');
		loginisshow=1;
		$.get(siteurl+"/?m=index&a=login&rank="+GetRandomNum(1,999999),
		function(msg){
			$('#logindiv').html(msg);
		});
	}
}
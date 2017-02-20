<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="login/css/base.css" type="text/css" rel="stylesheet" />
    <link href="login/css/personalSpace.css" type="text/css" rel="stylesheet" />
    <link href="login/css/gips.css" type="text/css" rel="stylesheet" />
    <script src="Js/jquery.min.js" type="text/javascript"></script>
    <script src="Js/input.js" type="text/javascript"></script>
    <title>系统登录</title>
    <script type="text/javascript">
        function formSubmit() {
            if ($("#username").val() == "" || $("#username").val() == "请输用户名") {
                alert("请输入用户名!");
                $("#username").focus();
                return false;
            }
            if ($("#password").val() == "") {
                alert("请输入密码!");
                $("#passwordtext").focus();
                return false;
            }

            if ($("#type").val() == "") {
                alert("请选择角色!");
                $("#type").focus();
                return false;
            }
            
            $("#form1").submit();
        }

        $.ready = function () {
        	
        	
            $("#passwordtext").focus(
                function () {
                    $("#password").show();
                    $("#password").focus();
                    $("#passwordtext").hide();
                }
            );

            $("#password").blur(
                function () {
                    if ($("#password").val() == "") {
                        $("#passwordtext").show();
                        $("#password").hide();
                    }
                }
            );
        }
    </script>
</head>
<body>
	
    <div class="loginhead">
    </div>
    <div class="loginbody">
        <form id="form1" name="form1" onsubmit="return checkform(this);" action="login.action">
        <div class="logBgWap">
            <div class="loginBg">
                <div class="avatar" style="display: none;">
                    <img src="login/images/touxiang.png" /></div>
                <div class="loginTit">
                	欢迎使用一卡通数据集成中心系统！<br />
                </div>
                <div>
					<p><font color="red"  style="text-align:center;padding:5px 0;font-size:15px">${requestScope.message}</font><p>
				</div>
                <div class="W_login_form" id="pl_login_form">
                    <div class="info_list clearfix" node-type="username_box">
                        <span class="fl"></span>
                        <div class="inp username fl">
                            <input type="text" id="username" name="account" value="请输用户名" class="W_input" tabindex="1" maxlength="128" onfocus='OnfocusTextBox(this,"请输用户名");' onblur='OnblurTextBox(this,"请输用户名");' />
                        </div>
                    </div>
                    <div class="info_list clearfix" node-type="password_box">
                        <div class="inp password fl">
                            <input type="text" id="passwordtext" value="请输入密码" class="W_input" node-type="password" tabindex="2" maxlength="24" />
                            <input type="password" id="password" class="W_input" name="password" node-type="password" tabindex="3" maxlength="24" style="display: none;" onfocus='OnfocusTextBox(this,"");' onblur='OnblurTextBox(this,"");' />
                        </div>
                    </div>
                    <div class="info_list clearfix" node-type="type_box">
                        <span class="fl"></span>
                        <div class="inp type fl">
                            <select id="type" name="role" class="W_input" tabindex="4">
                                <option value="">请选择</option>
                                <option value="normal">普通用户</option>
                                <option value="root">系统管理员</option>
                            </select>
                        </div>
                    </div>
                    <div class="info_list auto_login clearfix" style="margin-top:60px">
                        <button class="passbtn" onclick="return formSubmit();">
                        </button>
                    </div>
                    <div class="linkbtn">
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</body>
</html>

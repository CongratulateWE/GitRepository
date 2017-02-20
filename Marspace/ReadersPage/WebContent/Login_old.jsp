<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	
	<script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
	<title>登录系统</title>
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>管理员登录<h2>
	</div>
	<div style="text-align:center;padding:5px 0">
		<p><font color="red">${requestScope.message}</font><p>
	</div>
	<div align="center">
	<div class="easyui-panel" title="管理员登录" style="text-align:center;width:100%;max-width:350px;padding:30px 60px;">
		<form id="loginForm" action="login.action" method="post" onsubmit="return myonsubmit();"
		style="text-align:center;padding:30 0">
	
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="account" data-options="iconCls:'icon-man',iconWidth:28,value: 'admin'" style="width:200px;height:34px;padding:10px">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="password" prompt="Password" iconWidth="28" style="width:200px;height:34px;padding:10px">
			</div>
			
			<div style="margin:20px 20px" align="left">
				<input type="checkbox" name="role" value="root" style="vertical-align:middle;">&nbsp;&nbsp;管理员身份登录<br>
			</div>
			
			<div style="text-align:center;padding:5px 0">
				<input class="easyui-linkbutton" type="submit" value="登录" style="width:110px;height:35px">           
	            <!--a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:100px">Login</a-->
	        </div>
		</form>
	</div>
	</div>
	<script type="text/javascript">
		function myonsubmit(){
			//判断表单项是否为空
			if(loginForm.account.value==''){  
		        alert("用户名不能为空1!");   
		        return false;  
		    }  
			
		    if(loginForm.password.value==''){  
		        alert("密码不能为空!");         
		        return false;  
		    }
		    return true;
		}
		function submitForm(){
			if(myonsubmit())
            	$('#loginForm').form('submit');
        }
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
		
	<script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="Js/easyui-lang-zh_CN.js"></script>
	
	<style type="text/css">
		.easyui-linkbutton{
			width: 200px;
			height:100px;
		}
	</style>
	<title>登录成功</title>
</head>
<body background="image/welcome.jpg">
	<div style="text-align:center;padding:5px 0">
		<h1>欢迎来到XX管理系统</h1>
	</div>
	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="gotoMysql()">
		<font size="6" align="center">	Mysql数据库</font></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="gotoOracle()">
		<font size="6">	Oracle数据库</font>
	</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="gotoAddCard()">
		<font size="6">	学生补卡</font>
	</a>
	<script type="text/javascript">
		function gotoMysql(){
			window.open("mysql/studentTable.jsp");
		}
		function gotoOracle(){
			window.open("result.jsp");
		}
		function gotoAddCard(){
			window.open("studentAddCard.jsp");
		}
	</script>
</body>
</html>
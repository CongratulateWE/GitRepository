<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	
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

	<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Login.jsp">登录</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="Welcome.jsp">Welcome</a>
                    </li>
                    <li>
                        <a href="mysql/studentTable.jsp">Mysql数据库</a>
                    </li>
                    <li>
                        <a href="result.jsp">Oracle数据库</a>
                    </li>
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<div style="text-align:center;padding:5px 0;font-size:30px"> 
		<h1>欢迎来到XX管理系统</h1>
	</div>
	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="gotoMysql()">
		<font size="6" align="center">	Mysql数据库</font></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="gotoOracle()">
		<font size="6">	Oracle数据库</font>
	</a>
	
	<script type="text/javascript">
		function gotoMysql(){
			window.open("mysql/studentTable.jsp");
		}
		function gotoOracle(){
			window.open("result.jsp");
		}
	</script>
	
	<!-- jQuery -->
    <script src="Js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Js/bootstrap.min.js"></script>
</body>
</html>
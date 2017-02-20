<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<!-- bootstarp -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

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
<title>学生补卡</title>
</head>
<body>

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
					
                  	<li class="active">
                        <a href="studentAddCard.jsp">学生补卡</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


	<div style="text-align:center;padding:5px 0;margin-top:50px">
		<h2>学生补卡<h2>
	</div>
<div align="center">
	<div class="easyui-panel" title="填写学生信息" style="width:40%;padding:10px;text-align:center;">
        <form id="ff" action="addcard.action" method="post" >
            <table>
            	<tr>
            		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">身份证号:</td>
                        <td><input name="id_card" class="f1 easyui-textbox" required="true"></input></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>
                        	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="check()" style="width:80px">检查</a>
                        </td>
                    </tr>
                    <tr>
                   		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td align="right" height="40px">检查结果:</td>
                        <td><input name="old_id" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                    	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td align="right" height="40px">修改ID:</td>
                        <td><input name="campus_card" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                    	<td></td>
                    	<!--  <td><input type="submit" class="easyui-linkbutton" value="提交" style="width:80px;height:30px"></td> -->
                    </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
        </div>
    </div>
</div>
    <script type="text/javascript">
    	 function check(){
    		$.post('checkUser.action',{
    			id_card: ff.id_card.value,
    		},function(data){
				if(data.success)
				{
					document.getElementsByName("old_id").value = '用户已经找到，可以进行修改';
					$.messager.alert('查找成功', data.msg, 'info');
				}
				else
				{
					document.getElementsByName("old_id").value = '没有找到用户';
					$.messager.alert('查找失败', data.msg, 'info');
				}
    		})
    	}
    
    	function submitForm(){
    		
    		$.post('addcard.action',{
    			id_card: ff.id_card.value,
    			campus_card: ff.campus_card.value
    		},function(data){
				if(data.success)
				{
					$.messager.alert('修改成功', data.msg, 'info');
				}
				else
				{
					$.messager.alert('修改失败', data.msg, 'info');
				}
    		})
    	} 
    	$(function(){ 
    		$('#ff').form({
    			success: function(data){
    				if(!data.success)
    				{
    					$.messager.alert('修改成功', data.msg, 'info');
    				}
    				else
    				{
    					$.messager.alert('修改失败', data.msg, 'info');
    				}
    			}
    		})
    	})
    </script>
</body>
</html>
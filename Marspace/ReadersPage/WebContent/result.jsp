<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 
    import = "Entity.*"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
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
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	
	<script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="Js/Pagefilter.js"></script>
	<script type="text/javascript" src="Js/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
		var url;		
		function newUser(){
			window.open("newReader.jsp");
		}
		function showUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				window.open("showDetailAction?lib_id=" + row.lib_id );
			}
		}
		
		function destroyUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','这将会在数据库中删除此用户，你确定吗?',function(r){
					if (r){
						$.post('deleteAction',{lib_id:row.lib_id},function(result){
							if (result.success){
								//$('#dg').datagrid('reload');	// reload the user data
								//$('#dg').datagrid('deleteRow',row.index);
								searchByPage(1,20);	//重载数据库
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
		function removeUser(){
			var row = $('#dg').datagrid('getSelected');
			var rowIndex = $('#dg').datagrid('getRowIndex', row);
			window.alert('只是移除而非删除：' + rowIndex);
			$('#dg').datagrid('deleteRow',rowIndex);
		}
		
		function searchUser(){
			var lib_id = document.getElementById("tblib_id").value;
			if (lib_id)
			{
				$.post('searchId',{lib_id: lib_id},
					function(data)
					{
						//这里不能parse，因为action中返回的数据不一样，也可以将action中的arraylist改为数组形式
						$('#dg').datagrid('loadData', data);	
					},'json');
			}
				/* $('#dg').datagrid({				
					url:'searchId?lib_id=' + lib_id,
				}); */
			else
				$.messager.alert('lib_id为空', "需要输入读者证号", 'info');
		}
		function searchAllUser(){
			/* $('#dg').datagrid({
				url:"testByjson",
				loadFilter: pagerFilter
			}); */
			searchByPage(1,15);
		}
		
		function Photepage(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				//alert("showDetailAction?lib_id=" + row.lib_id );
				window.open("aa.jsp?lib_id=" + row.lib_id);
			}			
		}
		
		//改变页后触发事件中调用
		function searchByPage(page,size){
			//$.messager.alert('触发事件', '触发事件searchbypage', 'info');
			
			$.post('searchPageAction',{
				page: page,
				pageSize: size
				},
				function(data)
				{
					$('#dg').datagrid('loadData', JSON.parse(data));
					/* $('#dg').datagrid('getPager').pagination('refresh',{
						pageNumber:page,
						pageSize:size
					}); */
				},'json');
		}
		
		
		$(function() {
			$('#dg').datagrid({
				loadMsg : "正在加载，请稍后...",
				collapsible : true //可折叠 
	//			url: 'testByjson'
			});
			
			$('#dg').datagrid('getPager').pagination({
				showPageList: true,
				onSelectPage: function(pageNumber, pageSize) {
					//alert('onSelectPage: ' + pageNumber);
					searchByPage(pageNumber, pageSize);
				},
				onChangePageSize: function(pageSize) {
					//alert("changepage");	//这个没能实现，不过关系不大，表现就是刷新了当前页但是不会跳到首页
					searchByPage(1, pageSize);
				}
				/* onRefresh: function(pageNumber, pageSize) {
					alert("onrefresh");		//这个也没能实现，连一点反应都没有，到底为啥呢？
					searchByPage(pageNumber, pageSize);
				} */
			});
			
			searchByPage(1,15);		//打开后显示第一页数据，采用最契合页面大小的size = 20
		});
		
	</script>

<title>查询读者库</title>
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
                    <li class="active">
                        <a href="result.jsp">Oracle数据库</a>
                    </li>
					<% 
						if(session.getAttribute("role").equals("root")) {
					%>
                  	<li>
                        <a href="studentAddCard.jsp">学生补卡</a>
                    </li>
                    <%} %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<!--  
	<h1 align = "center">读者库</h1>
	-->
	<!-- 简单的查询表单，虽然能用，但是由于不知名的原因需要查询两次才能达到我要的结果，暂时先不用了 -->
	<!--
	<div class="ftitle">查询条件</div>
		<form id="searchform" action = "searchId" method="post" novalidate>
			<div class="fitem">
				<label>借书证号：</label>
				<input name="lib_id" class="easyui-validatebox" required="true">
				<input type = "submit" value="查询" class="easyui-linkbutton">
				<input type = "reset" value = "重写" name = "reset" class="easyui-linkbutton">
			</div>
		</form>
	</div>
	-->
	
	<!-- 数据表，没有设置url -->
	<div style="margin-top:50px;">
	<table id="dg" title="查询结果" class="easyui-datagrid" style="width:0.9;height:1;"
		toolbar="#toolbar" pagination="true" pageSize="15" pageList="[10,15,20,50,100]"
		rownumbers="true" fitColumns="true" singleSelect="true"
		data-options="autoRowHeight:false">
		<thead>
			<tr>
				<th data-options="field:'lib_id',width:100">借书证号</th>
				<th data-options="field:'reader_id',width:80">读者编号</th>
				<th data-options="field:'name',width:80,align:'center'">姓名</th>
				<th data-options="field:'gender',width:50">性别</th>
				<th data-options="field:'level',width:100,align:'center'">读者等级</th>
				<th data-options="field:'id_card',width:100,align:'center'">身份证号</th>
				<th data-options="field:'level_code',width:60,align:'center'">等级代码</th>
				<th data-options="field:'div_code',width:60,align:'center'">单位代码</th>
				<th data-options="field:'division',width:60,align:'center'">单位</th>
				<th data-options="field:'primarykey',width:60,align:'center'">主键码</th>
				<th data-options="field:'libkey',width:60,align:'center'">馆键码</th>
				
			</tr>
		</thead>
	</table>
	</div>>
	<!-- 数据表的工具栏 -->
	<div id="toolbar" style="padding:5px;height:auto">
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建读者用户</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="showUser()">读者详情</a>
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="searchAllUser()">刷新</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="Photepage()">上传图片</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除用户</a>
		</div>
		<div>
			<label>借书证号:</label>
			<input name="lib_id" class="easyui-validatebox" id = "tblib_id">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchUser()">查找用户</a>
			
		</div>
		
	</div>
	
	
	<!-- 搜索表单的控制代码，同样暂时不用了 -->
	<script type="text/javascript">
		$(function(){
			$('#searchform').form({
				success:function(data){
					$('#dg').datagrid({
						url: null
					});
					$('#dg').datagrid('loadData', JSON.parse(data));
				}
			});
		});
	</script>
	
	<div id="dlg" class="easyui-dialog" style="width:350px;height:180px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
		<div class="ftitle">上传图片</div>
		<form id="fm" method="post" >
			<div class="fitem">
				<label>一卡通卡号:</label>
				<input name="campus_card" class="easyui-validatebox" required="true">
			</div>
			
		</form>
	</div>

    <!-- Bootstrap Core JavaScript -->
    <script src="Js/bootstrap.min.js"></script>
	
</body>
</html>
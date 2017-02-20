<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
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
	
	<script type="text/javascript" src="../Js/jquery.min.js"></script>
	<script type="text/javascript" src="../Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../Js/Pagefilter.js"></script>
	
	<script type="text/javascript">
		var temp;
		var url;
		function newUser(){
			window.open("newStudent.jsp");
		}
		function showUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				window.open("showDetail.action?lib_id=" + row.id );
			}
		}
		
		//修改图书证号，如果需要修改其他列的话可以再添加，就是会显得有点长
		function editUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#dlg').dialog('open').dialog('setTitle','Edit User');
				$('#fm').form('load',row);
				//url = 'update_user.php?id='+row.id;
				//temp = row.campus_card_lib;
				url = 'update.action?lib_id=' + row.id + '&new_lib=';
			}
		}
		
		//确认修改信息
		function executeEdit(){
			
			$('#fm').form('submit',{
				url: url + fm.campus_card.value,
				/* data: {
					new_lib:fm.campus_card.value, 
					lib_id: temp
				}, */
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.errorMsg){
						$.messager.show({
							title: 'Error',
							msg: result.errorMsg
						});
					} else {
						$('#dlg').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
					}
				}
			});
		}
		
		function destroyUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','这将会在数据库中删除此用户，你确定吗?',function(r){
					if (r){
						$.post('deleteAction',{lib_id:row.id},function(result){
							if (result.success){
								//$('#dg').datagrid('reload');	// reload the user data
								//$('#dg').datagrid('deleteRow',row.index);
								$.messager.alert('操作提示', "删除成功", 'info');
								searchByPage(1,15);	//重载数据库
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
						$('#dg').datagrid('loadData', data);
					},'json');   
			}
				//$('#dg').datagrid('load', 'searchId?lib_id=' + lib_id);
			else
				$.messager.alert('lib_id为空', "需要输入ID", 'info');
		}
		function searchAllUser(){
			/* $('#dg').datagrid({
				url:"testByjson",
				loadFilter: pagerFilter
			}); */
			searchByPage(1,15);
		}
		
		//改变页后触发事件中调用
		function searchByPage(page,size){
			
			$.post('searchPageAction',{
				page: page,
				pageSize: size
				},
				function(data)
				{
					$('#dg').datagrid('loadData', JSON.parse(data));
				},'json');   
			 
			//本来执行这一条句子就很好，但是为什么不用呢？p总是莫名其妙的变成1,1，没法继续
			 /*var url = 'searchPageAction?page='+page+'&pageSize='+size;
				alert(url);
			//$('#dg').datagrid('load', url);
			
			  $('#dg').datagrid({
				url:url
			});   */
		}
		
		
		$(function() {
			$('#dg').datagrid({
				loadMsg : "正在加载，请稍后...",
				collapsible : false //可折叠 
	//			url: 'testByjson'
			});
			var opts = $('#dg').datagrid('options');
			$('#dg').datagrid('getPager').pagination({
				showPageList: true,
				onSelectPage: function(pageNumber, pageSize) {
					//alert('onSelectPage: ' + pageNumber);
					
					searchByPage(pageNumber, pageSize);
					//opts.pageNumber = pageNumber;
					//opts.pageSize = pageSize;
				},
				onChangePageSize: function(pageSize) {
					//alert("onChangePageSize");	//这个没能实现，不过关系不大
					searchByPage(1, pageSize);
				}
			});
			
			searchByPage(1,15);		//打开后显示第一页数据，采用最契合页面大小的size = 20
		});
		
	</script>
	
	
	
	<title>学生信息表</title>
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
                        <a href="../Welcome.jsp">Welcome</a>
                    </li>
                    <li class="active">
                        <a href="studentTable.jsp">Mysql数据库</a>
                    </li>
                    <li>
                        <a href="../result.jsp">Oracle数据库</a>
                    </li>
                 	<% 
						if(session.getAttribute("role").equals("root")) {
					%>
                  	<li>
                        <a href="../studentAddCard.jsp">学生补卡</a>
                    </li>
                    <%} %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	<div style="margin-top:50px;">
	<!-- 数据表，没有设置url -->
	<table id="dg" title="查询结果" class="easyui-datagrid" style="width:0.9;height:1;"
		toolbar="#toolbar" pagination="true" pageList="[15,20,50,100]" pageSize="15" 
		rownumbers="false" fitColumns="false" singleSelect="true"
		data-options="autoRowHeight:false">
		<thead>
			<tr>
				<th data-options="field:'id',width:60">ID</th>
				<th data-options="field:'student_id',width:100">学号</th>
				<th data-options="field:'name',width:80,align:'center'">姓名</th>
				<th data-options="field:'gender',width:50">性别</th>
				<th data-options="field:'nationality',width:50">民族</th>
				
				<th data-options="field:'campus_card',width:120,align:'center'">一卡通卡号</th>
				<th data-options="field:'campus_card_lib',width:120,align:'center'">一卡通图书证号</th>
				<th data-options="field:'id_card',width:120,align:'center'">身份证号</th>
				<th data-options="field:'div_code',width:60,align:'center'">部门代码</th>
				<th data-options="field:'division',width:100,align:'center'">部门</th>
				
				<th data-options="field:'dormitory_id',width:60,align:'center'">公寓ID</th>
				<th data-options="field:'dormitory',width:100,align:'center'">公寓</th>
				<th data-options="field:'floor',width:60,align:'center'">楼层</th>
				<th data-options="field:'room_id',width:60,align:'center'">房间ID</th>
				<th data-options="field:'room',width:60,align:'center'">房间名称</th>
							
				<th data-options="field:'bed',width:60,align:'center'">床位号</th>
				<th data-options="field:'startdate',width:120,align:'center'">入学时间</th>
				<th data-options="field:'type',width:120,align:'left'">人员类别</th>
			</tr>
		</thead>
	</table>
	</div>
	<!-- 数据表的工具栏 -->
	<div id="toolbar" style="padding:5px;height:auto">
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建读者用户</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="showUser()">读者详情</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改信息</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="searchAllUser()">显示所有用户</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="destroyUser()">删除用户</a>
		</div>
		<div>
			<label>借书证号:</label>
			<input name="lib_id" class="easyui-validatebox" id = "tblib_id">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchUser()">查找用户</a>
			
		</div>
		
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:350px;height:180px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
		<div class="ftitle">修改卡号</div>
		<form id="fm" method="post" >
			<div class="fitem">
				<label>一卡通卡号:</label>
				<input name="campus_card" class="easyui-validatebox" required="true">
			</div>
			
		</form>
	</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="executeEdit()">OK</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

    <!-- Bootstrap Core JavaScript -->
    <script src="../Js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	
	<script type="text/javascript" src="../Js/jquery.min.js"></script>
	<script type="text/javascript" src="../Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../Js/easyui-lang-zh_CN.js"></script>
	
<title>添加学生</title>
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>添加新用户</h2>
	</div>
	
	<div align="center">
	<div class="easyui-panel" title="填写学生信息" style="width:60%;padding:10px;">
            <form id="ff" action="insert.action" method="post" enctype="multipart/form-data" >
                <table>
					<tr>
                        <td align="right" height="40px">学号:</td>
                        <td><input name="student_id" class="f1 easyui-textbox" required="true"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">姓名:</td>
                        <td><input name="name" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">身份证号:</td>
                        <td><input name="id_card" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">一卡通号:</td>
                        <td><input name="campus_card" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">一卡通图书证号:</td>
                        <td><input name="campus_card_lib" class="f1 easyui-textbox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">性别用单选框:</td>
                        <td><input name="gender" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">民族:</td>
                        <td><input name="nationality" class="f1 easyui-textbox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">部门名称:</td>
                        <td><input name="division" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">部门代码:</td>
                        <td><input name="div_code" class="f1 easyui-textbox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">公寓ID:</td>
                        <td><input name="dormitory_id" class="f1 easyui-textbox"></input></td>
                        <td></td>
						<td align="right" height="40px">公寓名称:</td>
                        <td><input name="dormitory" class="f1 easyui-textbox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">房间ID:</td>
                        <td><input name="room_id" class="f1 easyui-textbox"></input></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td align="right" height="40px">房间名称:</td>
                        <td><input name="room" class="f1 easyui-textbox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">楼层:</td>
                        <td><input name="floor" class="f1 easyui-textbox"></input></td>
                        <td></td>
						<td align="right" height="40px">床位号:</td>
                        <td><input name="bed" class="f1 easyui-textbox"></input></td>
                    </tr>
                    <tr>
                        <td align="right" height="40px">入学时间:</td>
                        <td><input name="startdate" class="f1 easyui-datebox"></input></td>
                    </tr>
					<tr>
                        <td align="right" height="40px">人员类别:</td>
                        <td>
                        <select class="easyui-combobox" name="type" data-options="editable:false,panelHeight:'auto'">
		                	<option value="教职工" selected="selected">教职工</option>
		                	<option value="学生" >学生</option>
		                	<option value="本科生">本科生</option>
		                	<option value="研究生">研究生</option>
	               		</select>
                    </tr>
                    <tr>
                        <td align="right" height="40px">学生照片:</td>
                        <td><input name="photopath" class="f1 easyui-filebox"></input></td>
                    </tr>
                    <tr>
                        <td height="40px"></td><td></td>
                        <td><input type="submit" class="easyui-linkbutton" value="提交" style="width:80px;height:30px"></input></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
        <script type="text/javascript">
        	
        </script>
</body>
</html>
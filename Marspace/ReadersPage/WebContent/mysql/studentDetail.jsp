<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>  
<%@page import="Entity.Student"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Student st = (Student) request.getAttribute("student");
	String name = st.getName(); 
	out.write("id: " + st.getId());
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
    <style>
    	body{
    		font-size: 20px;
    	}
    </style>
    <script type="text/javascript" src="../Js/jquery.min.js"></script>
	<script type="text/javascript" src="../Js/jquery.easyui.min.js"></script>
	
	<title>学生详细信息</title>
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>学生详细信息</h2>
	</div>
	<div class="easyui-panel" title="用户信息" style="width:100%;min-width:400px;padding:10px;align:center;">
		<table align="center" margin="30" width="80%" border="1" cellpadding="10"  
            cellspacing="0" style = "font-size: 18px;">
			<tr>
				<td align="right" height="30px" width="60px">ID:</td>
                <td width="250px"><%=st.getId() %></td>
				<td align="right" height="30px" width="40px">学号:</td>
                <td width="250px"><%=st.getStudent_id() %></td>
                <!-- 照片 -->
                <td align="center" rowspan="4">
                	<img name="upload" src="getPhotoAction?lib_id=<%=st.getId() %>"/>
				</td>
			</tr>
			<tr>
				<td align="right" height="30px">姓名:</td>
				<td colspan="3"><%=st.getName() %></td>
			</tr>
			<tr>
				<td align="right" height="30px">性别:</td>
				<td><%=st.getGender() %></td>
				<td align="right" height="30px">民族:</td>
				<td ><%=st.getNationality() %></td>
			</tr>
			<tr>
				<td align="right" height="30px">身份证号:</td>
				<td colspan="3"><%=st.getId_card() %></td>
				
			</tr>
			<!-- tr>
				<td align="right" height="30px">一卡通号:</td>
				<td colspan="3"><%=st.getCampus_card() %></td>
				<td> 
					<s:form action="uploadPhotoAction" method="post" theme="simple"	enctype="multipart/form-data">
                		<s:file label="上传照片" theme="simple"	name="upload" />
                		<s:submit class="btn" value="完成"></s:submit>
                	</s:form>
                </td>
			</tr-->
			<tr>
				<td align="right" height="30px" width="120px" style = "font-size: 16px;">一卡通图书证号:</td>
				<td colspan="4"><%=st.getCampus_card_lib() %></td>
			</tr>
			<tr>
				<td align="right" height="30px" width="100px">部门名称:</td>
				<td><%=st.getDivision() %></td>
				<td align="right" height="30px" width="100px">部门代码:</td>
				<td ><%=st.getDiv_code() %></td>
				<td>
					<table>
						<tr>
						<td align="right" height="30px">人员类别:</td>
						<td><%=st.getType() %></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right" height="30px" width="100px">住宿信息：</td>
				<td colspan="5">
					<table><tr>
						
						<td align="right" height="30px">公寓:</td>
						<td><%=st.getDormitory() %></td>
						<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;公寓代码:</td>
						<td ><%=st.getDormitory_id() %></td>
						<td align="right" >&nbsp;&nbsp;&nbsp;&nbsp;楼层:</td>
						<td><%=st.getFloor() %></td>
						<td align="right" >&nbsp;&nbsp;&nbsp;&nbsp;房间:</td>
						<td><%=st.getRoom() %></td>
						<td align="right" >&nbsp;&nbsp;&nbsp;&nbsp;房间代码:</td>
						<td ><%=st.getRoom_id() %></td>
						<td align="right" >&nbsp;&nbsp;&nbsp;&nbsp;床位: </td>
						<td ><%=st.getBed() %></td>
					</tr></table>
				</td>
			</tr>
		</table>
	
	</div>
</body>
</html>
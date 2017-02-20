<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Register</title>
	<%String lib_id = (String)request.getParameter("lib_id"); %>
</head>
<body>
	<s:form action="uploadPhotoAction" method="post" theme="simple"
		enctype="multipart/form-data">
		<table align="left" width="50%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td><s:textfield name="lib_id"><%=lib_id %></s:textfield></td>
				<td align="right"><s:file label="上传" theme="simple"
						name="upload" /></td>
			</tr>
			<tr>
				<td align="right"><s:submit class="btn" value="完成"></s:submit></td>
				<td align="center"><s:reset class="btn" value="重置"></s:reset></td>
			</tr>
		</table>
	</s:form>

</body>
</html>
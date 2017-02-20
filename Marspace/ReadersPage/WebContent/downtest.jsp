<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Details</title>

</head>
<body>
	<s:form action="UserInfo.action" method="post" theme="simple">
		<table align="left" width="30%" border="1" cellpadding="0"
			cellspacing="0">

			<tr>
				<td><img name="upload"
					src="getPhotoAction" width="128"
					height="128" /></td>
			</tr>
			<tr>
				<td align="right"><s:submit class="btn" value="返回"></s:submit></td>
			</tr>

		</table>
	</s:form>

</body>
</html>
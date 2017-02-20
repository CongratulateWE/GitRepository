<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="ISO-8859-1" import = "net.sf.json.JSONObject" import = "Entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>show result</title>
</head>
<body bgcolor = LightBlue>
<center>
<TABLE align=CENTER border = 1 bgcolor=LightBlue width=850>
	<tr align = center>
		<td>address</td>
		<td>borrow_limit</td>
		<td>borrowed</td>
		<td>deposit</td><td></td><td></td><td></td>
		<td>gender</td>
		<td></td>
		<td>level</td>
		<td></td>
		<td>lib_id</td>
		<td>name</td>
		<td>post_code</td>
		<td>reader_id</td>
		<td></td>
	</tr>
	
</TABLE>
<%
	Reader r = new Reader();
	Object data = request.getAttribute("data");
	System.out.println(data.toString());
%>
</center>	
</body>
</html>
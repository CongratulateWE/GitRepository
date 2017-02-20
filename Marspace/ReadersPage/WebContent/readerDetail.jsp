<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@taglib uri="/struts-tags" prefix="s"%>  
<%@page import="Entity.Reader"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
 	Reader reader = (Reader) request.getAttribute("reader");
	String name = reader.getName(); 
	out.write("name: " + reader.getLib_id());
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<title>学生详细信息</title>
	
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
    
    <script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>学生详细信息</h2>
	</div>
	
	<div class="easyui-panel" title="用户信息" style="width:100%;min-width:400px;padding:10px;align:center;">
        <table align="center" margin="30" width="80%" border="1" cellpadding="10"  
            cellspacing="0" style = "font-size: 18px;">
				<tr>
					<th colspan="4">读者基本信息</th>
					<th align="center" rowspan="4" colspan="2"><img name="upload"
						src="getPhotoAction?lib_id=<%=reader.getLib_id() %>" />
					</th>
				</tr>
				<tr>  
					<td align="right"><s:text name="借书证号"></s:text>:</td>  
					<td align="left"  valign="middle"><%= reader.getLib_id() %></td>
					<td align="right"><s:text name="读者证号"></s:text>:</td>  
					<td align="left"  valign="middle"><%= reader.getReader_id() %></td>
				</tr>  
				
				<tr>
					<td align="right"><s:text name="姓名"></s:text>:</td>
					<td align="left"  valign="middle"><%= reader.getName() %></td>
					<td align="right"><s:text name="性别"></s:text>:</td>
					<td>
					<table><tr>						
						<td align="left" valign="middle"><%= reader.getGender() %></td>
						<td align="right"><s:text name="民族"></s:text>:</td>
						<td align="left" valign="middle"><%= reader.getNationality() %></td>
					</tr></table>
					</td>
				</tr>
				
				<tr>
					<td align="right"><s:text name="身份证号"></s:text>:</td>
					<td align="left" valign="middle" colspan="3"><%= reader.getId_card() %></td>
				</tr>
				
				<tr>
					<td align="right"><s:text name="读者级别"></s:text>:</td>
					<td align="left"  valign="middle"><% if(reader.getLevel()!="' '") out.write(reader.getLevel()); %></td>
					
					<td align="right"><s:text name="级别代码"></s:text>:</td>
					<td align="left"  valign="middle" colspan="3"><%= reader.getLevel_code() %></td>				
				</tr>
				<tr>
					<td align="right"><s:text name="单位"></s:text>:</td>
					<td align="left"  valign="middle"><% if(reader.getDivision()!="' '") out.write(reader.getDivision()); %></td>
					
					<td align="right"><s:text name="单位代码"></s:text>:</td>
					<td align="left"  valign="middle" colspan="3"><%= reader.getDiv_code() %></td>
				<tr>
				
				<tr>
					<td align="right" height="30px" width="100px">电话:</td>
					<td><%=reader.getTel() %></td>
					<td align="right" height="30px" width="100px">Email:</td>
					<td ><%=reader.getEmail() %></td>
					<td align="right" height="30px" width="60px">邮编:</td>
					<td ><%=reader.getPost_code() %></td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">联系地址:</td>
					<td colspan="5"><%=reader.getAddress() %></td>
				</tr>
				<tr>
					<td colspan="6">
					<table border="1">
					<tr>
						<td align="right" height="30px" width="100px">押金:</td>
						<td ><%=reader.getDeposit() %></td>
						<td align="right" height="30px" width="100px">可借阅:</td>
						<td ><%=reader.getBorrow_limit() %></td>
						<td align="right" height="30px" width="100px">已外借:</td>
						<td ><%=reader.getBorrowed() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">发证日期:</td>
						<td ><%=reader.getStartDate() %></td>
						<td align="right" height="30px" width="100px">失效日期:</td>
						<td ><%=reader.getEndDate() %></td>
					</tr>
					
					</table>
					</td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">挂失信息:</td>
					<td colspan="5">
					<table>
					<tr>
						<td ><%
							if(reader.getLock()==null||reader.getLock().equals(" "))
							{
								out.write("挂失0次");
							}
							else if(reader.getLock().equals("挂失"))
							{
								out.write("已挂失，挂失于" + reader.getLockDate());
							}
							else{
								out.write("挂失" + reader.getLock() + "次");
							}
							%></td>
					</tr>
					</table>
					</td>
				</tr>
				<tr>
				<td colspan="6">
					<table border="1">
					<tr>
						<td align="right" height="30px" width="100px">欠罚款:</td>
						<td ><%=reader.getFine() %></td>
						<td align="right" height="30px" width="100px">欠赔款:</td>
						<td ><%=reader.getCompensate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">上次到馆时间:</td>
						<td ><%=reader.getLastDate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">上月外借册数:</td>
						<td ><%=reader.getLastMonthBrrowed() %></td>
						<td align="right" height="30px" width="120px">本月外借册数:</td>
						<td width="190px"><%=reader.getThisMonthBrrowed() %></td>
						<td align="right" height="30px" width="120px">今年外借册数:</td>
						<td width="190px"><%=reader.getLastYearBrrowed() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">去年外借册数:</td>
						<td ><%=reader.getLastYearBrrowed() %></td>
						<td align="right" height="30px" width="100px">累计外借册数:</td>
						<td ><%=reader.getTotalBrrowed() %></td>
					</tr>
					
					<tr>
						<td align="right" height="30px" width="120px">累积超期册数:</td>
						<td ><%=reader.getTotalExpiryBooknum() %></td>
						<td align="right" height="30px" width="120px">累积交罚款:</td>
						<td width="190px"><%=reader.getTotalPaiedfine()%></td>
						<td align="right" height="30px" width="120px">累积交赔款:</td>
						<td width="190px"><%=reader.getTotalPaiedcompensate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">上月到馆次数:</td>
						<td ><%=reader.getLastMonthVisited() %></td>
						<td align="right" height="30px" width="120px">本月到馆次数:</td>
						<td width="190px"><%=reader.getThisMonthVisited() %></td>
						<td align="right" height="30px" width="120px">今年到馆次数:</td>
						<td width="190px"><%=reader.getLastYearVisited() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">去年到馆次数:</td>
						<td ><%=reader.getLastYearVisited() %></td>
						<td align="right" height="30px" width="100px">累计到馆次数:</td>
						<td ><%=reader.getTotalVisited() %></td>
					</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">备注:</td>
					<td colspan="5"><%=reader.getRemark() %>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">保留信息:</td>
					<td colspan="5"><%=reader.getRetain_info() %>
				</tr>
				<tr>
					
				</tr>
  				<%= reader.toString() %>
        </table>
    </div>
</body>
</html>
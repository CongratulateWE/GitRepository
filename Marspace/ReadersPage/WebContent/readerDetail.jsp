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
	<title>ѧ����ϸ��Ϣ</title>
	
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
    
    <script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>ѧ����ϸ��Ϣ</h2>
	</div>
	
	<div class="easyui-panel" title="�û���Ϣ" style="width:100%;min-width:400px;padding:10px;align:center;">
        <table align="center" margin="30" width="80%" border="1" cellpadding="10"  
            cellspacing="0" style = "font-size: 18px;">
				<tr>
					<th colspan="4">���߻�����Ϣ</th>
					<th align="center" rowspan="4" colspan="2"><img name="upload"
						src="getPhotoAction?lib_id=<%=reader.getLib_id() %>" />
					</th>
				</tr>
				<tr>  
					<td align="right"><s:text name="����֤��"></s:text>:</td>  
					<td align="left"  valign="middle"><%= reader.getLib_id() %></td>
					<td align="right"><s:text name="����֤��"></s:text>:</td>  
					<td align="left"  valign="middle"><%= reader.getReader_id() %></td>
				</tr>  
				
				<tr>
					<td align="right"><s:text name="����"></s:text>:</td>
					<td align="left"  valign="middle"><%= reader.getName() %></td>
					<td align="right"><s:text name="�Ա�"></s:text>:</td>
					<td>
					<table><tr>						
						<td align="left" valign="middle"><%= reader.getGender() %></td>
						<td align="right"><s:text name="����"></s:text>:</td>
						<td align="left" valign="middle"><%= reader.getNationality() %></td>
					</tr></table>
					</td>
				</tr>
				
				<tr>
					<td align="right"><s:text name="���֤��"></s:text>:</td>
					<td align="left" valign="middle" colspan="3"><%= reader.getId_card() %></td>
				</tr>
				
				<tr>
					<td align="right"><s:text name="���߼���"></s:text>:</td>
					<td align="left"  valign="middle"><% if(reader.getLevel()!="' '") out.write(reader.getLevel()); %></td>
					
					<td align="right"><s:text name="�������"></s:text>:</td>
					<td align="left"  valign="middle" colspan="3"><%= reader.getLevel_code() %></td>				
				</tr>
				<tr>
					<td align="right"><s:text name="��λ"></s:text>:</td>
					<td align="left"  valign="middle"><% if(reader.getDivision()!="' '") out.write(reader.getDivision()); %></td>
					
					<td align="right"><s:text name="��λ����"></s:text>:</td>
					<td align="left"  valign="middle" colspan="3"><%= reader.getDiv_code() %></td>
				<tr>
				
				<tr>
					<td align="right" height="30px" width="100px">�绰:</td>
					<td><%=reader.getTel() %></td>
					<td align="right" height="30px" width="100px">Email:</td>
					<td ><%=reader.getEmail() %></td>
					<td align="right" height="30px" width="60px">�ʱ�:</td>
					<td ><%=reader.getPost_code() %></td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">��ϵ��ַ:</td>
					<td colspan="5"><%=reader.getAddress() %></td>
				</tr>
				<tr>
					<td colspan="6">
					<table border="1">
					<tr>
						<td align="right" height="30px" width="100px">Ѻ��:</td>
						<td ><%=reader.getDeposit() %></td>
						<td align="right" height="30px" width="100px">�ɽ���:</td>
						<td ><%=reader.getBorrow_limit() %></td>
						<td align="right" height="30px" width="100px">�����:</td>
						<td ><%=reader.getBorrowed() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">��֤����:</td>
						<td ><%=reader.getStartDate() %></td>
						<td align="right" height="30px" width="100px">ʧЧ����:</td>
						<td ><%=reader.getEndDate() %></td>
					</tr>
					
					</table>
					</td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">��ʧ��Ϣ:</td>
					<td colspan="5">
					<table>
					<tr>
						<td ><%
							if(reader.getLock()==null||reader.getLock().equals(" "))
							{
								out.write("��ʧ0��");
							}
							else if(reader.getLock().equals("��ʧ"))
							{
								out.write("�ѹ�ʧ����ʧ��" + reader.getLockDate());
							}
							else{
								out.write("��ʧ" + reader.getLock() + "��");
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
						<td align="right" height="30px" width="100px">Ƿ����:</td>
						<td ><%=reader.getFine() %></td>
						<td align="right" height="30px" width="100px">Ƿ���:</td>
						<td ><%=reader.getCompensate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">�ϴε���ʱ��:</td>
						<td ><%=reader.getLastDate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">����������:</td>
						<td ><%=reader.getLastMonthBrrowed() %></td>
						<td align="right" height="30px" width="120px">����������:</td>
						<td width="190px"><%=reader.getThisMonthBrrowed() %></td>
						<td align="right" height="30px" width="120px">����������:</td>
						<td width="190px"><%=reader.getLastYearBrrowed() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">ȥ��������:</td>
						<td ><%=reader.getLastYearBrrowed() %></td>
						<td align="right" height="30px" width="100px">�ۼ�������:</td>
						<td ><%=reader.getTotalBrrowed() %></td>
					</tr>
					
					<tr>
						<td align="right" height="30px" width="120px">�ۻ����ڲ���:</td>
						<td ><%=reader.getTotalExpiryBooknum() %></td>
						<td align="right" height="30px" width="120px">�ۻ�������:</td>
						<td width="190px"><%=reader.getTotalPaiedfine()%></td>
						<td align="right" height="30px" width="120px">�ۻ������:</td>
						<td width="190px"><%=reader.getTotalPaiedcompensate() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="120px">���µ��ݴ���:</td>
						<td ><%=reader.getLastMonthVisited() %></td>
						<td align="right" height="30px" width="120px">���µ��ݴ���:</td>
						<td width="190px"><%=reader.getThisMonthVisited() %></td>
						<td align="right" height="30px" width="120px">���굽�ݴ���:</td>
						<td width="190px"><%=reader.getLastYearVisited() %></td>
					</tr>
					<tr>
						<td align="right" height="30px" width="100px">ȥ�굽�ݴ���:</td>
						<td ><%=reader.getLastYearVisited() %></td>
						<td align="right" height="30px" width="100px">�ۼƵ��ݴ���:</td>
						<td ><%=reader.getTotalVisited() %></td>
					</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">��ע:</td>
					<td colspan="5"><%=reader.getRemark() %>
				</tr>
				<tr>
					<td align="right" height="30px" width="100px">������Ϣ:</td>
					<td colspan="5"><%=reader.getRetain_info() %>
				</tr>
				<tr>
					
				</tr>
  				<%= reader.toString() %>
        </table>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>添加用户</title>
	
    <link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
    <style type="text/css">
		.fitem{
			margin-bottom:15px;
		}
		.fitem label{
			display:inline-block;
			width:100px;
		}
	</style>
    <script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="Js/easyui-lang-zh_CN.js"></script>
	
</head>
<body>
	<div style="text-align:center;padding:5px 0">
		<h2>添加新用户</h2>
	</div>
	
	<div align="center">
    <div class="easyui-panel" title="用户信息" style="width:70%;min-width:400px;padding:10px;align:center;">
        <form id="ff" action = "insertAction" method="post" accept-charset="utf-8" enctype="multipart/form-data">
            <table>
            	<tr>
                    <td align="right" height="40px">借书证号:</td>
                    <td><input name="lib_id" class="easyui-textbox" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">读者条码:</td>
                    <td><input name="reader_id" class="easyui-textbox"  required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">姓名:</td>
                    <td><input name="name" class="easyui-textbox" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">性别:</td>
                    <td>
						<select class="easyui-combobox" name="gender" style="width:55px" data-options="editable:false,panelHeight:'auto'">
		                	<option value="男" >男</option>
		                	<option value="女">女</option>
	               		</select>
					</td>
                </tr>
                <tr>
                    <td align="right" height="40px">身份证号:</td>
                    <td><input name="id_card" class="easyui-textbox"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">读者级别:</td>
                    <td><input name="level" class="f1 easyui-textbox" required="true"></input></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">级别代码:</td>
                    <td><input name="level_code" class="f1 easyui-textbox" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">单位:</td>
                    <td><input name="division" class="easyui-textbox" required="true"></input></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">单位代码:</td>
                    <td><input name="div_code" class="f1 easyui-textbox" required="true"></input></td>
                </tr>
            	<tr>
                    <td align="right" height="40px">主键码:</td>
                    <td><input name="primarykey" class="f1 easyui-textbox" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">馆键码:</td>
                    <td><input name="libkey" class="f1 easyui-textbox" required="true"></input></td>
                </tr>
                
                <tr>
                    <td align="right" height="40px">电话:</td>
                    <td><input name="tel" class="f1 easyui-textbox"></input></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">邮政编码:</td>
                    <td><input name="post_code" class="f1 easyui-textbox"></input></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">Email:</td>
                    <td><input name="email" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">联系地址  :</td>
                    <td colspan="4"><input name="address" class="f1 easyui-textbox" size="60"></input></td>
                </tr>
			    <tr>
                    <td align="right" height="40px">押金  :</td>
                    <td><input name="deposit" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">可外借  :</td>
                    <td><input name="borrow_limit" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">已外借  :</td>
                    <td><input name="borrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
			    <tr>
			    	<hr>
			    </tr>
			    <tr>
                    <td align="right" height="40px">发证日期 :</td>
                    <td><input name="startDate" class="f1 easyui-datetimebox"></input></td>
                	<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td align="right" height="40px">失效日期 :</td>
                    <td><input name="endDate" class="f1 easyui-datetimebox"></input></td>
                </tr>
                
                <tr>
                    <td align="right" height="40px">挂失注销：</td>
                    <td><input name="lock" class="f1 easyui-textbox"></input></td>
                    <td></td>
                    <td align="right" height="40px">挂失日期 :</td>
                    <td><input name="lockDate" class="f1 easyui-datetimebox"></input></td>
                </tr>
			    <tr>
                    <td align="right" height="40px">欠罚款  :</td>
                    <td><input name="fine" class="f1 easyui-textbox" value="0" required="true"></input></td>
                    <td></td>
                    <td align="right" height="40px">欠赔款 :</td>
                    <td><input name="compensate" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
			    <tr>
			        <td align="right" height="40px">上次到馆时间：</td>
                    <td><input name="lastDate" class="f1 easyui-datetimebox"></input></td>
                </tr>
			    <tr>
                    <td align="right" height="40px">上月外借册数  :</td>
                    <td><input name="lastMonthBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                    <td></td>
                    <td align="right" height="40px">本月外借册数:</td>
                    <td><input name="thisMonthBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">今年外借册数  :</td>
                    <td><input name="thisYearBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                    <td></td>
                    <td align="right" height="40px">去年外借册数:</td>
                    <td><input name="lastYearBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                    <td align="right" height="40px">累计外借册数  :</td>
                    <td><input name="totalBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">累计超期册数:</td>
                    <td><input name="totalExpiryBooknum" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
			    <tr>
                	<td align="right" height="40px">累计交罚款:</td>
                    <td><input name="totalPaiedfine" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">累计赔款:</td>
                    <td><input name="totalPaiedcompensate" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">本月到馆次数:</td>
                    <td><input name="thisMonthVisited" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">上月到馆次数:</td>
                    <td><input name="lastMonthVisited" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">今年到馆次数:</td>
                    <td><input name="thisYearVisited" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
			    <tr>
                	<td align="right" height="40px">去年到馆次数:</td>
                    <td><input name="lastYearVisited" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">累积到馆次数:</td>
                    <td><input name="totalVisited" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">密码:</td>
                    <td><input name="password" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">备注clob:</td>
                    <td><input name="remark" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                        <td align="right" height="40px">照片:</td>
                        <td><input name="photopath" class="f1 easyui-filebox"></input></td>
                    </tr>
                <tr>
                	<td align="right" height="40px">民族:</td>
                    <td><input name="nationality" class="f1 easyui-textbox"></input></td>
                </tr>
			    
			    <tr>
                	<td align="right" height="40px">阅览室外借:</td>
                    <td><input name="readingroomBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">代理人:</td>
                    <td><input name="agent" class="f1 easyui-textbox"></input></td>
                </tr>
			    <tr>
                	<td align="right" height="40px">余额：</td>
                    <td><input name="balance" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">总计:</td>
                    <td><input name="total" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">免费机时:</td>
                    <td><input name="freeHours" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">特借押金:</td>
                    <td><input name="specialBrrowedDeposit" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">已借特借书:</td>
                    <td><input name="specialBrrowed" class="f1 easyui-textbox" value="0" required="true"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">班级:</td>
                    <td><input name="classnum" class="f1 easyui-textbox" ></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">年级:</td>
                    <td><input name="grade" class="f1 easyui-textbox" ></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">专业:</td>
                    <td><input name="major" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">系别:</td>
                    <td><input name="department" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                	<td align="right" height="40px">手机:</td>
                    <td><input name="phone" class="f1 easyui-textbox"></input></td>
                </tr>
                <tr>
                	<td></td><td></td><td></td>
                	<td><input type="submit" value="Submit"></input></td>
                	<td><input type="reset" value="重写"></input></td>
                </tr>
		    </table>     
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
        </div>
    </div>
    </div>
    <script>
        function submitForm(){
            $('#ff').form('submit');
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
</body>
</html>
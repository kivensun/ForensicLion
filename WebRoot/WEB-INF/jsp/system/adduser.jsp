<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<style type="text/css">
table {
	border-collapse: collapse;
}

table,th,td {
	border: 1px solid black;
}
</style>
</head>
<div class="submain">
	<br /> <a id="btnsave" href="javascript:void(0)"
		class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
	<table width="100%">
		<tr>
			<td align="center">姓名</td>
			<td><input id='name' class="easyui-validatebox"
				data-options="required:true,missingMessage:'必须填写'"></td>
			<td align="center">专业</td>
			<td><input id="major" class="easyui-validatebox"
				data-options="required:true,missingMessage:'必须填写'"></td>
		</tr>
		<tr>
			<td align="center">登录名</td>
			<td><input id="loginname" class="easyui-validatebox"
				data-options="required:true,missingMessage:'必须填写'"></td>
			<td align="center">状态</td>
			<td><select id="status">
					<option value="1">有效</option>
					<option value="0">锁定</option>
			</select></td>
		</tr>
		<tr>
			<td align="center">职称</td>
			<td><input id="jobtitle" class="easyui-validatebox"
				data-options="required:true,missingMessage:'必须填写'"></td>
			<td align="center">执业证号</td>
			<td><input id="practicenum"></td>
		</tr>
		<tr>
			<td align="center">权限</td>
			<td height="300">
				<div style="overflow: scroll; font-size: 12; height: 100%;">
					<ul id="tt"></ul>
				</div>
			</td>
			<td align="center">备注</td>
			<td height="300"><textarea style="width: 99%; height: 290px"
					id="remark"></textarea></td>
		</tr>
	</table>
</div>
<script type="text/javascript">
function loadTree(){
	var json = '{\"name\":\"功能管理\" }';
	$.ajax({
		url : "json/listdictionarys",
		type : 'post',
		data : '{\"param\":' + json + '}',
		dataType : 'json',
		success : function(now) {
			$('#tt').tree({
				data : now,
				checkbox : true,
				animate : true
			});

		},
		error : function(xhr) {
			alert('出错。。\n' + xhr.responseText);
		},//////
		contentType : "application/json; charset=utf-8"
	});
}
	$(function() {
		loadTree();
		$('#btnsave').click(function() {
			var _name = $('#name').attr('value');
			var _major = $('#major').attr('value');
			var _loginname = $('#loginname').attr('value');
			var _jobtitle = $('#jobtitle').attr('value');
			var _practiceNum = $('#practicenum').attr('value');
			var _remark = $('#remark').attr('value');
			var _status = $('#status').attr('value');
			var _nodes = $('#tt').tree('getChecked');
			var _registdate = new Date();
			var _myfuns = new Array();
			for ( var i = 0; i < _nodes.length; i++) {
				var _myfun = new Object();
				_myfun.funId = _nodes[i].id;
				_myfuns[i] = _myfun;
			}
			var user = {
				name : _name,
				major : _major,
				loginname : _loginname,
				jobtitle : _jobtitle,
				practiceNum : _practiceNum,
				remark : _remark,
				status : _status,
				myfuns : _myfuns,
				registdate : _registdate
			};
			var strUser = JSON.stringify(user);
			$.ajax({
				url : "json/user_addUser",
				type : 'post',
				data : '{\"user\":' + strUser + '}',
				success : function() {

					$.messager.alert('保存成功', '新增用户信息成功!', 'info', function() {
						closetab('添加新用户');
					});

				},
				error : function(xhr) {
					alert('出错。。\n' + xhr.responseText);
				},//////
				contentType : "application/json; charset=utf-8"
			});
		});
	});
</script>
</html>
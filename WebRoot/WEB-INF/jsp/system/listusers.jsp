<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<style type="text/css">
body {
	font: 12px/20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}
</style>
</head>

<table id="listusers" cellspacing="0" cellpadding="0">
</table>
<script type="text/javascript">
$(function(){
	$('#listusers').datagrid(
			{
				title : '用户列表',
				url : 'json/user_listUsers',
				width : 700,
				//data:json.users,
				height : 'auto',
				nowrap : false,
				striped : true,
				border : true,
				collapsible : false,//是否可折叠的  
				fit : true,//自动大小 		
				remoteSort : false,
				idField : 'id',
				singleSelect : true,//是否单选  
				pagination : true,//分页控件  
				rownumbers : true,//行号   
				pageSize : 20,
				toolbar : [ {
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						addtab("添加新用户", "adduser");
					}
				}, '-', {
					text : '锁定',
					iconCls : 'icon-remove',
					handler : function() {
						var selnode = $('#listusers').datagrid('getSelected');
						if (selnode == null) {
							$.messager.alert('错误', '请选择一行');
						} else {
							$.post("json/user_lockUser", {
								id : selnode.id
							}, function(data) {
								$('#listusers').datagrid('reload');
							});
						}
					}
				}, '-', {
					text : '解锁',
					iconCls : 'icon-remove',
					handler : function() {
						var selnode = $('#listusers').datagrid('getSelected');
						if (selnode == null) {
							$.messager.alert('错误', '请选择一行');
						} else {
							$.post("json/user_unlockUser", {
								id : selnode.id
							}, function(data) {
								$('#listusers').datagrid('reload');
							});
						}
					}
				}],
				columns : [ [
						{
							field : 'id',
							title : '编辑',
							align : 'left',
							width : 80,
							//添加超级链 
							formatter : function(value, rowData, rowIndex) {
								//function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
								//alert(rowData.username);  							
								return "<a onclick='addtab(\"" + rowData.name
										+ "\",\"" + "edituser?id=" + value
										+ "\")'"
										+ "href='javascript:void(0);' >查看</a>";
							}
						}, {
							field : 'name',
							title : '姓名',
							width : 120,
							align : 'left'
						}, {
							field : 'loginname',
							title : '登录名',
							width : '120'
						}, {
							field : 'jobtitle',
							title : '职称',
							width : '150'
						}, {
							field : 'practice_num',
							title : '执业证号',
							width : '180'
						}, {
							field : 'major',
							title : '专业',
							width : '180'
						}, {
							field : 'status',
							title : '状态',
							width : '50',
							formatter : function(value, rowData, rowIndex) {
								//function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
								//alert(rowData.username); 
								if (value == '1') {
									return '有效	';
								} else {
									return '锁定';
								}

							}
						}

				] ]

			});
	//设置分页控件 
	var p = $('#listusers').datagrid('getPager');
	$(p).pagination({
		pageSize : 20,//每页显示的记录条数，默认为10  
		pageList : [ 10, 20, 25 ],//可以设置每页记录条数的列表  
		beforePageText : '第',//页数文本框前显示的汉字  
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});
</script>
</html>
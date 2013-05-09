<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="模版管理">
<meta http-equiv="description" content="模版管理">
<title>模版管理</title>
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
<table id="listdoctemplete" cellspacing="0" cellpadding="0">
</table>
<div id="dd" >  
    修改模版名为：<input id="newname" />   
</div>  

<script type="text/javascript">
$(function(){
	$('#listdoctemplete').datagrid(
			{
				title : '文档模版列表',
				url : 'json/file_listdoctempletes',
				width : 700,
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
					text : '上传新模版',
					iconCls : 'icon-add',
					handler : function() {
						makerUpload(true,'json/file_upload','doc','listdoctemplete');
					}
				}, '-', {
					text : '修改名字',
					iconCls : 'icon-remove',
					handler : function() {
						var selnode = $('#listdoctemplete').datagrid('getSelected');
						if (selnode == null) {
							$.messager.alert('错误', '请选择一行');
						} else {
							$('#newname').val(selnode.filename);
							$('#dd').dialog({   
							    title: '修改模版名',   
							    width: 180,   
							    height: 130,   
							    closed: false,   
							    cache: false,   
							    modal: true, 
							    buttons:[{
									text:'保存',
									handler:function(){
										$.post("json/file_editname", {
											id : selnode.id,
											name : $('#newname')[0].value
										}, function(data) {
											if (data.result = 'success'){
												$('#dd').dialog('close');
												$('#listdoctemplete').datagrid('reload');
												$.messager.show({
													title:'保存成功',
													msg:'新模版名保存成功',
													timeout:5000,
													showType:'slide'
												});
												$('#newname').val('');
											}else{
												$.messager.show({
													title:'保存失败',
													msg:'新模版名保存失败',
													timeout:5000,
													showType:'slide'
												});	
											}
											
										});
										}
							    		
								},{
									text:'取消',
									handler:function(){$('#dd').dialog('close'); }
								}]
							});   

						}
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						var selnode = $('#listdoctemplete').datagrid('getSelected');
						if (selnode == null) {
							$.messager.alert('错误', '请选择一行');
						} else {
							$.post("json/file_del", {
								id : selnode.id
							}, function(data) {
								$('#listdoctemplete').datagrid('reload');
							});
						}
					}
				}],
				columns : [ [
						{
							field : 'id',
							title : '查看',
							align : 'left',
							width : 80,
							//添加超级链 
							formatter : function(value, rowData, rowIndex) {
								//function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
								//alert(rowData.username);  							
								return "<a href='system_listdoctemplete?id=" + value +"&type=doc' target='_blank'>查看</a>";
							}
						}, {
							field : 'filename',
							title : '文件名',
							width : '350',
							align : 'left'
						},  {
							field : 'datetime',
							title : '上传时间',
							width : '250',
							
						}

				] ]

			});
	//设置分页控件 
	var p = $('#listdoctemplete').datagrid('getPager');
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
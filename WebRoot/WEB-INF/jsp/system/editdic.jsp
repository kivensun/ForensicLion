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
<meta http-equiv="keywords" content="编辑字典,keyword2,keyword3">
<meta http-equiv="description" content="编辑字典">
<title>字典修改</title>
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
<script type="text/javascript">
	var nodeid = '';
	var parentid = '';
	var optype = '';
	function menuHandler(item) {
		nodeid = '';
		parentid = '';
		optype = '';
		var node = $('#tt').tree('getSelected');
		nodeid = node.id;
		var child = $('#tt').tree('getChildren', node.target);
		if (nodeid == '-1') {
			parentid = '';
		}else{
			var parentnode = $('#tt').tree('getParent', node.target);
			parentid = parentnode.id;
		}
		
		clearIput();
		switch (item.name) {
		case 'newnode':
			optype = 'newnode';
			if (nodeid == '-1') {
				$.messager.show({
					title : '出错了',
					msg : '不能添加与该节点同级节点',
					timeout : 3000,
					showType : 'slide'
				});
				return false;
			}
			$('#Title').panel('setTitle', '添加-' + node.text + '-同级节点');
			break;
		case 'newsubnode':
			optype = 'newsubnode';
			$('#Title').panel('setTitle', '添加-' + node.text + '-子节点');
			break;
		case 'editnode':
			$('#Title').panel('setTitle', '修改-' + node.text + '-节点');
			optype = 'editnode';
			$('#nodename').val(node.text);
			$.post("json/dict_listDictionary", {
				id : node.id
			}, function(data) {
				$('#nodecode').val(data.node.code);
				$('#nodecontent').val(data.node.content);
				$('#remark').val(data.node.remark);
			}, "json");
			break;
		case 'delnode':
			if (child[0] != undefined){
				$.messager.show({
					title : '出错了',
					msg : '不能删除该节点,请先删除它的子节点!',
					timeout : 3000,
					showType : 'slide'
				});
				return false;
			} 
			$.post("json/dict_deldictionary", {
				id : node.id
			}, function(data) {
				if (data.result == "success"){
					$.messager.alert('删除成功', '删除字典信息成功!', 'info', function() {
						loadTree();
						clearIput();
					});
				}else{
					$.messager.alert('出错了', data.result, 'info', function() {
					});
				}
			}, "json");
			break;
		}

	}
	function loadTree() {
		$.post("json/listdictionarys", function(data) {
			var json = new Array()
			json[0] = {
				id : "-1",
				text : "字典",
				state : "open",
				children : data
			};
			$('#tt').tree({
				data : json,
				animate : true,
				onContextMenu : function(e, node) {
					e.preventDefault();
					// select the node
					$('#tt').tree('select', node.target);
					// display context menu
					$('#mm').menu('show', {
						left : e.pageX,
						top : e.pageY
					});
				}
			});
		}, 'json');
	}
	$(function() {
		loadTree();
		$('#btncancel').click(function(){
			nodeid = '';
			parentid = '';
			optype = '';
			clearIput();
		});
		$('#btnsave').click(function() {
			var name = $("#nodename")[0].value;
			var code = $("#nodecode")[0].value;
			var content = $("#nodecontent")[0].value;
			var remark = $("#remark")[0].value;
			if (name == ''){
				$('#nodename').validatebox('isValid');
				return false;
			}				
			if (code == ''){
				$('#nodecode').validatebox('isValid');
				return false;
			}				
			if (optype == '') {
				$.messager.show({
					title : '出错了',
					msg : '请在树上选择操作后再提交',
					timeout : 3000,
					showType : 'slide'
				});
				return false;
			}
			var node = new Object();
			node.parentid = '-1';
			node.name = name;
			node.code = code;
			node.content = content;
			node.remark = remark;
			switch (optype) {
			case 'newnode':
				node.parentid = parentid;
				break;
			case 'newsubnode':
				node.parentid = nodeid;
				break;
			case 'editnode':
				node.id = nodeid;
				node.parentid = parentid;
				break;
			default:
				break;
			}
			var strnode = JSON.stringify(node);
			$.ajax({
				url : "json/dict_addorupdate",
				type : 'post',
				data : '{\"dict\":' + strnode + '}',
				success : function() {

					$.messager.alert('保存成功', '字典保存成功!', 'info', function() {
						loadTree();
						clearIput();
					});

				},
				error : function(xhr) {
					showAlertMsg('出错','添加新字典字段出错,是否重复');
				},//////
				contentType : "application/json; charset=utf-8"
			});
		});
	});
</script>
</head>

<div class="submain">
	<div class="easyui-panel" title="字典管理"
		style="width: 700px; height: 600px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true"
				style="width: 250px; padding: 10px">
				<ul id="tt"></ul>
			</div>
			<div data-options="region:'center'" style="padding: 10px">
				<div id='Title' class="easyui-panel" title="New Topic"
					style="width: 400px">
					<div style="padding: 10px 0 10px 60px">
						<table style="width: 300px">

							<tr>
								<td>节点名:</td>
								<td><input id="nodename" class="easyui-validatebox"
									data-options="required:true,missingMessage:'必须填写'"></td>
							</tr>
							<tr>
								<td>代码:</td>
								<td><input id="nodecode" class="easyui-validatebox"
									data-options="required:true,missingMessage:'必须填写'"></td>
							</tr>
							<tr>
								<td>节点内容:</td>
								<td><input id="nodecontent"></td>
							</tr>
							<tr>
								<td>备注:</td>
								<td><textarea id='remark' style="height: 300px; width: 97%"></textarea></td>
							</tr>
						</table>
						<a id="btncancel" href="javascript:void(0)"
							class="easyui-linkbutton" data-options="iconCls:'icon-undo'"
							style="margin-right: 40px;margin-top: 20px; float:right; ">取消</a>
						<a id="btnsave" href="javascript:void(0)"
							class="easyui-linkbutton" data-options="iconCls:'icon-save'"
							style=" margin-top: 20px; float: left">保存</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  右键菜单 -->
	<div id="mm" class="easyui-menu" data-options="onClick:menuHandler"
		style="width: 120px;">
		<div data-options="name:'newnode'">添加同级</div>
		<div data-options="name:'newsubnode' ">添加子级</div>
		<div class="menu-sep"></div>
		<div data-options="name:'editnode' ">编辑此节点</div>
		<div class="menu-sep"></div>
		<div data-options="name:'delnode' ">删除此节点</div>
	</div>
</div>

</html>
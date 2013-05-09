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


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案件管理</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="themes/metro/easyui.css"
	id="swicth-style">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/tabs.js"></script>
<style type="text/css">
.cs-north-logo {
	float: left;
	height: 40px;
	margin: 15px 0px 0px 5px;
	display: inline-block;
	color: #000000;
	font-size: 22px;
	font-weight: bold;
	text-decoration: none
}

.ui-skin-nav {
	float: right;
	padding: 0;
	margin-right: 10px;
	list-style: none outside none;
}

.ui-skin-nav .li-skinitem {
	float: left;
	font-size: 12px;
	margin-left: 10px;
	text-align: center;
	margin-left: 10px;
}

.ui-skin-nav .li-skinitem span {
	cursor: pointer;
	width: 10px;
	height: 10px;
	display: inline-block;
}

.ui-skin-nav .li-skinitem span.cs-skin-on {
	border: 1px solid #FFFFFF;
}

.easyui-accordion ul {
	list-style-type: none;
	margin: 0px;
	padding: 10px;
}

.easyui-accordion ul li {
	padding: 0px;
}

.easyui-accordion ul li a {
	line-height: 24px;
}

.easyui-accordion ul li div {
	margin: 2px 0px;
	padding-left: 10px;
	padding-top: 2px;
}

.easyui-accordion ul li div.hover {
	border: 1px dashed #99BBE8;
	background: #E0ECFF;
	cursor: pointer;
}

.easyui-accordion ul li div.hover a {
	color: #416AA3;
}

.easyui-accordion ul li div.selected {
	border: 1px solid #99BBE8;
	background: #E0ECFF;
	cursor: default;
}

.easyui-accordion ul li div.selected a {
	color: #416AA3;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	var _menus = {
		"menus" : [ {
			"menuid" : "1",
			"menuname" : "案件管理",
			"menus" : [ {
				"menuname" : "案件受理",
				"url" : "case_newcase"
			}, {
				"menuname" : "我的案件",
				"url" : "case_editdic"
			} , {
				"menuname" : "案件查询",
				"url" : "case_viewcase"
			} ]
		} ]
	};
</script>
</head>

<body class="easyui-layout">

	<div region="north" border="true" style="height: 70px;">
		<div style="width: 100%; height: 100%">
			<div class="cs-north-logo">jQuery EasyUI 1.3.2 Demo</div>
			<div style="float: right; padding-right: 20px;">
				<table>
					<tr>
						<td style="font-size:12px"><span >当前用户：<s:property value="%{#session.user.name}"/> <a
								href='javascript:document.parentWindow.parent.addTab("我的鉴定","p/agent/mymission.aspx?show=mission")'>
									<span id="ringdiv">审核任务：1个</span>
							</a> <a href="javascript:void(0);" id="editQD">考勤</a> <a
								href="javascript:void(0);" id="btnChangePWD">修改密码</a> <a
								href="javascript:void(0);" id="loginOut">安全退出</a>

						</span></td>
					</tr>
					<tr>
						<td>
							<ul class="ui-skin-nav">
								<li class="li-skinitem" title="default"><span
									style="background-color: blue;" rel="default"></span></li>
								<li class="li-skinitem" title="gray"><span
									style="background-color: gray;" rel="gray"></span></li>
								<li class="li-skinitem" title="bootstrap"><span
									style="background-color: #D7EBF9;" rel="bootstrap"></span></li>
								<li class="li-skinitem" title="black"><span
									style="background-color: black;" rel="black"></span></li>
								<li class="li-skinitem" title="metro"><span
									style="background-color: #ddd;" rel="metro"></span></li>
							</ul>
						</td>
					</tr>
				</table>


			</div>

		</div>
	</div>


	<div region="west" border="true" hide="true" split="true" title="导航菜单"
		style="width: 180px;">
		<div id='wnav' class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->
			
		</div>
	</div>

	<div id="mainPanle" region="center" border="true">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="Home">
				<div class="cs-home-remark">
					<h1>HOME</h1>

				</div>
			</div>
		</div>
	</div>

	<div region="south" border="false"
		style="height: 25px; padding: 0px; text-align: center;">
		@tianshaojie@gmail.com</div>

	<!--  右键菜单 -->
	<div id="mm" class="easyui-menu cs-tab-menu">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseother">关闭其他</div>
		<div id="mm-tabcloseall">关闭全部</div>
	</div>


	<!--  修改密码 -->
	<div id="pwdWindow" class="easyui-window" title="修改密码"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 500px; height: 200px; padding: 10px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding: 10px;">
				<table>
					<tr>
						<td>旧密码:</td>
						<td><input id='oldpwd' type="password" /></td>
					</tr>
					<tr>
						<td>新密码:</td>
						<td><input id='newpwd1' type="password" /></td>
					</tr>
					<tr>
						<td>重复新密码:</td>
						<td><input id='newpwd2' type="password" /></td>
					</tr>
				</table>
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)" onclick="javascript:changepwd()">Ok</a> <a
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
					href="javascript:void(0)"
					onclick="$('#pwdWindow').window('close');">Cancel</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#btnChangePWD').click(function() {
			$('#oldpwd').attr('value', '');
			$('#newpwd1').attr('value', '');
			$('#newpwd2').attr('value', '');
			$('#pwdWindow').window('open');
		});
		function changepwd() {
			var oldpwd = $('#oldpwd').attr('value');
			var newpwd1 = $('#newpwd1').attr('value');
			var newpwd2 = $('#newpwd2').attr('value');
			if (newpwd1 != newpwd2) {
				$.messager.alert('错误', '输入的两次新密码不同');
			} else {
				var json = '{\"oldpwd\":\"' + oldpwd + '\",\"newpwd\":\"'
						+ newpwd1 + '\"}';
				$
						.ajax({
							url : "json/user_changePwd",
							type : 'post',
							data : '{\"param\":' + json + '}',
							success : function(data, textStatus) {
								if (data.result == 'success') {
									$.messager
											.show('保存成功', '修改密码成功!', 'info',
													function() {
														$('#pwdWindow').window(
																'close');
													});
								} else {
									$.messager.show('出错', '修改密码出错,请确认老密码是否正确!',
											'info');
								}

							},
							error : function(xhr) {
								alert('出错。。\n' + xhr.responseText);
							},//////
							contentType : "application/json; charset=utf-8"
						});
			}
			return false;
		}
	</script>

</body>
</html>

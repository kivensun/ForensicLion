<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>编辑案件</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="编辑案件">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/addRow.js?v2"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function setPanelhref(url){
		//$('#pmain').panel('open').panel('refresh',url);
		$('#iframe').attr('src',url) ;
	}
</script>
</head>

<body>
	<div id="cc" class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height:50px;">
			<div style="padding:5px;border:1px solid #ddd;">
				<a id="btn-edit" href="javascript:void(0)"
					class="easyui-splitbutton"
					data-options="menu:'#mmedit',iconCls:'icon-save'">案件</a> <a
					href="javascript:void(0)" class="easyui-splitbutton"
					data-options="menu:'#mmbook',iconCls:'icon-save'">文书</a> <a
					href="javascript:void(0)" class="easyui-menubutton"
					data-options="menu:'#mmpic',iconCls:'icon-save'">图片</a> <a
					href="javascript:void(0)" class="easyui-menubutton"
					data-options="menu:'#mmliuzhan',iconCls:'icon-save'">鉴定流程</a> <a
					href="javascript:void(0)" class="easyui-menubutton"
					data-options="menu:'#mmyichang',iconCls:'icon-save'">异常流程</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-search'" > 三期鉴定</a>

			</div>
			<div id="mmedit" style="width:150px;">
				<div id="editcase" data-options="iconCls:'icon-edit'" onclick="setPanelhref('newcase');">修改</div>
				<div id="viewcase" data-options="iconCls:'icon-save'"onclick="setPanelhref('newcase');">查看</div>
				<div class="menu-sep"></div>
				<div id="admin" data-options="iconCls:'icon-edit'" onclick="setPanelhref('newcase');">最高权限</div>
			</div>
			<div id="mmbook" style="width:100px;">
				<div id="weituoshu data-options="iconCls:'icon-tip'" onclick="setPanelhref('newcase');">委托书</div>
				<div id="xieyishu data-options="iconCls:'icon-tip'" onclick="setPanelhref('newcase');">协议书</div>
				<div class="menu-sep"></div>
				<div id="writebook" data-options="iconCls:'icon-edit'" onclick="setPanelhref('newcase');">文书撰写</div>
				<div id="bookview" data-options="iconCls:'icon-search'" onclick="setPanelhref('newcase');">文书查询</div>
			</div>
			<div id="mmpic" style="width:150px;">
				<div id="uploadpic" data-options="iconCls:'icon-add'" onclick="makerUpload(true,'json/file_upload','img','');">图片上传</div>
				<div id="viewpic" data-options="iconCls:'icon-print'" onclick="setPanelhref('viewcasepic');">图片查看</div>
				<div id="paibanpic"data-options="iconCls:'icon-edit'"onclick="setPanelhref('newcase');">图片排版</div>
			</div>
			<div id="mmliuzhan" style="width:150px;">
				<div id="liuzhuan" data-options="iconCls:'icon-redo'" onclick="setPanelhref('newcase');">鉴定流转</div>
				<div id="note" data-options="iconCls:'icon-edit'"onclick="setPanelhref('newcase');">鉴定记事</div>
				<div class="menu-sep"></div>
				<div id="tijaoqianfa" data-options="iconCls:'icon-add'" onclick="setPanelhref('newcase');">提交签发</div>
				<div id="tijiaozhizuo" data-options="iconCls:'icon-add'" onclick="setPanelhref('newcase');">提交制作</div>
				<div class="menu-sep"></div>
				<div id="history" data-options="iconCls:'icon-back'" onclick="setPanelhref('newcase');">历史记录</div>
				<div class="menu-sep"></div>
				<div id="tijiaojiean"data-options="iconCls:'icon-add'" onclick="setPanelhref('newcase');">提交结案</div>
				<div class="menu-sep"></div>
				<div id="tijiaoguina" data-options="iconCls:'icon-add'" onclick="setPanelhref('newcase');">提交归纳</div>
			</div>
			<div id="mmyichang" style="width:150px;">
				<div id="tuijianshengqin" data-options="iconCls:'icon-undo'" onclick="setPanelhref('newcase');">退鉴申请</div>
				<div class="menu-sep"></div>
				<div id="shengqinunlock" data-options="iconCls:'icon-remove'" onclick="setPanelhref('newcase');">申请解锁</div>
			</div>
		</div>
		<div data-options="region:'center'" border="false">
			<div id="pmain" class="easyui-panel" fit="true">
			<iframe id="iframe" style="height: 100%;width:100%" scrolling="auto" frameborder="0"></iframe>
			</div>

		</div>
	</div>
</body>
</html>

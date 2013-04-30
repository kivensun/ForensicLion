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

<title>查看模板</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="查看模板">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/main.js?ver=0.3"></script>
<script LANGUAGE=javascript FOR=WebOffice1 EVENT=NotifyCtrlReady>
	/****************************************************
	 *
	 *	在装载完Weboffice(执行<object>...</object>)
	 *	控件后执行 "WebOffice1_NotifyCtrlReady"方法
	 *
	 ****************************************************/
	WebOffice1_NotifyCtrlReady();
</script>
<script LANGUAGE=javascript FOR=WebOffice1
	EVENT=NotifyWordEvent(eventname)>
<!--
	WebOffice1_NotifyWordEvent(eventname);
//-->
</script>
<script LANGUAGE=javascript>
	/****************************************************
	 *
	 *		控件初始化WebOffice方法
	 *
	 ****************************************************/
	var id = $.getUrlParam('id');
	var type = $.getUrlParam('type');
	var username = '<s:property value="%{#session.user.name}"/>';
	function WebOffice1_NotifyCtrlReady() {
		document.all.WebOffice1.OptionFlag |= 128;
		document.all.WebOffice1.LoadOriginalFile("/download_file?id=" + id,
				type);
	    setsomething();
	}
	function setsomething() {
		bToolBar_HideNew();
		bToolBar_HideOpen();
		bToolBar_HideSave();
		hideAll('','','','');
		EnableClose(0);

	}
	var flag = false;
	function menuOnClick(id) {
		var id = document.getElementById(id);
		var dis = id.style.display;
		if (dis != "none") {
			id.style.display = "none";

		} else {
			id.style.display = "block";
		}
	}
	/****************************************************
	 *
	 *		接收office事件处理方法
	 *
	 ****************************************************/
	var vNoCopy = 0;
	var vNoPrint = 0;
	var vNoSave = 0;
	var vClose = 0;
	function no_copy() {
		vNoCopy = 1;
	}
	function yes_copy() {
		vNoCopy = 0;
	}
	function no_print() {
		vNoPrint = 1;
	}
	function yes_print() {
		vNoPrint = 0;
	}
	function no_save() {
		vNoSave = 1;
	}
	function yes_save() {
		vNoSave = 0;
	}
	function EnableClose(flag) {
		vClose = flag;
	}
	function CloseWord() {
		document.all.WebOffice1.CloseDoc(0);
	}

	function WebOffice1_NotifyWordEvent(eventname) {
		if (eventname == "DocumentBeforeSave") {
			if (vNoSave) {
				document.all.WebOffice1.lContinue = 0;
				alert("此文档已经禁止保存");
			} else {
				document.all.WebOffice1.lContinue = 1;
			}
		} else if (eventname == "DocumentBeforePrint") {
			if (vNoPrint) {
				document.all.WebOffice1.lContinue = 0;
				alert("此文档已经禁止打印");
			} else {
				document.all.WebOffice1.lContinue = 1;
			}
		} else if (eventname == "WindowSelectionChange") {
			if (vNoCopy) {
				document.all.WebOffice1.lContinue = 0;
				//alert("此文档已经禁止复制");
			} else {
				document.all.WebOffice1.lContinue = 1;
			}
		} else if (eventname == "DocumentBeforeClose") {
			if (vClose == 0) {
				document.all.WebOffice1.lContinue = 0;
			} else {
				alert("word");
				document.all.WebOffice1.lContinue = 1;
			}
		}
	}
</script>
</head>

<body>
	<!-- -----------------------------== 装载weboffice控件 ==--------------------------------- -->
	<object id=WebOffice1 height=768 width='100%' height='100%'
		style='LEFT: 0px; TOP: 0px'
		classid='clsid:E77E049B-23FC-4DB8-B756-60529A35FAD5'
		codebase='js/weboffice_v6.0.5.0.cab#Version=6,0,5,0'>
		<param name='_ExtentX' value='6350'>
		<param name='_ExtentY' value='6350'>
	</object>
</body>
</html>

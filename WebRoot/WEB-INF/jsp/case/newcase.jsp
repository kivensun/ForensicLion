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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案件受理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="案件受理,keyword2,keyword3">
<meta http-equiv="description" content="案件受理">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">

<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/addRow.js?v2"></script>

<style type="text/css">
body {
	font: 12px, "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}

fieldset {
	margin: 12px;
	border: solid 1px #999;
	width: 900px;
}

.fieldConten {
	margin: 4px;
	overflow: auto;
	padding: 0px;
}

.table1 tr {
	height: 28px;
}

.table1 tr th {
	background-color: #C0C0C0;
	width: 80px;
	text-align: center;
	font-weight: bold;
	line-height: 150%;
	font-family: "Tahoma", "宋体";
	font-size: 9pt;
	color: #003399;
	border-bottom: #93bee2 1px solid;
	border-left: #93bee2 1px solid;
	border-right: #93bee2 1px solid;
	border-top: #93bee2 1px solid;
	background-color: #e8f4ff;
	font-style: normal;
	height: 18px;
	margin-top: 5px;
	margin-bottom: 5px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.table1 tr td .txt {
	border-style: none none solid none;
	border-bottom-width: 1px;
	border-bottom-color: #000000;
	width: 100%;
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 10pt;
}

.table2 {
	text-align: left;
	width: 100%;
	margin-top: 10px;
}

.table2 tr {
	height: 28px;
}

.table2 tr th {
	background-color: #C0C0C0;
	text-align: center;
	font-weight: bold;
	line-height: 150%;
	font-family: "Tahoma", "宋体";
	font-size: 9pt;
	color: #003399;
	border-bottom: #93bee2 1px solid;
	border-left: #93bee2 1px solid;
	border-right: #93bee2 1px solid;
	border-top: #93bee2 1px solid;
	background-color: #e8f4ff;
	font-style: normal;
	height: 20px;
	font-size: 9pt;
}

.table2 tr td {
	text-align: center;
	font-size: 9pt;
}

.table2 input {
	border-style: none none solid none;
	border-bottom-width: 1px;
	border-bottom-color: #000000;
	width: 96%;
	font-size: 9pt;
}
</style>
<script type="text/javascript">
	function filldata() {
 		fillcombobox('identifyMajor', '鉴定专业');
 		fillcombobox('reportGetway', '文书领取');
 		fillcombobox('entrusterRelation', '与本案关系');
 		fillcombobox('insuranceUnit', '保险单位');
		fillcombobox('payee', '收款人');
	 	fillcombobox('identifyAssistant', '鉴定助理');
		fillcombobox('appraiser1', '鉴定人一');
		fillcombobox('appraiser2', '鉴定专业');
		fillcombobox('signer', '签发人');
		fillcombobox('sources', '来源渠道');
		fillcombobox('operationMaintain', '业务维护');
		fillcombobox('vip', 'VIP客户');
		fillcombobox('operationsOwner', '业务归口'); 
	}
	$(function() {
		filldata();
		$('#ff').form({
			url : 'json/case_newcase',
			onSubmit : function() {
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close');
				}
				return isValid;
			},
			success : function(data) {
				var json = jQuery.parseJSON(data);
				if(json.result == 'SUCCESS'){
					$.messager.show({
						title:'提示',
						msg:'新案件保存成功',
						timeout:5000,
						showType:'slide'
					});
					$('#btnsave').linkbutton('disable');
				}
				$.messager.progress('close');
			}
		});
		$('#btnsave').bind('click', function() {
			$.messager.progress();
			$('#ff').submit();  
		});
	});
</script>
</head>

<body>

	<div id="p" class="easyui-panel" title="案件受理"
		style="width:95%;height:100%;padding:10px;background:#fafafa;"
		data-options="fit:true,border:false">
		<div style="margin-left:20px; margin-top:20px; ">
			<div style="padding:10px;border:1px solid #ddd;">
				<a href="javascript:void(0)" class="easyui-linkbutton" id="btnsave"
					data-options="plain:true,iconCls:'icon-save'">
					&nbsp;保&nbsp;&nbsp;存</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-cancel'">&nbsp;取&nbsp;消&nbsp;</a>

			</div>
		</div>
		<div style="margin-left:20px; margin-top:20px; text-align: left;">
			<form id="ff" method="post">
				<fieldset>
					<legend>委托事项</legend>
					<div class="fieldConten">
						<table class="table1" border="1">
							<tr>
								<th>鉴定专业</th>
								<td colspan="5"><select id="identifyMajor"
									class="easyui-combobox" style="width: 582px;"
									name="caseinfor.identifyMajor" required="required">
								</select>
								</td>
								<th>委托日期</th>
								<td style="width: 135px;"><input id="entrustDate"
									class="easyui-datebox" name="caseinfor.entrustDate"
									required="required"></input></td>
							</tr>
							<tr>
								<th>鉴定要求</th>
								<td colspan="3"><input id="identifyRequest"
									class="easyui-validatebox" name="caseinfor.identifyRequest"
									data-options="required:true,validType:'length[1,10]'"
									style="width:95%" />
								</td>
								<th>联系地址</th>
								<td style="width: 135px"><input id="entrusterAddress"
									name="caseinfor.entrusterAddress" class="easyui-validatebox"
									data-options="required:true,validType:'length[1,10]'" /></td>
								<th>文书领取</th>
								<td style="width: 135px"><select id="reportGetway"
									name="caseinfor.reportGetway" class="easyui-combobox"
									style="width:135px">

								</select></td>
							</tr>
							<tr>
								<th>收件人</th>
								<td style="width: 135px;"><input id="receiverName"
									class="easyui-validatebox" name="caseinfor.receiverName"
									data-options="alidType:'length[1,10]'" /></td>
								<th>邮寄地址</th>
								<td style="width: 135px;"><input id="receiverAddress"
									class="easyui-validatebox" name="caseinfor.receiverAddress"
									data-options="validType:'length[1,50]'" /></td>
								<th>邮寄邮编</th>
								<td style="width: 135px;"><input id="vv" id="receiverCode"
									class="easyui-validatebox" name="caseinfor.receiverCode"
									data-options="validType:'length[1,10]'" /></td>
								<th>电子邮箱</th>
								<td><input id="receiverEmail" class="easyui-validatebox"
									name="caseinfor.receiverEmail"
									data-options="validType:['email','length[1,50]']" /></td>
							</tr>
							</tbody>
						</table>
					</div>
				</fieldset>
				<fieldset>
					<legend>当事双方信息</legend>
					<div class="fieldConten">
						<table class="table1" border="1">
							<tbody>
								<tr>
									<th>委托方</th>
									<td colspan="3"><input id="entruster"
										class="easyui-validatebox" name="caseinfor.entruster"
										data-options="required:true,validType:'length[1,50]'"
										style="width:90%" /></td>
									<th>与本案关系</th>
									<td><select id="entrusterRelation"
										name="caseinfor.entrusterRelation" class="easyui-combobox"
										style="width:135px">

									</select></td>
									<th>委托宗号</th>
									<td><input id="entrusterNum" class="easyui-validatebox"
										name="caseinfor.entrusterNum"
										data-options="validType:'length[1,20]'" /></td>
								</tr>
								<tr>
									<th>联&nbsp;系&nbsp;人</th>
									<td><input id="linkman" class="easyui-validatebox"
										name="caseinfor.linkman"
										data-options="required:true,validType:'length[1,20]'" /></td>
									<th>联系电话</th>
									<td><input class="easyui-validatebox" id="linkmanTel"
										name="caseinfor.linkmanTel"
										data-options="validType:'length[1,30]'" /></td>
									<th>传真号码</th>
									<td style="width: 135px"><input id="linkmanFax"
										name="caseinfor.linkmanFax" class="easyui-validatebox"
										data-options="validType:'length[1,30]'" /></td>
									<th>送&nbsp;检&nbsp;人</th>
									<td><input id="identifySender" class="easyui-validatebox"
										name="caseinfor.identifySender"
										data-options="validType:'length[1,10]'" /></td>
								</tr>
								<tr>
									<th>保险单位</th>
									<td><select id="insuranceUnit"
										name="caseinfor.insuranceUnit" class="easyui-combobox"
										style="width:135px">

									</select></td>
									<th>联系人</th>
									<td><input id="insuranceLinkman"
										class="easyui-validatebox" name="caseinfor.insuranceLinkman"
										data-options="validType:'length[1,30]'" /></td>
									<th>联系电话</th>
									<td><input id="insuranceTel" class="easyui-validatebox"
										name="caseinforinsuranceTel"
										data-options="validType:'length[1,30]'" /></td>
									<th>电子邮件</th>
									<td><input id="insuranceEmail" class="easyui-validatebox"
										name="caseinfor.insuranceEmail"
										data-options="validType:['email','length[1,50]']" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>
				<fieldset>
					<legend>案情信息</legend>
					<div class="fieldConten">
						<table class="table1" border="1">
							<tbody>
								<tr>
									<th>案发日期</th>
									<td style="width: 134px;"><input id="caseDate"
										class="easyui-datebox" name="caseinfor.caseDate"
						
										required="required" /></td>

									<th>案件类别</th>
									<td style="width: 134px;"><input id="caseClass"
										name="caseinfor.caseClass" class="easyui-validatebox"
										data-options="required:true,validType:'length[1,10]'" /></td>

									<th>鉴定次数</th>
									<td style="width: 134px;"><input id="caseIdentifyTimes"
										name="caseinfor.caseIdentifyTimes" class="easyui-numberbox"
										value="0" data-options="min:0" /></td>

									<th>案件阶段</th>
									<td style="width: 134px;"><select id="caseProgress"
										name="caseinfor.caseProgress" class="easyui-combobox"
										style="width:134px" required="required">

									</select></td>

								</tr>
								<tr>
									<th>简案摘要</th>
									<td colspan="7"><textarea name="caseinfor.caseRemark"
											rows="2" cols="20" id="caseRemark" title="不能超过800个字！"
											style="width: 99%;height: 95px"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>
		
				<fieldset>
					<legend>鉴定收费</legend>
					<div class="fieldConten">
						<div style=" text-align: right; margin-right: 20px;">
							<input type="button" value="增加行" onclick="addCasechargesRows();" />
							<input type="button" value="删除最后行"
								onclick="delRow('casecharges')" />
						</div>
						<table id="casecharges" class="table2" cellspacing="1" border="1">
							<tbody>
								<tr>
									<th style="width: 40px;">编号</th>
									<th style="width: 200px;">收费项目</th>
									<th style="width: 100px;">标准类型</th>
									<th style="width: 100px;">收费金额</th>
									<th>备注</th>
								</tr>
							</tbody>
						</table>
					</div>
				</fieldset>
			<fieldset>
				<legend>被鉴定人信息</legend>
				<div class="fieldConten">
					<div style="text-align: right; margin-right: 20px;">
						<input class="ButtonCss" id="Button4" type="button" value="增加行"
							onclick="addCaseIdentifiedInfoRows();" /> <input
							class="ButtonCss" id="Button7" type="button" value="删除最后行"
							onclick="delRow('caseidentifiedinfos')" />
					</div>
					<table id="caseidentifiedinfos" class="table2" cellspacing="1"
						border="1">
						<tbody>
							<tr>
								<th style="width: 40px;">编号</th>
								<th style="width: 100px;">姓名</th>
								<th style="width: 60px;">性别</th>
								<th style="width: 150px;">证件号码</th>
								<th style="width: 80px;">文化程度</th>
								<th style="width: 100px;">民族</th>
								<th style="width: 200px;">地址</th>
								<th>备注</th>
							</tr>						
						</tbody>
					</table>
				</div>
			</fieldset>
			<fieldset>
				<legend>鉴定检材信息</legend>
				<div class="fieldConten">
					<div style=" text-align: right; margin-right: 20px;">
						<input class="ButtonCss" type="button" value="增加行"
							onclick="addCaseCheckinforsRows()" /> <input class="ButtonCss"
							type="button" value="删除最后行" onclick="delRow('casecheckinfors')" />
					</div>
					<table id="casecheckinfors" class="table2" cellspacing="1" border="1">
						<tbody>
							<tr>
								<th style="width: 40px;">编号</th>
								<th style="width: 200px;">名称</th>
								<th style="width: 150px;">检材类别</th>
								<th style="width: 40px;">数量</th>
								<th style="width: 60px;">单位</th>
								<th style="width: 100px;">提取日期</th>
								<th style="width: 40px;">条形码</th>
								<th>备注</th>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			<fieldset>
				<legend>内部统计</legend>
				<div class="fieldConten">
					<input name="" type="text" value="案件受理" id="" class="txt"
						style="display: none;">
					<table class="table1" border="1">
						<tbody>
							<tr>
								<th>收款人</th>
								<td><select id="payee" class="easyui-combobox"
									name="caseinternalstatistics.payee" style="width:136px">

								</select></td>
								<th>鉴定助理</th>
								<td><select id="identifyAssistant" class="easyui-combobox"
									name="caseinternalstatistics.identifyAssistant"
									style="width:136px">

								</select></td>
								<th>鉴定人一</th>
								<td><select id="appraiser1" class="easyui-combobox"
									name="caseinternalstatistics.appraiser1" style="width:136px"
									required="required">

								</select></td>
								<th>鉴定人二</th>
								<td><select id="appraiser2" class="easyui-combobox"
									name="caseinternalstatistics.appraiser2" style="width:136px">

								</select></td>
							</tr>
							<tr>
								<th>签发人</th>
								<td><select id="signer" class="easyui-combobox"
									name="caseinternalstatistics.signer" style="width:136px"
									required="required">

								</select></td>
							</tr>
							<tr>
								<th>来源渠道</th>
								<td><select id="sources" class="easyui-combobox"
									name="caseinternalstatistics.sources" style="width:136px"
									required="required">

								</select></td>
								<th>业务维护</th>
								<td><select id="operationMaintain" class="easyui-combobox"
									name="caseinternalstatistics.operationMaintain"
									style="width:136px">

								</select></td>
								<th>VIP客户</th>
								<td><select id="vip" class="easyui-combobox"
									name="caseinternalstatistics.vip" style="width:136px">

								</select></td>
								<th>业务归口</th>
								<td><select id="operationsOwner" class="easyui-combobox"
									name="caseinternalstatistics.operationsOwner"
									style="width:136px" required="required">

								</select></td>
							</tr>
							<tr>
								<th>备注</th>
								<td colspan="7"><textarea name="" rows="2" cols="20"
										id="remark" name="caseinternalstatistics.remark"
										title="不超过200个字" style="width:100%;height:95px"></textarea></td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		 </form> 
		</div>
	</div>
	<script type="text/javascript">
		function myformatter(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
					+ (d < 10 ? ('0' + d) : d);
		}
		function myparser(s) {
			if (!s)
				return new Date();
			var ss = s.split('-');
			var y = parseInt(ss[0], 10);
			var m = parseInt(ss[1], 10);
			var d = parseInt(ss[2], 10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
				return new Date(y, m - 1, d);
			} else {
				return new Date();
			}
		}
	</script>

</body>
</html>

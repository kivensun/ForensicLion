//table中添加与第一行相同的行
function addRow(tableID) {
	var num = $("#" + tableID + " tr").length;
	var row = $("#" + tableID + "  tr").eq(1).clone();
	$.each(row.find("td"), function(i) {
		if (i == 0) {
			$(this).html(num);
		}
		$(this).find("input").val("");
		var id = $(this).find("input").attr("id");
		var index = num -1;
		$(this).find("input").attr("name",tableID +'['+ index +'].'+ id);
	});
	$("#" + tableID).append(row);
	$.parser.parse();
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//table删除最后一行
function delRow(tableID) {
	var num = $("#" + tableID + " tr").length;
	if (num < 2)
		return false;
	$("#" + tableID + ">tbody>tr:last").remove();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function  addCaseIdentifiedInfoRows(){
	var num = $("#caseidentifiedinfos tr").length;
	var index = num -1;
	var row = '<tr style="text-align: center;" id="rowmember">' +
					'<td id="rownum" style="text-align: center;">'+ num +'</td> ' +
					'<td><input id="name" class="easyui-validatebox"  name="caseidentifiedinfos['+ index+'].name"  data-options="required:true,validType:\'length[0,50]\'" /></td>' +
					'<td><input id="sex" class="easyui-validatebox" 	name="caseidentifiedinfos['+ index+'].sex" 	data-options="required:true,validType:\'length[0,5]\'" /></td>' +
					'<td><input id="idcard" " class="easyui-validatebox"	name="caseidentifiedinfos['+ index+'].idcard" data-options="validType:\'length[0,18]\'" /></td>'+
					'<td><input id="educatio" class="easyui-validatebox" name="caseidentifiedinfos['+ index+'].education"	data-options="validType:\'length[0,5]\'" /></td>'+
					'<td><input id="nation" class="easyui-validatebox" 	name="caseidentifiedinfos['+ index+'].nation"	data-options="validType:\'length[0,10]\'" /></td>'+
					'<td><input id="address" class="easyui-validatebox" 	name="caseidentifiedinfos['+ index+'].address"	data-options="validType:\'length[0,50]\'" /></td>'+
					'<td><input id="remark" class="easyui-validatebox"	name="caseidentifiedinfos['+ index+'].remark"	data-options="validType:\'length[0,50]\'" /></td>'+
					'</tr>';
				
	$("#caseidentifiedinfos").append(row);	
	$.parser.parse();
}

function addCasechargesRows(){
	var num = $("#casecharges tr").length;
	var index = num -1;
	var row = '<tr style="text-align: center;" id="caseinfor">' +
					'<td id="rownum" style="text-align: center;">'+num+'</td>'+
					'<td><input id="chargeClass" class="easyui-validatebox" 	name="casecharges['+index +'].chargeClass" 	data-options="required:true,validType:\'length[0,30]\'" /></td>' +
					'<td><input id="chargeStandardType" 	class="easyui-validatebox"	name="casecharges['+index +'].chargeStandardType"	data-options="required:true,validType:\'length[0,10]\'" /></td>' +
					'<td><input id="chargeAmount" class="easyui-validatebox"	name="casecharges['+index +'].chargeAmount" value="0" required="required" /></td>' +
					'<td><input id="chargeRemark" class="easyui-validatebox" name="casecharges['+index +'].chargeRemark"  data-options="validType:\'length[0,50]\'" /></td>' +
					'</tr>';
	$("#casecharges").append(row);	
	$.parser.parse();
}

function addCaseCheckinforsRows(){
	var num = $("#casecheckinfors tr").length;
	var index = num -1;
	var row = '<tr style="text-align: center;" id="rowTestThing">' +
					'<td id="rownum" style="text-align: center;">'+num+'</td>'+
					'<td><input id="checkName" class="easyui-validatebox"	name="casecheckinfors['+index+'].checkName"	data-options="required:true,validType:\'length[0,20]\'" /></td>'+
					'<td><input id="checkClass" class="easyui-validatebox"	name="casecheckinfors['+index+'].checkClass"		data-options="required:true,validType:\'length[0,40]\'" /></td>'+
					'<td><input id="num" class="easyui-numberbox"	name="casecheckinfors['+index+'].num" value="0" data-options="min:0" /></td>'+
					'<td><input id="unit" class="easyui-validatebox"	name="casecheckinfors['+index+'].unit"	data-options="required:true,validType:\'length[0,5]\'" /></td>'+
					'<td><input id="getDate" class="easyui-datebox" required="required" name="casecheckinfors['+index+'].getDate" /></td>'+
					'<td><input id="barcode" class="easyui-validatebox" 	name="casecheckinfors['+index+'].barcode" 	data-options="validType:\'length[0,15]\'" /></td>'+
					'<td><input id="remark" class="easyui-validatebox"	name="casecheckinfors['+index+'].remark"	data-options="validType:\'length[0,50]\'" /></td>'+
					'</tr>';
	$("#casecheckinfors").append(row);	
	$.parser.parse();
}


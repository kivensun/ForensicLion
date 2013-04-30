//table中添加与第一行相同的行
function addRow(tableID) {
	var num = $("#" + tableID + " tr").length;
	var row = $("#" + tableID + "  tr").eq(1).clone();
	row.removeAttr("id");
	$.each(row.find("td"), function(i) {
		if (i == 0) {
			$(this).html(num);
		}
		$(this).find("input").val("");
	});
	$("#" + tableID).append(row);
	$.parser.parse();
}
function addtblTestThingRow(){
	var num = $("#tblTestThing tr").length;
	var row = $("#tblTestThing  tr").eq(1).clone();
	row.removeAttr("id");
	$.each(row.find("td"), function(i) {
		if (i == 0) {
			$(this).html(num);
		}
		$(this).find("input").val("");
	});
	$("#tblTestThing").append(row);
	$("#tblTestThing>tbody>tr:last").find("td").eq(-3).empty();
	$("#tblTestThing>tbody>tr:last").find("td").eq(-3).append('<input id="getDate" class="easyui-datebox" required="required" 	name="CaseCheckInfor.getDate"/>');
	$.parser.parse();
}
//table删除最后一行
function delRow(tableID) {
	var num = $("#" + tableID + " tr").length;
	if (num < 3)
		return false;
	$("#" + tableID + ">tbody>tr:last").remove();
}
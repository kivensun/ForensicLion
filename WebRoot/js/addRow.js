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
}
//table删除最后一行
function delRow(tableID) {
	var num = $("#" + tableID + " tr").length;
	if (num < 3)
		return false;
	$("#" + tableID + ">tbody>tr:last").remove();
}
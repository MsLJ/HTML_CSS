function goBBSDetail(no) {
	location.href = "BBSDetailController?no=" + no;

}
function deleteBBSMsg(no) {
	var really = confirm("���� �Ͻðڽ��ϱ�?");
	if (really) {
		location.href = "BBSDeleteController?no=" + no;

	}

}

function goDataDetail(no){
	location.href = "DatadetailController?no=" + no;
}
function deleteData(no){
	if(confirm("����?")){
		location.href="DatadeleteController?no=" + no;
	}
}
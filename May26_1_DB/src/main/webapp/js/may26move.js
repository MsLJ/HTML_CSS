function goBBSDetail(no) {
	location.href = "BBSDetailController?no=" + no;

}
function deleteBBSMsg(no) {
	var really = confirm("삭제 하시겠습니까?");
	if (really) {
		location.href = "BBSDeleteController?no=" + no;

	}

}

function goDataDetail(no){
	location.href = "DatadetailController?no=" + no;
}
function deleteData(no){
	if(confirm("삭제?")){
		location.href="DatadeleteController?no=" + no;
	}
}
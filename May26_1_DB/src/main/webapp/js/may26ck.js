function writecheck() {

	var titleFiled = document.writef.writeT;
	var txtFiled = document.writef.writeTX;

	if (checkEmpty(titleFiled) || checkEmpty(txtFiled)) {
		alert("����� ������ �� �� �ۼ����ּ���")
		titleFiled.value = "";
		txtFiled.value = "";
		titleFiled.focus();



		return false;




	}
	return true;


}
function modifyCheck() {
	var titleFiled = document.modifyf.modifyT;
	var txtFiled = document.modifyf.modifyTX
	if (checkEmpty(titleFiled) || checkEmpty(txtFiled)) {
		alert("������ ������ �Է����ּ���.")
		txtFiled.value="";
		titleFiled.value="";
		return false;
	}
	return true;
}
function uploadCheck() {
	var titleFiled = document.uploadf.title;
	var fileFiled = document.uploadf.file
	if (checkEmpty(titleFiled) || checkEmpty(fileFiled)) {
		alert("������ ������ �Է����ּ���.")
		titleFiled.value="";
		return false;
	}
	return true;
}
function writecheck() {

	var titleFiled = document.writef.writeT;
	var txtFiled = document.writef.writeTX;

	if (checkEmpty(titleFiled) || checkEmpty(txtFiled)) {
		alert("내용과 제목을 둘 다 작성해주세요")
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
		alert("수정할 내용을 입력해주세요.")
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
		alert("수정할 내용을 입력해주세요.")
		titleFiled.value="";
		return false;
	}
	return true;
}
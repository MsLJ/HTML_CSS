function loginCheck() {
	var idFiled = document.loginf.id;
	var pwFiled = document.loginf.pw;
	if (checkEmpty(idFiled) || checkEmpty(pwFiled)) {
		alert("��ĭ?");
		return false;
	}
	return true;
}
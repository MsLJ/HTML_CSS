function updateMCheck() {
	var pwField = document.memberupdateF.pw;
	var pwckField = document.memberupdateF.pwck;
	var nameFiled = document.memberupdateF.name;
	var ageFiled = document.memberupdateF.age;
	var addr1Filed = document.memberupdateF.addr1;
	var addr2Filed = document.memberupdateF.addr2;
	var addr3Filed = document.memberupdateF.addr3;
	var imgFiled = document.memberupdateF.img;

	if (checkEmpty(pwField) || checkEmpty(pwckField) || shortThan(pwField, 4) || notContain(pwField, "1234567890")) {
		alert("�н�����?");
		pwField.value = "";
		pwckField.value = "";
		pwField.focus();
		return false;

	}
	if (pwField.value != pwckField.value) {
		alert("��й�ȣ�� ��ġ��������");
		pwckField.value = "";
		return false;
	}
	if (checkEmpty(nameFiled)) {
		alert("�̸�?");
		nameFiled.focus();
		return false;
	}

	if (checkEmpty(ageFiled) || isNotNum(ageFiled)) {
		alert("����?");
		ageFiled.value("");
		ageFiled.focus();
		return false;
	}
	if (checkEmpty(addr1Filed) || checkEmpty(addr2Filed) || checkEmpty(addr3Filed) || isNotNum(addr1Filed) || shortThan(addr1Filed, 5)) {
		alert("�ּ�?");
		addr1Filed.value("");
		addr2Filed.value("");
		addr3Filed.value("");
		addr1Filed.focus();
		return false;
	}

	if (checkEmpty(imgFiled)) {
		return true;
	}
	if(isNotType(imgFiled, "png") && isNotType(imgFiled, "jpg") && isNotType(imgFiled, "gif")){
		alert("������ �־��ּ���");
		return false;
	}

	return true;
}




function joinCheck() {
	var idField = document.joinF.id;
	var pwField = document.joinF.pw;
	var pwckField = document.joinF.pwck;
	var nameFiled = document.joinF.name;
	var ageFiled = document.joinF.age;
	var addr1Filed = document.joinF.addr1;
	var addr2Filed = document.joinF.addr2;
	var addr3Filed = document.joinF.addr3;
	var imgFiled = document.joinF.img;



	if (checkEmpty(idField)) {
		alert("���̵�?");
		idField.focus();
		return false;
	}
	if (checkEmpty(pwField) || checkEmpty(pwckField) || shortThan(pwField, 4) || notContain(pwField, "1234567890")) {
		alert("�н�����?");
		pwField.value = "";
		pwckField.value = "";
		pwField.focus();
		return false;

	}
	if (pwField.value != pwckField.value) {
		alert("��й�ȣ�� ��ġ��������");
		pwckField.value = "";
		return false;
	}
	if (checkEmpty(nameFiled)) {
		alert("�̸�?");
		nameFiled.focus();
		return false;
	}

	if (checkEmpty(ageFiled) || isNotNum(ageFiled)) {
		alert("����?")
		ageFiled.value("");
		ageFiled.focus();
		return false;
	}
	if (checkEmpty(addr1Filed) || checkEmpty(addr2Filed) || checkEmpty(addr3Filed) || isNotNum(addr1Filed) || shortThan(addr1Filed, 5)) {
		alert("�ּ�?");
		addr1Filed.value("");
		addr2Filed.value("");
		addr3Filed.value("");
		addr1Filed.focus();
		return false;
	}

	if (checkEmpty(imgFiled) || isNotType(imgFiled, "png") && isNotType(imgFiled, "jpg") && isNotType(imgFiled, "gif")) {
		alert("�̹���?");
		return false;
	}

	return true;
}
function loginCheck() {
	var idFiled = document.loginF.id;
	var pwFiled = document.loginF.pw;
	if (checkEmpty(idFiled) || checkEmpty(pwFiled)) {
		alert("���̵�� ��й�ȣ�� �Է��ϼ���")
		return false;
	}
	return true;
}
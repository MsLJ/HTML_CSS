function check(){
	var valueInput=document.f.value;
	if(checkEmpty(valueInput)||isNotNum(valueInput)){
		alert("�Է°��� �Է� ���ڸ�");
		valueInput.value="";
		valueInput.focus();
		return false;
	}
	return true;

		
	
}
function check(){
	var inputx=document.f.x;
	var inputy=document.f.y;
	
	if(checkEmpty(inputx)||isNotNum(inputx)){
		alert("x�� ����");
		inputx.focus();
		return false;
	}
	if(checkEmpty(inputy)||isNotNum(inputy)){
		alert("y�� ����");
		inputy.focus();
		return false;
	}
	return true;
	
	
}
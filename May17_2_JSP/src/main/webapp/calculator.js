function check(){
	var inputx=document.f.x;
	var inputy=document.f.y;
	
	if(checkEmpty(inputx)||isNotNum(inputx)){
		alert("x가 없음");
		inputx.focus();
		return false;
	}
	if(checkEmpty(inputy)||isNotNum(inputy)){
		alert("y가 없음");
		inputy.focus();
		return false;
	}
	return true;
	
	
}
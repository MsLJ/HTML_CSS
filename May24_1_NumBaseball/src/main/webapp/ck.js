function check(){
	var numField=document.f.n;
	//�迭�� �׳� ���°� ���� javascript���� ������ ���ξ��⿡
	if(checkEmpty(numField)||isNotNum(numField)||shortThan(numField,3)||numField.value.indexOf("-")!=-1||numField.value.indexOf(".")!=-1||
	numField.value[0]==numField.value[1]||numField.value[1]==numField.value[2]||numField.value[2]==numField.value[0] ){
		alert("num?");
		numField.value="";
		numField.focus();
		
		return false;
		
	}
	
	return true;
}
function check(){
	var numField=document.f.n;
	//배열은 그냥 쓰는게 가능 javascript에서 구분이 따로없기에
	if(checkEmpty(numField)||isNotNum(numField)||shortThan(numField,3)||numField.value.indexOf("-")!=-1||numField.value.indexOf(".")!=-1||
	numField.value[0]==numField.value[1]||numField.value[1]==numField.value[2]||numField.value[2]==numField.value[0] ){
		alert("num?");
		numField.value="";
		numField.focus();
		
		return false;
		
	}
	
	return true;
}
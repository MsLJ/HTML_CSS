function calCheck(){
	var xField=document.calcForm.x;
	var yField=document.calcForm.y;
	
	if(checkEmpty(xField)||isNotNum(xField)||checkEmpty(yField)||isNotNum(yField)){
		
		alert("num?");
		return false;
		
		
	}
	return true;
}
function bbcheck(){
	var numField=document.bbf.bbn;
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
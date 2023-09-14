function numcheck(){
	var numFiled=document.introform.num;
	
	if(checkEmpty(numFiled)||isNotNum(numFiled)){
		alert("num?");
		numFiled.value=("");
		return false;
		
		
	}
	
	return true;
	
	
}
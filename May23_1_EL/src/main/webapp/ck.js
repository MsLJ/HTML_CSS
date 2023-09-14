function check(){
	var bck=document.f.b;
	var b2ck=document.f.b2;
	if(checkEmpty(bck)||isNotNum(bck)||shortThan(bck,6)){
		return false;
	}
	if(checkEmpty(b2ck)||isNotNum(b2ck)||shortThan(b2ck,1)){
		alert("retry");
		return false;
	}
	return true;
}
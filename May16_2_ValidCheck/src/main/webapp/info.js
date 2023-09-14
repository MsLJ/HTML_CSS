function check(){
	var nameField=document.f.namee;
	var ageField=document.f.agee;
	var imgField=document.f.photoo;
	
	if(checkEmpty(nameField)){
		alert("name");
		nameField.value="";
		return false;
		
	}
	if(checkEmpty(ageField)||isNotNum(ageField)){
		alert("age");
		ageField.value="";
		return false;
	}
	if(checkEmpty(imgField)||isNotType(imgField,"jpg")&&isNotType(imgField,"png")&&isNotType(imgField,"gif")){
		alert("img");
		imgField.value="";
		return false;
		
	}
	
	
	
}
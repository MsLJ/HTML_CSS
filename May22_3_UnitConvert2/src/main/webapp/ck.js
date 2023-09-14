function check(){
	var nameField=document.f.name;
	var weightField=document.f.weight;
	var heightField=document.f.height;
	var fileField=document.f.p;
	
	if(checkEmpty(nameField)){
		alert("이름?");
		return false;
	}
	if(checkEmpty(weightField)||isNotNum(weightField)){
		alert("몸무게?");
		return false;
	}
	if(checkEmpty(heightField)||isNotNum(heightField)&&heightField.value<=3){
		alert("키?");
		return false;
	}
	if(checkEmpty(fileField)||isNotType(fileField,"jpg")&&isNotType(fileField,"png")&&isNotType(fileField,"gif")){
		alert("파일?");
		return false;
	}
	return true;
	
}
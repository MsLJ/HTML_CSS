function check(){
	var nameField=document.f.name;
	var weightField=document.f.weight;
	var heightField=document.f.height;
	var fileField=document.f.p;
	
	if(checkEmpty(nameField)){
		alert("�̸�?");
		return false;
	}
	if(checkEmpty(weightField)||isNotNum(weightField)){
		alert("������?");
		return false;
	}
	if(checkEmpty(heightField)||isNotNum(heightField)&&heightField.value<=3){
		alert("Ű?");
		return false;
	}
	if(checkEmpty(fileField)||isNotType(fileField,"jpg")&&isNotType(fileField,"png")&&isNotType(fileField,"gif")){
		alert("����?");
		return false;
	}
	return true;
	
}
function check(){
	var idField=document.f.idd;
	var pwField=document.f.pw;
	var pwCKField=document.f.pwcheck;
	var ageField=document.f.age;
	var imgField=document.f.photo;
	if(checkEmpty(idField)
	||shortThan(idField,5)
	||containsHS(idField)){
		alert("ID?");
		idField.focus();
		return false;
	}
	if(checkEmpty(pwField)||shortThan(pwField,6)||notEquals(pwField,pwCKField)||notContain(pwField,"1234")){
		alert("PW?");
		pwField.focus();
		return false;
	}
	
	if(checkEmpty(ageField)||isNotNum(ageField)){
		alert("AGE?");
		ageField.focus();
		return false;
	}
	
	if(checkEmpty(imgField)||isNotType(imgField,"png")&&isNotType(imgField,"jpg")&&isNotType(imgField,"gif")){
		alert("img?");
		imgField.value="";
		return false;
	}
	
	return true;
}

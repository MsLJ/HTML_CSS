function checkEmpty(input) {
	return !input.value;
}

function isNotNum(input){
	return input.value.indexOf(" ")!=-1||isNaN(input.value);
	
}
function isNotType(input,type){
	type="."+type;
	return input.value.toLowerCase().indexOf(type)==-1;
		
}
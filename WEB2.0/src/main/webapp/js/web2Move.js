function bye(){
	var really=prompt("Ż���Ϸ��� Ż��� �Է�");
	if(really=="Ż��"){
		location.href="ByeController";
	}
}

function deletePhoto(no){
	if(confirm("really")){
		location.href="PhotoZoneDeleteController?no="+no;
	}
}
function snsWriteCheck(){
	var confirmwr=document.snsWriteForm.txt;
	if(checkEmpty(confirmwr)){
		alert("������ �Է����ּ���");
		return false;
	}
	
}
function deleteSNS(no){
	if(confirm("really")){
		location.href="SnsDeleteController?no="+no;
	}
}
function deleteReply(no){
	var really=prompt("������ �Է�");
	if(really=="����"){
		location.href="SnsReplyController?no="+no;
	}
}

function updateSNSMsg(no,txt){
	var txt=prompt("������ ����",txt);
	if(txt!=null&&txt.length<251){
		location.href="SNSUpdateController?no="+no+"&txt="+txt;
	}
}
function snsREChek(f){
	var txtField=f.txt;
	if(checkEmpty(txtField)){
		alert("������ �Է����ּ���");
		return false;
	}
	return true;
}
function photoCheck(){
	var photoFiled=document.photoF.photo;
	if(checkEmpty(photoFiled)||isNotType(photoFiled, "png") && isNotType(photoFiled, "jpg") && isNotType(photoFiled, "gif")){
	alert("������ �־��ּ���");
	return false;
	}
	return true;
}
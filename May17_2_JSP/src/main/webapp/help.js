function checkEmpty(input) {
	return !input.value;
}
//input,���ڼ��� �־�����
//ª���� true,�ƴϸ� false
function shortThan(input, len) {
	return input.value.length < len;
}
//input�־�����
//�ѱ�/Ư�����ڰ� ������true,������false
//	-_@.�� ������
function containsHS(input) {
	var hs = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM-_@.";
	for (var i = 0; i < input.value.length; i++) {
		if (hs.indexOf(input.value[i]) == -1) {
			return true;

		}
	}
	return false;

}
//inputx2�־�����
//�Է��Ѱ� �ٸ��� true,������ false
function notEquals(input1, input2) {
	return input1.value != input2.value;
}
//input,���ڿ���Ʈ �־����� �װ� �ȵ�������� true,���������false
function notContain(input, set) {
	for (var i = 0; i <= set.length; i++) {
		if (input.value.indexOf(set[i])!=-1){
			return false;

		}
	}
	return true;
}

//input�־�����
//���ڰ� �ƴϸ� true ���ڸ� false
function isNotNum(input){
	return input.value.indexOf(" ")!=-1||isNaN(input.value);
	
}
//input,Ȯ���ڸ� �־�����
//�� ������ �ƴϸ� true,�װ� ������ false

//�ʹ� ��å��
//	1)Ȯ����:���ʿ� ���
//	2)
function isNotType(input,type){
	type="."+type;
	return input.value.toLowerCase().indexOf(type)==-1;		
}
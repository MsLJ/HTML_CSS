function check() {
	var xField = document.f.x;
	var yField = document.f.y;



	//back-end������:�Ⱥ��̴� ����->java
	//front-end������:���̴� �κ�->javaScript
	//full-stack������:�� ��

	//Model
	//	JavaScript:front-end������


	if (checkEmpty(xField) || isNotNum(xField) || checkEmpty(yField) || isNotNum(yField)) {
		alert("?");
		return false;



	}
	return true;


}
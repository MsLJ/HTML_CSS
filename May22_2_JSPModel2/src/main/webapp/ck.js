function check() {
	var xField = document.f.x;
	var yField = document.f.y;



	//back-end개발자:안보이는 ㅂ분->java
	//front-end개발자:보이는 부분->javaScript
	//full-stack개발자:둘 다

	//Model
	//	JavaScript:front-end개발자


	if (checkEmpty(xField) || isNotNum(xField) || checkEmpty(yField) || isNotNum(yField)) {
		alert("?");
		return false;



	}
	return true;


}
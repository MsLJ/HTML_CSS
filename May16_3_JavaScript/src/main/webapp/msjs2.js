
function arrayTest(){
//Java:int[]ar={123,21,12};	
var ar=[1,2,3,4,5,6,7,8];

for(var i=0; i<ar.length;i++){
	alert(ar[i]);
}

}
function objTest(){
	//Dog d=new Dog();
	//d.setName("����");
	//d.setAge(3);
	//syso(d);
	//syso(d.getName());
	//syso(d.age);
	
	var d={name:"����",age:3};
	alert(d.name);
	alert(d.age);	
	
	
}
function arrobjTest(){
	//Dog[]dogs;
	//ArrayList<Dog>dogs;
	
	var malang=[
		{name:"cow",count:10},
		{name:"cw",count:5},
		{name:"ow",count:1}
		];
		for(var i=0; i<=malang.length;i++){
			alert(malang[i].name +"�ǰ���:"+malang[i].count);
		}

	
}
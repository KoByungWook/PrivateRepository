package ch06.homework1;

public class Car3 {

	String company = "�����ڵ���";
	String model = "�׷���";
	String color = "����";
	int maxSpeed = 350;

	Car3() {
	}
	
	Car3(String model){
		this(model, "����", 250);
	}
	
	Car3(String model, String color) {
		this(model, color, 250);
	}
	
	Car3(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}

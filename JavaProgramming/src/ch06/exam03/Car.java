package ch06.exam03;

public class Car {
	//Field
	String company = "현대자동차";
	int speed;
	String color;
	boolean airbag;
	
	//Constructor
	Car() {
		this("현대자동차", null, false);
	}
	Car(String color, boolean airbag) {
		this("현대자동차", color, airbag);
	}
	Car(String company, String color, boolean airbag) {
		this.company = company;
		this.color = color;
		this.airbag = airbag;
	}
	
	//Method
	void run() {
		System.out.println("현재  "+ speed + "km/h로 달립니다.");
		System.out.println("자동차의 색깔은 "+ color + "입니다.");
	}
}

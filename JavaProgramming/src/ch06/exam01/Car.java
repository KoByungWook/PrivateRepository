package ch06.exam01;

public class Car {
	//Field
	String company = "현대자동차";
	int speed;
	String color;
	boolean airbag;
	
	//Constructor
	Car() {
		System.out.println("Car 객체 생성");
	}
	
	//Method
	void run() {
		System.out.println("현재  "+ speed + "km/h로 달립니다.");
		System.out.println("자동차의 색깔은 "+ color + "입니다.");
	}
}

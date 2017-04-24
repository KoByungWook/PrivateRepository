package ch06.examreview;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed + "오르 달립니다.");
	}
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}

}

package ch06.examreview;

public class Car2Example {

	public static void main(String[] args) {
		Car2 myCar = new Car2();
		
		myCar.setSpeed(-50);
		System.out.println("���� �ӵ� : " + myCar.getSpeed());

		myCar.setSpeed(50);
		System.out.println("���� �ӵ� : " + myCar.getSpeed());
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		
		System.out.println("���� �ӵ� : " + myCar.getSpeed());
	}

}

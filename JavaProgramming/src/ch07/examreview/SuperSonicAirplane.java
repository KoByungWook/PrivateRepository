package ch07.examreview;

public class SuperSonicAirplane extends Airplane {
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = NORMAL;
	
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행입니다.");
		} else {
			super.fly();
		}
	}
}

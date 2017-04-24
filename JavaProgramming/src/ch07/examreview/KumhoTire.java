package ch07.examreview;

public class KumhoTire extends Tire {
	
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		this.accumulatedRotation += 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "금호타이어 남은 회전 수 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + "금호타이어 Punk");
			return false;
		}
	}
}

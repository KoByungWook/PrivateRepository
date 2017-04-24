package ch07.examreview;

public class HankookTire extends Tire {
	
	
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		this.accumulatedRotation += 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "한국타이어 남은 회전 수 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + "한국 타이어 Punk");
			return false;
		}
	}
}

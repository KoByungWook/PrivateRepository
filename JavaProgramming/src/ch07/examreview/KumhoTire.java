package ch07.examreview;

public class KumhoTire extends Tire {
	
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		this.accumulatedRotation += 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "��ȣŸ�̾� ���� ȸ�� �� : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + "��ȣŸ�̾� Punk");
			return false;
		}
	}
}

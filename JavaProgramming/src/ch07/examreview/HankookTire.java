package ch07.examreview;

public class HankookTire extends Tire {
	
	
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		this.accumulatedRotation += 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "�ѱ�Ÿ�̾� ���� ȸ�� �� : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + "�ѱ� Ÿ�̾� Punk");
			return false;
		}
	}
}

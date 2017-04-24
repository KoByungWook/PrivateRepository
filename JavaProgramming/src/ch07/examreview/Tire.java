package ch07.examreview;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		this.accumulatedRotation += 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "남은 회전 수 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println(location + "Punk");
			return false;
		}
	}
}

package ch07.examreview2;

public abstract class Phone {
	//Field
	public String owner;
	
	//Constructor
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("폰 전원을 켭니다");
	}
	
	public void turnOff() {
		System.out.println("폰 전원을 끕니다");
	}
}

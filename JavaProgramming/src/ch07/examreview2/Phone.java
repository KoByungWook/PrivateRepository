package ch07.examreview2;

public abstract class Phone {
	//Field
	public String owner;
	
	//Constructor
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("�� ������ �մϴ�");
	}
	
	public void turnOff() {
		System.out.println("�� ������ ���ϴ�");
	}
}

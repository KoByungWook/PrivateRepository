package ch07.examreview;

public class CellPhone {
	//Field
	String model;
	String color;
	
	//Constructor
	
	//Method
	void powerOn() {
		System.out.println("������ �մϴ�.");
	}
	void powerOff() {
		System.out.println("�K���� ���ϴ�.");
	}
	void bell() {
		System.out.println("���� �︳�ϴ�.");
	}
	void sendVoice(String message) {
		System.out.println("�ڱ� : " + message);
	}
	void recieveVoice(String message) {
		System.out.println("���� : " + message);
	}
	void hangUp() {
		System.out.println("��ȭ�� �����ϴ�");
	}
}

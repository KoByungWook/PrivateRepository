package ch06.exam03;

public class Car {
	//Field
	String company = "�����ڵ���";
	int speed;
	String color;
	boolean airbag;
	
	//Constructor
	Car() {
		this("�����ڵ���", null, false);
	}
	Car(String color, boolean airbag) {
		this("�����ڵ���", color, airbag);
	}
	Car(String company, String color, boolean airbag) {
		this.company = company;
		this.color = color;
		this.airbag = airbag;
	}
	
	//Method
	void run() {
		System.out.println("����  "+ speed + "km/h�� �޸��ϴ�.");
		System.out.println("�ڵ����� ������ "+ color + "�Դϴ�.");
	}
}

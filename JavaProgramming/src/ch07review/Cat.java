package ch07review;

public class Cat extends Animal {
	public Cat() {
		this.kind = "������";
	}
	
	@Override
	public void sound() {
		System.out.println("�Ŀ�");
	}
}

package ch09.homework_exam;

public class AnonymousExample2 {
	public static void main(String[] args) {
		Anonymous2 anony = new Anonymous2();
		
		anony.field.turnOn();
		anony.method1();
		anony.method2(
			new RemoteControl() {
				@Override
				public void turnOn() {
					System.out.println("����ƮƼ�� �մϴ�.");
				}
				@Override
				public void turnOff() {
					System.out.println("����ƮƼ�� ���ϴ�.");
				}
			}
		);
	}
}

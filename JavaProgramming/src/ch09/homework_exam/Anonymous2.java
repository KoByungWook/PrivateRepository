package ch09.homework_exam;

public class Anonymous2 {
	RemoteControl field = new RemoteControl() {
		public void turnOn() {
			System.out.println("TV�� �մϴ�.");
		}
		
		public void turnOff() {
			System.out.println("TV�� ���ϴ�.");
		}
	};
	
	void method1() {
		RemoteControl localVar = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("������� �մϴ�.");
			}
			@Override
			public void turnOff() {
				System.out.println("������� ���ϴ�.");
			}
		};
		
		localVar.turnOn();
	}
	
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}

package ch09.homework.exercise;

public class Anonymous {
	Vehicle field = new Vehicle() {
		@Override
		public void run() {
			System.out.println("�����Ű� �޸��ϴ�");
		}
	};
	
	void method1() {
		Vehicle localVar = new Vehicle() {
			@Override
			public void run() {
				System.out.println("Ʈ���� �޸��ϴ�");
			}
		};
		localVar.run();
	}
	
	void method2(Vehicle v) {
		v.run();
	}
	
}

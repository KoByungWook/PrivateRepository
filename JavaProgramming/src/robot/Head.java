package robot;

public class Head {

	Eye eye = new Eye();
	Ear ear = new Ear();
	Mouth mouth = new Mouth();
	
	void see() {
		System.out.println("������ �մ��� �߰��Ѵ�.");
	}
	
	void said1() {
		System.out.println("���� �մԿ��� �λ��Ѵ�.");
		System.out.println("�������. �ֹ��Ͻðھ��?");
	}
	
	void said2() {
		System.out.println("���ְ� �弼��.");
		System.out.println("�ȳ��� ������.");
	}
	
	void hear(int x) {
		System.out.println("�ܹ��� " + x + "���� �ֹ��޾Ҵ�" );
	}
}

package robot;

public class Robot {

	Head head = new Head();
	Body body = new Body();
	Arm[] arms = { new Arm("����"), new Arm("������") };
	Leg[] legs = { new Leg("�޴ٸ�"), new Leg("�����ٸ�") };
	
	double nowTime = 1;
	double endTime;
	double operatingTime;
	
	
	Robot(double endTime, double operatingTime) {
		this.endTime = endTime;
		this.operatingTime = operatingTime;
	}
	
	void seeCustomer() {
		head.see();
	}
	
	void saidCustomer() {
		head.said1();
	}
	
	void goToKitchen() {
		System.out.println("�ڷ� ����");
		for(int i=0 ; i<5 ; i++){
			legs[0].move();
			legs[1].move();
		}
	}
	
	void makeHamburger(int x) {
		arms[0].chooseArm();
		System.out.println("���� ���´�.");
		arms[1].chooseArm();
		System.out.println("����߸� ���´�.");
		arms[0].chooseArm();
		System.out.println("��Ŭ�� ���´�.");
		arms[1].chooseArm();
		System.out.println("��Ƽ�� ���´�.");
		arms[0].chooseArm();
		System.out.println("�ҽ��� �Ѹ���.");
		arms[1].chooseArm();
		System.out.println("���� ���´�.");
		System.out.println("�ܹ��� " + (x+1) +"���� �ϼ��ߴ�.");
		System.out.println();
	}
	
	void goToCounter() {
		System.out.println("�ڷ� ����");
		for(int i=0 ; i<5 ; i++){
			legs[0].move();
			legs[1].move();
		}
	}
	
	void giveMenu() {
		System.out.println("�ֹ��Ͻ� �ܹ��� ���Խ��ϴ�.");
		arms[0].giveBurger();
	}
	
	void saidCustomer2() {
		head.said2();
	}
}

package ch07.examreview;

public class Carr {
	Tire frontLeftTire = new Tire("�տ���", 6);
	Tire frontRightTire = new Tire("�տ�����", 3);
	Tire backLeftTire = new Tire("�ڿ���", 2);
	Tire backRightTire = new Tire("�ڿ�����", 4);
	
	/*
	 Tire[] tires = {
			 new Tire("�տ���", 6),
			 new Tire("�տ�����", 3),
			 new Tire("�ڿ���", 2),
			 new Tire("�ڿ�����", 4)
	 }
	 */
	 
	
	int run() {
		System.out.println("�ڵ����� �޸��ϴ�.");
		if(frontLeftTire.roll() == false) {
			stop();
			return 1;
		}
		if(frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if(backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if(backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0;
	}
	
	/*
	int run() {
		for(int i=0 ; i<tires.length ; i++) {
			if(tires[i].roll()==false) {
				stop();
				return (i+1);
			}
		}
		return 0;
	}
	*/
	
	void stop() {
		System.out.println("�ڵ����� ����ϴ�");
	}
}

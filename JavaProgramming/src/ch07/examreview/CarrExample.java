package ch07.examreview;

public class CarrExample {

	public static void main(String[] args) {
		Carr car = new Carr();
		
		/*
		for(int i=0 ; i<=5 ; i++) {
			int problemLocation = car.run();
			if(problemLocation != 0){
				System.out.println(car.tires[problemLocation-1].location + "�ѱ�Ÿ�̾�� ��ü");
				car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
			}
		}
		*/
		
		for(int i=0 ; i<=7 ; i++){
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1 : 
					System.out.println("�� ���� �ѱ�Ÿ�̾�� ��ü");
					car.frontLeftTire = new HankookTire("�տ���", 15);
					break;
				case 2 : 
					System.out.println("�� ������ ��ȣŸ�̾�� ��ü");
					car.frontRightTire = new HankookTire("�տ�����", 15);
					break;
				case 3 : 
					System.out.println("�� ���� �ѱ�Ÿ�̾�� ��ü");
					car.backLeftTire = new HankookTire("�ڿ���", 15);
					break;
				case 4 : 
					System.out.println("�� ������ �ѱ�Ÿ�̾�� ��ü");
					car.backRightTire = new HankookTire("�ڿ�����", 15);
					break;
			}
			
			System.out.println("------------------------------");
		}

	}

}

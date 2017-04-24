package ch07.examreview;

public class CarrExample {

	public static void main(String[] args) {
		Carr car = new Carr();
		
		/*
		for(int i=0 ; i<=5 ; i++) {
			int problemLocation = car.run();
			if(problemLocation != 0){
				System.out.println(car.tires[problemLocation-1].location + "한국타이어로 교체");
				car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
			}
		}
		*/
		
		for(int i=0 ; i<=7 ; i++){
			int problemLocation = car.run();
			
			switch(problemLocation) {
				case 1 : 
					System.out.println("앞 왼쪽 한국타이어로 교체");
					car.frontLeftTire = new HankookTire("앞왼쪽", 15);
					break;
				case 2 : 
					System.out.println("앞 오른쪽 금호타이어로 교체");
					car.frontRightTire = new HankookTire("앞오른쪽", 15);
					break;
				case 3 : 
					System.out.println("뒤 왼쪽 한국타이어로 교체");
					car.backLeftTire = new HankookTire("뒤왼쪽", 15);
					break;
				case 4 : 
					System.out.println("뒤 오른쪽 한국타이어로 교체");
					car.backRightTire = new HankookTire("뒤오른쪽", 15);
					break;
			}
			
			System.out.println("------------------------------");
		}

	}

}

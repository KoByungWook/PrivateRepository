package robot;

import java.util.*;

public class RobotExample {
	public static void main(String[] args){
		
		Robot myRobot = new Robot(4.0, 0.0);
		
		while(true){
			System.out.println("현재시각 : " + (myRobot.nowTime += myRobot.operatingTime) + "시");
			System.out.println("종료시각 : " + myRobot.endTime + "시");
			System.out.println("손님이 들어온다.");
			
			myRobot.operatingTime = 0.0;
			
			if(myRobot.nowTime > myRobot.endTime){
				System.out.println("영업 시간이 종료되었습니다.");
				return;
			}	
			
			System.out.println();
			myRobot.seeCustomer();
			myRobot.saidCustomer();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println();
			System.out.print("주문하고자 하는 햄버거 개수를 입력하세요  >>");
			int numBurger = scanner.nextInt();
			
			myRobot.head.hear(numBurger);
			
			System.out.println();
			System.out.println("주방으로 간다.");
			myRobot.goToKitchen();
			System.out.print("주방에 도착했다.");
			myRobot.goToKitchen();
			myRobot.operatingTime += 0.3;
			
			System.out.println();
			for(int i=0 ; i<numBurger; i++){
			myRobot.makeHamburger(i);
			myRobot.operatingTime += 0.5;
			}
			System.out.println("주문받은 햄버거를 모두 만들었습니다.");
			
			System.out.println();
			System.out.println("카온터로 간다.");
			myRobot.goToCounter();
			System.out.println("카운터에 도착했다.");
			myRobot.operatingTime += 0.3;
			
			System.out.println();
			myRobot.giveMenu();
			myRobot.saidCustomer2();
			System.out.println();
			
		}
		
	}
}

package robot;

import java.util.*;

public class RobotExample {
	public static void main(String[] args){
		
		Robot myRobot = new Robot(4.0, 0.0);
		
		while(true){
			System.out.println("����ð� : " + (myRobot.nowTime += myRobot.operatingTime) + "��");
			System.out.println("����ð� : " + myRobot.endTime + "��");
			System.out.println("�մ��� ���´�.");
			
			myRobot.operatingTime = 0.0;
			
			if(myRobot.nowTime > myRobot.endTime){
				System.out.println("���� �ð��� ����Ǿ����ϴ�.");
				return;
			}	
			
			System.out.println();
			myRobot.seeCustomer();
			myRobot.saidCustomer();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println();
			System.out.print("�ֹ��ϰ��� �ϴ� �ܹ��� ������ �Է��ϼ���  >>");
			int numBurger = scanner.nextInt();
			
			myRobot.head.hear(numBurger);
			
			System.out.println();
			System.out.println("�ֹ����� ����.");
			myRobot.goToKitchen();
			System.out.print("�ֹ濡 �����ߴ�.");
			myRobot.goToKitchen();
			myRobot.operatingTime += 0.3;
			
			System.out.println();
			for(int i=0 ; i<numBurger; i++){
			myRobot.makeHamburger(i);
			myRobot.operatingTime += 0.5;
			}
			System.out.println("�ֹ����� �ܹ��Ÿ� ��� ��������ϴ�.");
			
			System.out.println();
			System.out.println("ī���ͷ� ����.");
			myRobot.goToCounter();
			System.out.println("ī���Ϳ� �����ߴ�.");
			myRobot.operatingTime += 0.3;
			
			System.out.println();
			myRobot.giveMenu();
			myRobot.saidCustomer2();
			System.out.println();
			
		}
		
	}
}

package ch12.exam09;

public class PrintThread2 extends Thread {
	//Field
	//Constructor
	//Method
	public void run() {
		try {
			while(true) {
				System.out.println("���� ��.........");
				System.out.println("���� ��.........");
				//Thread.sleep(1);
				if(isInterrupted()) {
					break;
				}
			}
		} catch(Exception e) {

		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
	

}
package ch12.homework;

public class MovieThread2 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("�������� ����մϴ�.");
			if(this.isInterrupted()) {
				break;
			}
		}
	}
}

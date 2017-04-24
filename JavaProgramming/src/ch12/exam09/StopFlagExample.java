package ch12.exam09;

public class StopFlagExample {
	public static void main(String[] args) {
		//how1
		PrintThread1 thread = new PrintThread1();
		thread.start();
		
		try {
			thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
	}
}

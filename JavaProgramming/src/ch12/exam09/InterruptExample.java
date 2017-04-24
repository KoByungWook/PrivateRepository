package ch12.exam09;

public class InterruptExample {
	public static void main(String[] args) {
		
		//how2
		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		
		try {
			thread2.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		thread2.interrupt();
	}
}

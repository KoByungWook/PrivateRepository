package ch12.homework;

public class ThreadExample3 {
	public static void main(String[] args) {
		Thread thread = new MovieThread3();
		thread.setDaemon(true);
		thread.start();
		
		try { Thread.sleep(3000); } catch(InterruptedException e) {}
	}

}

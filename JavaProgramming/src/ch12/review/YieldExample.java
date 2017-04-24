package ch12.review;

public class YieldExample {
	public static void main(String[] args) {
		ThreadA2 threadA = new ThreadA2();
		ThreadB2 threadB = new ThreadB2();
		
		threadA.start();
		threadB.start();
		
		try { Thread.sleep(3000); } catch(InterruptedException e) {}
		threadA.work = false;
		
		try { Thread.sleep(3000); } catch(InterruptedException e) {}
		threadA.work = true;
		
		try { Thread.sleep(3000); } catch(InterruptedException e) {}
		threadA.stop = true;
		threadB.stop = true;
		
	}

}

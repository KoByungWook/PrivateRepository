package ch12.review;

public class ThreadA3 extends Thread{
	private WorkObject workObject;
	
	public ThreadA3(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodA3();
		}
	}
}

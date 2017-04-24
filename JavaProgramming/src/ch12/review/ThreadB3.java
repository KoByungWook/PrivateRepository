package ch12.review;

public class ThreadB3 extends Thread{
	private WorkObject workObject;
	
	public ThreadB3(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodB3();
		}
	}
}

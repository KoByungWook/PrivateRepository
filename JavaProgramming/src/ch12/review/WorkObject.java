package ch12.review;

public class WorkObject {
	public synchronized void methodA3() {
		System.out.println("ThreadA3�� methodA() �۾� ����");
		notify();
		try {
			wait();
		} catch(InterruptedException e) {
			
		}
	}
	
	public synchronized void methodB3() {
		System.out.println("ThreadB3�� methodB() �۾� ����");
		notify();
		try {
			wait();
		} catch(InterruptedException e) {
			
		}
	}
}

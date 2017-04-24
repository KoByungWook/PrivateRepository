package ch12.review;

public class WorkObject {
	public synchronized void methodA3() {
		System.out.println("ThreadA3의 methodA() 작업 실행");
		notify();
		try {
			wait();
		} catch(InterruptedException e) {
			
		}
	}
	
	public synchronized void methodB3() {
		System.out.println("ThreadB3의 methodB() 작업 실행");
		notify();
		try {
			wait();
		} catch(InterruptedException e) {
			
		}
	}
}

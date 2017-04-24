package ch12.review;

public class Databox {
	private String data;
	
	public synchronized String getData() {
		if(this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		String returnValue = data;
		System.out.println("Consummer�� ���� ������ : " + returnValue);
		data = null;
		notify();
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		this.data = data;
		System.out.println("Producer�� ������ ������ : " + data);
		notify();
	}
}

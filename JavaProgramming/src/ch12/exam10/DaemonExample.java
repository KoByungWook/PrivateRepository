package ch12.exam10;

public class DaemonExample {
	public static void main(String[] args) {
		System.out.println("���� ���μ����� ������");				
		
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		
		try { autoSaveThread.sleep(5000); } catch (InterruptedException e) {}
		System.out.println("���� ���μ����� ������");	
	}

}
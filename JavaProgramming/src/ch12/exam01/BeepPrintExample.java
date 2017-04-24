package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		// 소리를 내는 코드
		/*BeepTask beepTask = new BeepTask(); 
		Thread thread = new Thread(beepTask);		
		thread.start();*/
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();		//Runnable을 익명개체로 만드는 것
				for(int i=0; i<5; i++) {
				toolkit.beep();
					try {
						Thread.sleep(500);
					} catch(InterruptedException e) {
						
					}
				}
			}
		});
		System.out.println(thread.getName());
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				
			}
		}

	}
}

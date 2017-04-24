package ch12.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		// 소리를 내는 코드
		/*BeepThread beepThread = new BeepThread();
		beepThread.start();*/
		Thread thread = new Thread() {				//Thread의 자식객체를 만드는것
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
				toolkit.beep();
					try {
						Thread.sleep(500);
					} catch(InterruptedException e) {
						
					}
				}
			}
		};				
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

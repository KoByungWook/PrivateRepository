package ch09.homework_exam;

public class Window {
	Button2 button1 = new Button2();
	Button2 button2 = new Button2();
	
	Button2.OnClickListener listener = new Button2.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다");
		}
	};
	
	Window() {
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new Button2.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("메시지를 보냅니다");
			}
		});
	}
}

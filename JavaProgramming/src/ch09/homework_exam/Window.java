package ch09.homework_exam;

public class Window {
	Button2 button1 = new Button2();
	Button2 button2 = new Button2();
	
	Button2.OnClickListener listener = new Button2.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("��ȭ�� �̴ϴ�");
		}
	};
	
	Window() {
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new Button2.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("�޽����� �����ϴ�");
			}
		});
	}
}

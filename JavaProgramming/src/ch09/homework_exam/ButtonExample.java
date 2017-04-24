package ch09.homework_exam;

public class ButtonExample {

	public static void main(String[] args) {
		Button button = new Button();
		
		button.setListener(new CallListener());
		button.touch();
		
		button.setListener(new MessgaeListener());
		button.touch();
	}

}

package ch09.homework_exam;

public class MessgaeListener implements Button.OnClickListener {
	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다");
	}
}

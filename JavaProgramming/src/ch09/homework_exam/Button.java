package ch09.homework_exam;

public class Button {
	OnClickListener listener;

	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	interface OnClickListener {
		void onClick();
	}
}

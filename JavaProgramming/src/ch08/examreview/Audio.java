package ch08.examreview;

public class Audio implements RemoteControl {
	//Field
	private int volume;

	//Method
	@Override
	public void turnOn() {
		System.out.println("������� �մϴ�");
	}

	@Override
	public void turnOff() {
		System.out.println("������� ���ϴ�");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("���� Audio ���� : " + volume);
	}
	
	
}

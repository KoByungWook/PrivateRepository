package ch08.examreview;

public interface RemoteControl {
	//Constant Field
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	// static final ���� ����
	// ������� ��� �빮�ڷ� �����ϴ� ���� ����
	
	
	//Method
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	// �߻� �޼ҵ� ���� �� public ������ �ʾƵ� ������, ������ �� �ٿ���� �ϹǷ� �ٿ��൵ ����
}

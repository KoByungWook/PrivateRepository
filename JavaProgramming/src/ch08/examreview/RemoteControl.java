package ch08.examreview;

public interface RemoteControl {
	//Constant Field
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	// static final 생략 가능
	// 상수명은 모두 대문자로 선언하는 것이 관례
	
	
	//Method
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	// 추상 메소드 선언 시 public 붙이지 않아도 되지만, 재정의 시 붙여줘야 하므로 붙여줘도 좋음
}

package ch08.examreview;

public class RemoteControllerExample {
	public static void main(String[] args){
		RemoteControl rc;
		
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
	}
}

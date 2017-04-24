package ch08.exam01;

public class Car implements Manual {
	//Field
	private int speed;
	//Constructor
	//Method
	
	@Override
	public void turnOn() {
		System.out.println("전동 차를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("전동 차를 끕니다.");
	}

	@Override
	public void setSpeed(int speed) {
		System.out.println("속도를 " + speed +"로 변경합니다.");
		if(speed < MIN_SPEED) {
			this.speed = MIN_SPEED;
			
		} else if(speed > MAX_SPEED) {
			this.speed = MAX_SPEED;
		}
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void run() {
		System.out.println("전동 차가 " + speed +"의 속도로 달립니다.");
	}

}

package ch08.exam01;

public class Car implements Manual {
	//Field
	private int speed;
	//Constructor
	//Method
	
	@Override
	public void turnOn() {
		System.out.println("���� ���� �մϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("���� ���� ���ϴ�.");
	}

	@Override
	public void setSpeed(int speed) {
		System.out.println("�ӵ��� " + speed +"�� �����մϴ�.");
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
		System.out.println("���� ���� " + speed +"�� �ӵ��� �޸��ϴ�.");
	}

}

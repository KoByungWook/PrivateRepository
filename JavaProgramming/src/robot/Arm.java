package robot;

public class Arm {

	String location;
	
	Arm(String location) {
		this.location = location;
	}
	
	void chooseArm() {
		System.out.print(location + "���� ");
	}
	
	void giveBurger(){
		System.out.println("�ܹ��Ÿ� �մԿ��� �����ش�.");
	}
}

package robot;

public class Arm {

	String location;
	
	Arm(String location) {
		this.location = location;
	}
	
	void chooseArm() {
		System.out.print(location + "으로 ");
	}
	
	void giveBurger(){
		System.out.println("햄버거를 손님에게 전해준다.");
	}
}

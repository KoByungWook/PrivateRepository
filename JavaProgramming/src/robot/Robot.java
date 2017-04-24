package robot;

public class Robot {

	Head head = new Head();
	Body body = new Body();
	Arm[] arms = { new Arm("왼팔"), new Arm("오른팔") };
	Leg[] legs = { new Leg("왼다리"), new Leg("오른다리") };
	
	double nowTime = 1;
	double endTime;
	double operatingTime;
	
	
	Robot(double endTime, double operatingTime) {
		this.endTime = endTime;
		this.operatingTime = operatingTime;
	}
	
	void seeCustomer() {
		head.see();
	}
	
	void saidCustomer() {
		head.said1();
	}
	
	void goToKitchen() {
		System.out.println("뒤로 돈다");
		for(int i=0 ; i<5 ; i++){
			legs[0].move();
			legs[1].move();
		}
	}
	
	void makeHamburger(int x) {
		arms[0].chooseArm();
		System.out.println("빵을 놓는다.");
		arms[1].chooseArm();
		System.out.println("양상추를 놓는다.");
		arms[0].chooseArm();
		System.out.println("피클을 놓는다.");
		arms[1].chooseArm();
		System.out.println("패티를 놓는다.");
		arms[0].chooseArm();
		System.out.println("소스를 뿌린다.");
		arms[1].chooseArm();
		System.out.println("빵을 놓는다.");
		System.out.println("햄버거 " + (x+1) +"개를 완성했다.");
		System.out.println();
	}
	
	void goToCounter() {
		System.out.println("뒤로 돈다");
		for(int i=0 ; i<5 ; i++){
			legs[0].move();
			legs[1].move();
		}
	}
	
	void giveMenu() {
		System.out.println("주문하신 햄버거 나왔습니다.");
		arms[0].giveBurger();
	}
	
	void saidCustomer2() {
		head.said2();
	}
}

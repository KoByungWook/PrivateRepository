package robot;

public class Leg {

	String location;
	
	Leg(String location) {
		this.location = location;
	}
	
	void move() {
		System.out.println(location + "À» ³»µó´Â´Ù.");
	}
}

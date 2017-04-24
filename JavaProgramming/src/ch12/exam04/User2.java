package ch12.exam04;

public class User2 extends Thread {
	//Field
	private Calculator calculator;
	//Constructor
	public User2() {
		super("User2");
	}
	//Method
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}

}

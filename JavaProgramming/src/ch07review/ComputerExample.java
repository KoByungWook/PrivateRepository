package ch07review;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator calc = new Calculator();
		System.out.println("������ : " + calc.areaCircle(r));
		
		Computer comp = new Computer();
		System.out.println("������ : " + comp.areaCircle(r));
	}

}

package ch07.examreview;

public class NewCalculatorExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("������ : " + calculator.areaCircle(r));
		
		NewCalculator newCalculator = new NewCalculator();
		System.out.println("������ : " + newCalculator.areaCircle(r));
	}	
		

}

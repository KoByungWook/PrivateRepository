package ch06review.calc_Static;

public class CalculatorExample {

	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		System.out.println(result1);
		System.out.println(result2);
		
		Calculator calc = new Calculator();
		int result3 = calc.plus(10, 5); // 객체 참조해 쓸 수는 있지만 경고
		System.out.println(result3);

	}

}

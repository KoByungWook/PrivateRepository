package ch06review.calc_Overloading;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCaclu = new Calculator();
		
		double result1 = myCaclu.areaRectangle(10);
		double result2 = myCaclu.areaRectangle(10, 20);
		
		System.out.println(result1 + " " + result2);
	}

}

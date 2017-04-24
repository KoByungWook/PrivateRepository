package ch07.examreview;

public class NewCalculator extends Calculator {

	@Override
	double areaCircle(double r) {
		System.out.println("NewCalculator °´Ã¼ÀÇ areaCircle() ½ÇÇà");
		return Math.PI * r * r;
	}
}

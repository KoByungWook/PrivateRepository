package ch07.examreview;

public class NewCalculator extends Calculator {

	@Override
	double areaCircle(double r) {
		System.out.println("NewCalculator ��ü�� areaCircle() ����");
		return Math.PI * r * r;
	}
}

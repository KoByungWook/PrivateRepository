package ch14.exam09;

import java.util.function.IntBinaryOperator;

public class LambdaExpressionExample {
	private static int[] scores = { 92, 95, 87 };
	
	public static void main(String[] args) {
		System.out.println("최대값: " + maxOrMin( Math :: max ));
		System.out.println("최소값: " + maxOrMin( Math :: min ));
	}
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for( int score : scores ) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
}

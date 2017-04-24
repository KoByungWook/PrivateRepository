package ch14.exam03;

public class LambdaExpressionExample {
	public static int a = 5;
	
	public static void main(String[] args) {
		method1( () -> {
			a = 8;										//필드는 값 변경 얼마든지 가능
			System.out.println(a);
		} );
		
		int b = 5;
		
		method1( () -> {
			//b = 8;	
			while(true) {												//로컬변수 파이널 특성이기 때문에 변경 불가
				System.out.println(b);
			}
		} );
	}

	public static void method1(FunctionalInterface1 i) {
		i.method();
	}

}


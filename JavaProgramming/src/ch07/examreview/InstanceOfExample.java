package ch07.examreview;

public class InstanceOfExample {

	public static void method1(Parent2 parent2) {
		if(parent2 instanceof Child2) {
			Child2 child2 = (Child2) parent2;
			System.out.println("method1 - child로 변환 성공");
		} else { 
			System.out.println("method1 - child로 변환 실패");
		}

	}
	
	public static void method2(Parent2 parent2) {
		Child2 child2 = (Child2) parent2;
		System.out.println("method2 - child로 변환 성공");
	}
	
	public static void main(String[] args) {
		Parent2 parentA = new Child2();
		method1(parentA);
		method2(parentA);
		
		Parent2 parentB	= new Parent2();
		method1(parentB);
		method2(parentB);
	}
}

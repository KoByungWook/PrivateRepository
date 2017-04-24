package ch07.examreview;

public class InstanceOfExample {

	public static void method1(Parent2 parent2) {
		if(parent2 instanceof Child2) {
			Child2 child2 = (Child2) parent2;
			System.out.println("method1 - child�� ��ȯ ����");
		} else { 
			System.out.println("method1 - child�� ��ȯ ����");
		}

	}
	
	public static void method2(Parent2 parent2) {
		Child2 child2 = (Child2) parent2;
		System.out.println("method2 - child�� ��ȯ ����");
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

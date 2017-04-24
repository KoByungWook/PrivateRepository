package ch09.exam05;

public class A {
	//Field
	//Constructor
	A() {
		class D {
			//Field
			//constructor
			//Method
		}
		D d = new D();
	}
	//Method
	void aMethod() {
		class E {
			//Field
			//constructor
			//Method
		}
		E e = new E();   // aMethod 끝나면 사라지기 때문에 반드시 안에서 클래스 써야함.
	}
	
		//Nested Class
	class B {
		//Field
		//constructor
		//Method
	}
	static class C {
		//Field
		//constructor
		//Method

	}		
}

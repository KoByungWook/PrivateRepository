package ch09.exam02;

public class A {
	//Field
	static int aField;
	int aField2;
	//Constructor
	A() {
		class D {
			//Field
			//constructor
			//Method
			void dMethod() {
				aField = 10;
				aField2 = 20;
			}
		}
	}
	//Method
	void aMethod() {
		class E {
			//Field
			//constructor
			//Method
			void eMethod() {
				aField = 10;
				aField2 = 20;
			}
		}
	}
	
		//Nested Class
	class B {
		//Field
		//constructor
		//Method
		void bMethod() {
			aField = 10;
			aField2 = 20;
		}	
	}
	static class C {
		//Field
		//constructor
		//Method
		void cMethod() {
			aField = 10;
		}
	}		
}

package ch09.exam04;

public class A {
	//Field
	int field;
	//Constructor
	//Method
	
	//NestedMemberClass
	class B {					//B는 A가 생성되었다는 전제 하에 생성
		//Field
		int field;
		//Constructor
		//Method
		void method() {
			field = 10;
			this.field = 10;
			A.this.field = 11;
		}
	}
}

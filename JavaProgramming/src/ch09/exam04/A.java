package ch09.exam04;

public class A {
	//Field
	int field;
	//Constructor
	//Method
	
	//NestedMemberClass
	class B {					//B�� A�� �����Ǿ��ٴ� ���� �Ͽ� ����
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

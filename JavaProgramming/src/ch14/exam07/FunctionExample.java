package ch14.exam07;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		method1( (d) -> { return (int)d; } );
		method1( (d) -> { return (int)Math.round(d); } );
		
		method2( (m) -> { return m.getMid(); } );
		method2( (m) -> { return m.getMname(); } );
	}
	
	public static void method1(DoubleToIntFunction arg)	{
		int result = arg.applyAsInt(3.54);					//method1�� ȣ���� �� ��� ǥ���� ������ �˷������.
		System.out.println(result);
	}
	
	
	public static void method2(Function<Member, String> arg) {
		Member member = new Member("white", "ȫ�浿");
		String result = arg.apply(member);
		System.out.println(result);
	}

}

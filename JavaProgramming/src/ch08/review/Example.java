package ch08.review;

public class Example {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		A ia = impl;
		ia.methodA();
		
		B ib = impl;
		ib.methodB();
		
		C ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}

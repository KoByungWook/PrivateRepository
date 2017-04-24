package ch08.review;

public class ImplementationC implements C {


	@Override
	public void methodB() {
		System.out.println("B");
		
	}

	@Override
	public void methodC() {
		System.out.println("C");
	}

	@Override
	public void methodA() {
		System.out.println("A");
	}
	
}

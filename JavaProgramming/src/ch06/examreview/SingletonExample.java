package ch06.examreview;

public class SingletonExample {

	public static void main(String[] args) {
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("Same Singleton Instance");
		} else {
			System.out.println("Different Singleton Instance");
		}

	}

}

package ch06review;

public class KoreanExample {
	public static void main(String[] args) {
		Korean k1 = new Korean("박자바", "123456-1234567");
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		Korean k2 = new Korean("김자바", "123456-2234567");
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}

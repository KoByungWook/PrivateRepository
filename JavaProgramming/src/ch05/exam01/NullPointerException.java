package ch05.exam01;

public class NullPointerException {

	public static void main(String[] args) {
		/*
		int[] scores = null;
		
		System.out.println(scores[0]);
		*/
		
		String name = null;
		System.out.println(name.length()); // null pointer exception ¹ß»ý
	}

}

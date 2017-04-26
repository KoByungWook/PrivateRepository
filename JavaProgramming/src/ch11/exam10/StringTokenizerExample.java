package ch11.exam10;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String text = "abcde";
		
		StringTokenizer st = new StringTokenizer(text, "/");
		System.out.println(st.toString());
		
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.gc();
		System.out.println(st.countTokens());
		
		System.out.println();
		
		st = new StringTokenizer(text, "/");
		while( st.hasMoreTokens() ) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
	}

}

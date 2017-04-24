package ch11.homework;

import java.util.StringTokenizer;

public class SpiltExample {

	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		
		String[] result = str.split(",");
		for(String name : result) {
			System.out.println(name);
		}
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}

	}

}

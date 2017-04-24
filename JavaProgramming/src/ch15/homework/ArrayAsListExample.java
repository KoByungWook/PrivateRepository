package ch15.homework;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList( "홍길동", "감자바", "신용권" );
		for(String name : list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = Arrays.asList( 1, 2, 3 );
		for(Integer num : list2) {
			System.out.println(num);
		}
	}

}

package ch15.exam06;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();		//Set으로 정의 시 TreeSet의 메소드 사용 불가
		set.add(87);
		set.add(98);
		set.add(75);
		set.add(95);
		set.add(80);
		
		int min = set.first();
		System.out.println(min);
		int max = set.last();
		System.out.println(max);
		
		Set<Integer> set2 = set.subSet(80, true, 90, false);
		for(int score : set2) {
			System.out.print(" " + score);
		}
		
		System.out.println();
		System.out.println();
		
		Set<Integer> set3 = set.descendingSet();
		for(int score: set3) {
			System.out.println(" " + score);
		}
	}

}

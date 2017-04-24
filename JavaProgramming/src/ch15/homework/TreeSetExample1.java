package ch15.homework;

import java.util.TreeSet;

public class TreeSetExample1 {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		Integer score = null;
		
		score = scores.first();
		System.out.println("���� ���� ����: " + score);
		
		score = scores.last();
		System.out.println("���� ���� ����: " + score);
		
		score = scores.lower(95);
		System.out.println("95�� �Ʒ� ����: " + score);
		
		score = scores.higher(95);
		System.out.println("95�� ���� ����: " + score);
		
		score = scores.floor(95);
		System.out.println("95�� �̰ų� �ٷ� �Ʒ� ����: " + score);
		
		score = scores.ceiling(95);
		System.out.println("95�� �̰ų� �ٷ� ���� ����: " + score);
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score + "(���� ��ü ��: " + scores.size() + ")");
		}
	}

}

package ch15.homework;

import java.util.TreeSet;

public class TreeSetExampleEx {
	public static void main(String[] args) {
		TreeSet<StudentEx2> treeSet = new TreeSet<StudentEx2>();
		treeSet.add(new StudentEx2("blue", 96));
		treeSet.add(new StudentEx2("hong", 86));
		treeSet.add(new StudentEx2("white", 92));
		
		StudentEx2 student = treeSet.last();
		System.out.println("�ְ�����: " + student.score);
		System.out.println("�ְ������� ���� ���̵�: " + student.id);
	}

}

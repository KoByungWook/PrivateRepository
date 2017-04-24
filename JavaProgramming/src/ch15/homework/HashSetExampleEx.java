package ch15.homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExampleEx {
	public static void main(String[] args) {
		Set<StudentEx> set = new HashSet<StudentEx>();
		
		set.add(new StudentEx(1, "È«±æµ¿"));
		set.add(new StudentEx(2, "½Å¿ë±Ç"));
		set.add(new StudentEx(1, "Á¶¹Î¿ì"));
		
		Iterator<StudentEx> iterator = set.iterator();
		while(iterator.hasNext()) {
			StudentEx student = iterator.next();
			System.out.println(student.studentNum + ": " + student.name);
		}
	}
}

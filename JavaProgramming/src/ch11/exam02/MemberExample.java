package ch11.exam02;

import java.util.HashSet;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");

		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		
		HashSet hashSet = new HashSet();
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.println(hashSet.size());		//해쉬코드가 다르기 때문에 두개가 들어감
	}

}

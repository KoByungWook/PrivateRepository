package ch11.exam03;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("blue");
		System.out.println(m1.toString());
		System.out.println(m1);
		
		String result = m1 + " good!";	// +는 ㅁ문자열 간 결합
		System.out.println(result);
	}

}

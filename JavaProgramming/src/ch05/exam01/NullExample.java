package ch05.exam01;

public class NullExample {

	public static void main(String[] args) {
		
		String v1 = null; // 선언과 동시에 v1 생성
		
		String v2; // 아직 v2 생성되지 않음
		//v2 = null;
		
		int[] v3 = null;
		
		if(v3 == null){
			System.out.println("null");
		} else if(v3 != null) {
			System.out.println("not null");
		}

	}

}

package ch07review;

public class StudentExample {

	public static void main(String[] args) {
		Student student = new Student("홍길동", "123456-1234567", 10);
		
		System.out.println("이름 " + student.name);
		System.out.println("주민등록번호 " + student.ssn);
		System.out.println("번호 " + student.studentNo);
	}

}

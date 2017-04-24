package ch11.exam05;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id) {
		this.id = id;
	}
	//Method
	@Override
	public String toString() {
		return this.id;
	}

	@Override	//가비지 컬랙터가 제거할 때 실행
	protected void finalize() throws Throwable {
		System.out.println(id + "가 제거됨");
	}
}

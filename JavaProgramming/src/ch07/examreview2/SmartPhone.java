package ch07.examreview2;

public class SmartPhone extends Phone {
	//Field
	
	//Constructor
	public SmartPhone(String owner) {
		super(owner);
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다");
	}
}

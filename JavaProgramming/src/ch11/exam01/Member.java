package ch11.exam01;

public class Member {
	//Field
	private String id;
	//Constructor

	public Member(String id) {
		this.id = id;
		
	}
	
	//Method
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member target = (Member)obj;	//강제 형변환, 멤버의 필드에 접근하기 위해.
			if(id.equals(target.id)) {
				return true;
			}
		}
		
		return false;
	}
}

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
			Member target = (Member)obj;	//���� ����ȯ, ����� �ʵ忡 �����ϱ� ����.
			if(id.equals(target.id)) {
				return true;
			}
		}
		
		return false;
	}
}

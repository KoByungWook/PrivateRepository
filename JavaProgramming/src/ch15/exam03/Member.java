package ch15.exam03;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			String target = member.name;
			int target2 = member.age;
			if(name.equals(target) && age == target2) {
				return true;
			}
		}
		
		return false;
	}
}

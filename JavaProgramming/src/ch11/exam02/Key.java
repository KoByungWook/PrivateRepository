package ch11.exam02;

public class Key {
	private int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key target = (Key)obj;	//강제 형변환, 멤버의 필드에 접근하기 위해.
			if(number == target.number) {
				return true;
			}
		}
		return false;
	}
}

package ch15.homework;

public class StudentEx {
	public int studentNum;
	public String name;
	
	public StudentEx(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return this.studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StudentEx) {
			StudentEx student = (StudentEx)obj;
			if(this.studentNum == student.studentNum) {
				return true;
			}
		}
		return false;
	}
	
}

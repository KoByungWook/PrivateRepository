package ch15.homework;

public class StudentEx2 implements Comparable<StudentEx2>{
	public String id;
	public int score;
	
	public StudentEx2(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(StudentEx2 o) {
		if(score < o.score) return -1;
		else if(score == o.score) return 0;
		else return 1;
	}
	
	
	
}

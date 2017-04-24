package ch10.homework_exercise;

public class NotExistIDException extends Exception {
	public NotExistIDException() {}
	public NotExistIDException(String message) {
			super(message);
	}
}

package ch10.exam05;

public class BalanceInsufficientException extends Exception {
	public BalanceInsufficientException() {}
	public BalanceInsufficientException(String message) {
		super(message);														//메세지를 받을 생성자
	}
}

package com.mycompany.myapp.exception;

//Spring에서 transaction 처리하기 위해서는 runtimeException이 발생되어야 한다
public class NoAccountException extends RuntimeException {
	public NoAccountException() {}
	public NoAccountException(String message) {
		super(message);
	}
}

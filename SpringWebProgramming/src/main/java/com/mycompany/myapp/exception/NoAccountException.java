package com.mycompany.myapp.exception;

//Spring���� transaction ó���ϱ� ���ؼ��� runtimeException�� �߻��Ǿ�� �Ѵ�
public class NoAccountException extends RuntimeException {
	public NoAccountException() {}
	public NoAccountException(String message) {
		super(message);
	}
}
